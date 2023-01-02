package com.generic.adapter.utils

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView

/**
 *  Animation Function
 *  */
fun RecyclerView.ViewHolder.setAnimation(animation: Int?) = try {
    animation?.let {
        this.itemView.animation = AnimationUtils.loadAnimation(this.itemView.context, it)
    }
} catch (e: Exception) {
    e.printStackTrace()
}