 package com.example.bookapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.bookapp.databinding.ItemBookBinding
import com.example.bookapp.model.Book

class BookAdapter(var mdata: MutableList<Book>, var callback: BookCallback) :
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
        fun binding (a: Book){
            itemView.setOnClickListener() {
                callback.sendData(a)

            }
        }

    }
    private fun deleteItem(index: Int){

    }
     val matchedData = mutableListOf<Book>().apply {
         mdata?.let {
             addAll(it)

         }
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookviewholder {
        var binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return bookviewholder(binding)
    }
    fun getFilter():Filter{
        return dataFilter
    }
    private val dataFilter = object:Filter(){
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterList = mutableListOf<Book>()
            if (constraint == null || constraint.isEmpty()){
                matchedData.let {
                    filterList.addAll(it)
                }
            }
            else {
                val query = constraint.toString().trim().toLowerCase()
                matchedData.forEach {
                    if (it.author.toLowerCase().contains(query) || it.title.toLowerCase().contains(query) || it.author.toLowerCase().contains(query)){
                        filterList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filterList
            return results

        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is List<*>){
                mdata.clear()
                mdata.addAll(results.values as MutableList<Book>)
                notifyDataSetChanged()
            }
        }
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
        holder.binding(mdata.get(position))

    }


    override fun getItemCount(): Int {
        return mdata.size
    }


}