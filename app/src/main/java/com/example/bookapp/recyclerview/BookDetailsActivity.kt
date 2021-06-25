package com.example.bookapp.recyclerview

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.bookapp.databinding.ActivityBookDetailsBinding
import com.example.bookapp.model.Book

class BookDetailsActivity : AppCompatActivity() {
    lateinit var imgbook: ImageView
    lateinit var title: TextView
    lateinit var author: TextView
    lateinit var pages: TextView
    lateinit var rate: TextView
    lateinit var ratingBar: RatingBar
    lateinit var description: TextView
    lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ); //enable full screen
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imgbook = binding.itemBookImg
        ratingBar = binding.itemBookRatingbar
        title = binding.itemBookTitle
        author = binding.itemBookAuthor
        pages = binding.itemBookPagesrev
        rate = binding.itemBookScore
        description = binding.detailsDesc
        val item: Book = intent.getSerializableExtra("bookObject") as Book
        loadBookData(item)
    }

    fun loadBookData(item: Book) {
        Glide.with(this).load(item.drawableResource).into(imgbook)
        ratingBar.rating = item.rating
        author.text = item.author
        title.text = item.title
        pages.text = item.pages.toString()
        rate.text = item.rating.toString()
        description.text = item.description
    }
}