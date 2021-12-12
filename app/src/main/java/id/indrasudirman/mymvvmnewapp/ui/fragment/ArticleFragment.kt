package id.indrasudirman.mymvvmnewapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.ui.NewsActivity
import id.indrasudirman.mymvvmnewapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }
}