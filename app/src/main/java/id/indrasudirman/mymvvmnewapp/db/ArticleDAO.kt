package id.indrasudirman.mymvvmnewapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import id.indrasudirman.mymvvmnewapp.models.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    fun deleteArticle(article: Article)
}