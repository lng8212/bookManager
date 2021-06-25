package com.example.bookapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.bookapp.databinding.ItemBookBinding
import com.example.bookapp.model.Book

class BookAdapter(var mdata: List<Book>, var callback: BookCallback) :
    RecyclerView.Adapter<BookAdapter.bookviewholder>() {

    inner class bookviewholder(val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var imgContainer: ImageView = binding.container
        var imgBook: ImageView = binding.itemBookImg
        var title: TextView = binding.itemBookTitle
        var author: TextView = binding.itemBookAuthor
        var pages: TextView = binding.itemBookPagesrev
        var rate: TextView = binding.itemBookScore
        var ratingBar: RatingBar = binding.itemBookRatingbar

        init {
            itemView.setOnClickListener() {
                callback.onBookItemClick(
                    adapterPosition,
                    imgContainer,
                    imgBook,
                    title,
                    author,
                    pages,
                    rate,
                    ratingBar
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookviewholder {
        var binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return bookviewholder(binding)
    }

    override fun onBindViewHolder(holder: bookviewholder, position: Int) {
        Glide.with(holder.itemView.context).load(mdata.get(position).drawableResource)
            .transforms(CenterCrop(), RoundedCorners(16)).into(holder.imgBook)
        holder.title.text = mdata.get(position).title
        holder.author.text = mdata.get(position).author
        holder.pages.text =
            mdata.get(position).pages.toString() + " pages | " + mdata.get(position).review.toString() + " review"
        holder.rate.text = mdata.get(position).rating.toString()
        holder.ratingBar.rating = mdata.get(position).rating

    }


    override fun getItemCount(): Int {
        return mdata.size
    }
}