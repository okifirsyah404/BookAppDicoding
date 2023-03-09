package com.dicoding.bookapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListBookAdapter(private val listBook: ArrayList<Book>) :
    RecyclerView.Adapter<ListBookAdapter.ListBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListBookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: ListBookViewHolder, position: Int) {
        val book = listBook[position]

        Glide.with(holder.itemView.context)
            .load(book.cover)
            .into(holder.imgBookCover)

        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author
        holder.tvGenre.text = book.genre

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, BookDetailActivity::class.java)
            intent.putExtra(
                "extra_book",
                Book(
                    book.title,
                    book.subtitle,
                    book.author,
                    book.genre,
                    book.pages,
                    book.publisher,
                    book.isbn,
                    book.publishDate,
                    book.description,
                    book.cover,
                    book.language
                )
            )
            startActivity(holder.itemView.context, intent, null)
        }
    }

    inner class ListBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title) as TextView
        var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author) as TextView
        var tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre) as TextView
        var imgBookCover: ImageView = itemView.findViewById(R.id.img_item_cover) as ImageView

    }
}