package com.genericadapter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.genericadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /** Variable Initialize */
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainViewModel>()


    /**
     * On Create View
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
    }


    /**
     * Set Adapter
     * */
    private fun setAdapter() {
        //Attach Adapter with Recycler View
        binding.rvRecycler.adapter = viewModel.primitiveAdapter
    }

}