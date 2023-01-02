package com.genericadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.generic.adapter.genericAdapter.GenericAdapter
import com.genericadapter.databinding.ItemUserBinding

class MainViewModel : ViewModel() {

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
    private val dataList by lazy {
        listOf(
            UserModel("Kotlin"),
            UserModel("JAVA"),
            UserModel("Python"),
            UserModel("ReactJS"),
            UserModel("NodeJS"),
            UserModel("Angular")
        )
    }


    /**
     * Primitive Data Type Adapter
     * */
    val primitiveAdapter = object : GenericAdapter<ItemUserBinding, String>() {
        override fun onCreateView(
            inflater: LayoutInflater,
            parent: ViewGroup,
            viewType: Int
        ) = ItemUserBinding.inflate(inflater, parent, false)

        override fun onBindHolder(binding: ItemUserBinding, dataClass: String) {
            binding.tvMessage.text = dataClass
        }
    }


    /**
     * Adapter With Model Class
     * */
    val adapter = object : GenericAdapter<ItemUserBinding, UserModel>() {
        override fun onCreateView(
            inflater: LayoutInflater,
            parent: ViewGroup,
            viewType: Int
        ) = ItemUserBinding.inflate(inflater, parent, false)

        override fun onBindHolder(binding: ItemUserBinding, dataClass: UserModel) {
            binding.tvMessage.text = dataClass.name
        }
    }


    /**
     * Animation Adapter
     * */
    val animationAdapter =
        object : GenericAdapter<ItemUserBinding, UserModel>(R.anim.slide_in_left) {
            override fun onCreateView(
                inflater: LayoutInflater,
                parent: ViewGroup,
                viewType: Int
            ) = ItemUserBinding.inflate(inflater, parent, false)

            override fun onBindHolder(binding: ItemUserBinding, dataClass: UserModel) {
                binding.tvMessage.text = dataClass.name
            }
        }


    /**
     * Initializer
     * */
    init {
        //Primitive Adapter List
        primitiveAdapter.submitList(primitiveList)

        //Adapter List Data
        adapter.submitList(dataList)

        //Animated Adapter List
        animationAdapter.submitList(dataList)
    }


    /**
     * Data Class
     * */
    data class UserModel(
        val name: String = ""
    )
}