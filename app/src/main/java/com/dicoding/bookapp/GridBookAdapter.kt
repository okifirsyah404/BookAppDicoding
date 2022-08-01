package com.dicoding.bookapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GridBookAdapter(private val listBook: ArrayList<Book>): RecyclerView.Adapter<GridBookAdapter.GridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_grid_book, parent, false))
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val book = listBook[position]

        Glide.with(holder.itemView.context)
            .load(book.cover)
            .into(holder.imgBookCover)

        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author
        holder.tvGenre.text = book.genre

        holder.itemView.setOnClickListener{
            val  intent = Intent(holder.itemView.context, BookDetailActivity::class.java)
            intent.putExtra("extra_book", Book(book.title, book.subtitle, book.author, book.genre, book.pages, book.publisher, book.isbn, book.publishDate, book.description, book.cover, book.language))
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author)
        var tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre)
        var imgBookCover: ImageView = itemView.findViewById(R.id.img_item_cover)

    }
}