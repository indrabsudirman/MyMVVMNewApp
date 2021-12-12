package id.indrasudirman.mymvvmnewapp.repository

import id.indrasudirman.mymvvmnewapp.api.RetrofitInstance
import id.indrasudirman.mymvvmnewapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}