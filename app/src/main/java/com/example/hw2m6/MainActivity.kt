package com.example.hw2m6

import android.content.Intent
import android.graphics.PorterDuff.Mode
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import com.example.hw2m6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<Model>()

    private val listSelect = arrayListOf<Model>()

    private lateinit var adapter: Adapter

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
        initView()
        imageSend()
    }

    fun imageSend() {
        list.add(Model(R.drawable.ic_1, true))
        list.add(Model(R.drawable.ic_2, true))
        list.add(Model(R.drawable.ic_1, true))
        list.add(Model(R.drawable.ic_2, true))
        list.add(Model(R.drawable.ic_1, true))
        list.add(Model(R.drawable.ic_2, true))
        list.add(Model(R.drawable.ic_1, true))
        list.add(Model(R.drawable.ic_2, true))
        list.add(Model(R.drawable.ic_1, true))
        list.add(Model(R.drawable.ic_2, true))
    }

    private fun initView() {

        adapter = Adapter(list, this::onClick)
        binding.recyclerview.adapter = adapter
    }

    private fun onClick(imageModel: Model) {
        imageModel.select = !imageModel.select
        if (imageModel.select) {
            listSelect.add(imageModel)
        } else {
            listSelect.remove(imageModel)
        }
    }

    fun loadImage() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("key", listSelect)
            startActivity(intent)
        }


    }
}