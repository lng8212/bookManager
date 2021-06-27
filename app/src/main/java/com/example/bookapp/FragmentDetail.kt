package com.example.bookapp

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.bookapp.databinding.FragmentDetailBinding
import com.example.bookapp.model.Book

class FragmentDetail : Fragment() {

    lateinit var imgbook: ImageView
    lateinit var title: TextView
    lateinit var author: TextView
    lateinit var pages: TextView
    lateinit var rate: TextView
    lateinit var ratingBar: RatingBar
    lateinit var description: TextView
    lateinit var binding: FragmentDetailBinding
    lateinit var link: TextView
    lateinit var book : Book
    val SEARCH_PREFIX = "https://www.google.com/search?q="
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            book = it.getSerializable("bookObject") as Book
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgbook = binding.itemBookImg
        ratingBar = binding.itemBookRatingbar
        title = binding.itemBookTitle
        author = binding.itemBookAuthor
        pages = binding.itemBookPagesrev
        rate = binding.itemBookScore
        description = binding.detailsDesc
        link = binding.hyperLink
        link.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        loadBookData(book)
        link.setOnClickListener(){
            link.paintFlags = Paint.FAKE_BOLD_TEXT_FLAG
            val queryURL: Uri = Uri.parse("${FragmentDetail().SEARCH_PREFIX}${title.text}${" Sách"}")
            val intent = Intent(Intent.ACTION_VIEW, queryURL)
            startActivity(intent)
        }


    }
    fun loadBookData(item: Book) {
        Glide.with(this).load(item.drawableResource).into(imgbook)
        ratingBar.rating = item.rating
        author.text = item.author
        title.text = item.title
        pages.text = item.pages.toString() + " pages | " + item.review.toString() + " review"
        rate.text = item.rating.toString()
        description.text = item.description
    }



}