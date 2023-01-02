package com.generic.adapter.genericAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.AnimRes
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.generic.adapter.diffUtilCallBack.GenericDiffUtil
import com.generic.adapter.utils.setAnimation
import com.generic.adapter.viewHolder.AdapterViewHolder


/** <T> is used for Layout Type Binding */
/** <M> is used for Data Class for specific type */
/** Pass a <M> in DiffUtil Class */

abstract class GenericAdapter<T : ViewBinding, M>(@AnimRes val animation: Int? = null) :
    ListAdapter<M, RecyclerView.ViewHolder>(GenericDiffUtil<M>()) {

    /**
     * On Create View
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AdapterViewHolder(
            onCreateView(
                LayoutInflater.from(parent.context),
                parent,
                viewType
            )
        )
    }


    /**
     * onBind View Holder
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            if (holder is AdapterViewHolder) {
                holder.setAnimation(animation)
                @Suppress("UNCHECKED_CAST")
                onBindHolder(holder.binding as T, getItem(position))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * Get Resources Layout
     * */
    abstract fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ViewBinding


    /**
     * onBindHolder override
     * */
    abstract fun onBindHolder(binding: T, dataClass: M)

}