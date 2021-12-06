package id.indrasudirman.mymvvmnewapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var newsBinding: ActivityNewsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsBinding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(newsBinding.root)

        val navNewsHostFragment = supportFragmentManager.findFragmentById(R.id.news_nav_graph)

        if (navNewsHostFragment != null) {
            newsBinding.bottomNavigationView.setupWithNavController(navNewsHostFragment.findNavController())
        }


    }
}