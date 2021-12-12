package id.indrasudirman.mymvvmnewapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.databinding.ActivityNewsBinding
import id.indrasudirman.mymvvmnewapp.db.ArticleDatabase
import id.indrasudirman.mymvvmnewapp.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    private lateinit var newsBinding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsBinding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(newsBinding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        val navNewsHostFragment = supportFragmentManager.findFragmentById(R.id.news_nav_graph)

        if (navNewsHostFragment != null) {
            newsBinding.bottomNavigationView.setupWithNavController(navNewsHostFragment.findNavController())
        }


    }
}