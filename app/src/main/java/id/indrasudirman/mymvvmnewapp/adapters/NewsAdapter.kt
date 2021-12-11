package id.indrasudirman.mymvvmnewapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*
import id.indrasudirman.mymvvmnewapp.R
import id.indrasudirman.mymvvmnewapp.databinding.ItemArticlePreviewBinding
import id.indrasudirman.mymvvmnewapp.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemArticlePreviewBinding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(itemArticlePreviewBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemArticlePreviewBinding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context),
        parent,
        false)

        return ArticleViewHolder(itemArticlePreviewBinding)

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]

//        holder.itemView.app

//        holder.itemView.apply {
//
//            Glide.with(this).load(article.urlToImage).into(itemArticlePreviewBinding.iv) //name view
//        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}