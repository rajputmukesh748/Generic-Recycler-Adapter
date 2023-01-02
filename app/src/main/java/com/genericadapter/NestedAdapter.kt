package com.genericadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generic.adapter.genericAdapter.GenericAdapter
import com.genericadapter.databinding.ItemUserBinding

/**
 * When Use Nested Adapter
 * */
class NestedAdapter {

    private val primitiveList by lazy {
        listOf(
            "Kotlin",
            "JAVA",
            "Python",
            "ReactJS",
            "NodeJS",
            "Angular"
        )
    }


    /**
     * Animation Adapter
     * */
    val firstAdapter =
        object : GenericAdapter<ItemUserBinding, String>(R.anim.slide_in_left) {
            override fun onCreateView(
                inflater: LayoutInflater,
                parent: ViewGroup,
                viewType: Int
            ) = ItemUserBinding.inflate(inflater, parent, false)

            override fun onBindHolder(
                binding: ItemUserBinding,
                dataClass: String
            ) {
                binding.tvMessage.text = dataClass.name
                binding.rvSecondAdapter.secondAdapter(
                    listOf(
                        "Kotlin",
                        "JAVA",
                        "Python",
                        "ReactJS",
                        "NodeJS",
                        "Angular"
                    )
                )
            }
        }


    /**
     * Second Adapter
     * */
    fun RecyclerView.secondAdapter(list: List<String>) {
        val secondAdapter =
            object : GenericAdapter<ItemUserBinding, String>(R.anim.slide_in_left) {
                override fun onCreateView(
                    inflater: LayoutInflater,
                    parent: ViewGroup,
                    viewType: Int
                ) = ItemUserBinding.inflate(inflater, parent, false)

                override fun onBindHolder(binding: ItemUserBinding, dataClass: String) {
                    binding.tvMessage.text = dataClass
                }
            }
        adapter = secondAdapter
        secondAdapter.submitList(list)
    }


    init {
        firstAdapter.submitList(primitiveList)
    }
}