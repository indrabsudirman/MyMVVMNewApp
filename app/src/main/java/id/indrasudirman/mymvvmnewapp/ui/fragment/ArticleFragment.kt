package id.indrasudirman.mymvvmnewapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.databinding.FragmentArticleBinding
import id.indrasudirman.mymvvmnewapp.ui.NewsActivity
import id.indrasudirman.mymvvmnewapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    //View Binding
    lateinit var fragmentArticleBinding: FragmentArticleBinding

    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel

        fragmentArticleBinding = FragmentArticleBinding.bind(view)

        val article = args.article
        fragmentArticleBinding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

    }
}