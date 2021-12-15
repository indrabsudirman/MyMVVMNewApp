package id.indrasudirman.mymvvmnewapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.adapters.NewsAdapter
import id.indrasudirman.mymvvmnewapp.databinding.ActivityNewsBinding.inflate
import id.indrasudirman.mymvvmnewapp.databinding.FragmentBreakingNewsBinding
import id.indrasudirman.mymvvmnewapp.ui.NewsActivity
import id.indrasudirman.mymvvmnewapp.ui.NewsViewModel
import id.indrasudirman.mymvvmnewapp.util.Resource

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    // View Binding
    private lateinit var fragmentBreakingNewsBinding: FragmentBreakingNewsBinding

    val TAG = "BreakingNewsFragment"




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = (activity as NewsActivity).viewModel

        fragmentBreakingNewsBinding = FragmentBreakingNewsBinding.bind(view)

        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "an error occurred: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        fragmentBreakingNewsBinding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        fragmentBreakingNewsBinding.paginationProgressBar.visibility = View.VISIBLE
    }


    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        fragmentBreakingNewsBinding.recyclerViewBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}