package id.indrasudirman.mymvvmnewapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.adapters.NewsAdapter
import id.indrasudirman.mymvvmnewapp.databinding.FragmentBreakingNewsBinding
import id.indrasudirman.mymvvmnewapp.databinding.FragmentSavedNewsBinding
import id.indrasudirman.mymvvmnewapp.ui.NewsActivity
import id.indrasudirman.mymvvmnewapp.ui.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    // View Binding
    private lateinit var fragmentSavedNewsBinding: FragmentSavedNewsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel

        fragmentSavedNewsBinding = FragmentSavedNewsBinding.bind(view)

        setupRecyclerView()

        fragmentSavedNewsBinding = FragmentSavedNewsBinding.bind(view)

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        fragmentSavedNewsBinding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}