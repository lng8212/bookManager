package com.example.bookapp.recyclerview

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R

class CustomItemAnimator : DefaultItemAnimator() {
    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        if (holder != null) {
            holder.itemView.animation =
                AnimationUtils.loadAnimation(holder.itemView.context, R.anim.viewholder_remove_anim)
        }
        return super.animateRemove(holder)

    }

    override fun animateAdd(holder: RecyclerView.ViewHolder?): Boolean {
        if (holder != null) {
            holder.itemView.animation =
                AnimationUtils.loadAnimation(holder.itemView.context, R.anim.viewholder_add_amin)
        }
        return super.animateAdd(holder)
    }
}