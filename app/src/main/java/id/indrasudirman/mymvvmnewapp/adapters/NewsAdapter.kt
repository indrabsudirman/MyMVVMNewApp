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

    inner class ArticleViewHolder(val itemArticlePreviewBinding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(itemArticlePreviewBinding.root)

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

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//        val itemArticlePreviewBinding: ItemArticlePreviewBinding
        val article = differ.currentList[position]

//        holder.itemView.app

        holder.itemView.apply {

            //Video 6

//            Glide.with(this).load(article.urlToImage).into() //name view
            Glide.with(this).load(article.urlToImage).into(holder.itemArticlePreviewBinding.ivArticleImage)
            holder.itemArticlePreviewBinding.tvSource.text = article.source.name
            holder.itemArticlePreviewBinding.tvTitle.text = article.title
            holder.itemArticlePreviewBinding.tvDescription.text = article.description
            holder.itemArticlePreviewBinding.tvPublishedAt.text = article.publishedAt

            setOnItemClickListener {
                onItemClickListener?.let { it(article) }
            }

        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    private fun setOnItemClickListener (listener: (Article) -> Unit) {
        onItemClickListener = listener
    }


}