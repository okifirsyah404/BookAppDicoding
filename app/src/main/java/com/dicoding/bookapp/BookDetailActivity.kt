package com.dicoding.bookapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookDetailActivity : AppCompatActivity() {

    private lateinit var tvBookTitle: TextView
    private lateinit var tvBookAuthor: TextView
    private lateinit var tvBookPublisher: TextView
    private lateinit var tvBookPages: TextView
    private lateinit var tvBookDescription: TextView
    private lateinit var imgBookCover: ImageView

    private lateinit var tvBookSpecSubitle: TextView
    private lateinit var tvBookSpecAuthor: TextView
    private lateinit var tvBookSpecPublisher: TextView
    private lateinit var tvBookSpecISBN: TextView
    private lateinit var tvBookSpecPages: TextView
    private lateinit var tvBookSpecGenre: TextView
    private lateinit var tvBookSpecPublishDate: TextView
    private lateinit var tvBookSpecLanguage: TextView

    private lateinit var bookTitle: String
    private lateinit var bookAuthor: String

    private fun initComponent() {
        tvBookTitle = findViewById(R.id.tv_item_title)
        tvBookAuthor = findViewById(R.id.tv_item_author)
        tvBookPublisher = findViewById(R.id.tv_item_publisher)
        tvBookPages = findViewById(R.id.tv_item_pages)
        tvBookDescription = findViewById(R.id.tv_item_description)
        imgBookCover = findViewById(R.id.img_item_cover)

        tvBookSpecSubitle = findViewById(R.id.tv_item_spec_subtitle)
        tvBookSpecAuthor = findViewById(R.id.tv_item_spec_author)
        tvBookSpecPublisher = findViewById(R.id.tv_item_spec_publisher)
        tvBookSpecISBN = findViewById(R.id.tv_item_spec_isbn)
        tvBookSpecPages = findViewById(R.id.tv_item_spec_pages)
        tvBookSpecGenre = findViewById(R.id.tv_item_spec_genre)
        tvBookSpecPublishDate = findViewById(R.id.tv_item_spec_publish_date)
        tvBookSpecLanguage = findViewById(R.id.tv_item_spec_language)
    }

    companion object {
        const val EXTRA_BOOK = "extra_book"
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        val book = intent.extras?.getParcelable<Book>(EXTRA_BOOK)
        tvBookTitle.text = book?.title
        tvBookAuthor.text = book?.author
        tvBookPublisher.text = book?.publisher
        tvBookPages.text = "${book?.pages} halaman"
        tvBookDescription.text = book?.description
        if (book != null) {
            imgBookCover.setImageResource(book.cover)
        }

        tvBookSpecSubitle.text = book?.subtitle
        tvBookSpecAuthor.text = book?.author
        tvBookSpecPublisher.text = book?.publisher
        tvBookSpecISBN.text = book?.isbn
        tvBookSpecPages.text = "${book?.pages} halaman"
        tvBookSpecGenre.text = book?.genre
        tvBookSpecPublishDate.text = book?.publishDate
        tvBookSpecLanguage.text = book?.language

        bookTitle = book?.subtitle.toString()
        bookAuthor = book?.author.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Buku"

        initComponent()

        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_book, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        R.id.action_share -> {
            val shareIntent = Intent(Intent.ACTION_SEND).setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "${bookTitle} by $bookAuthor")
            startActivity(Intent.createChooser(shareIntent, "Bagikan Dengan..."))
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}