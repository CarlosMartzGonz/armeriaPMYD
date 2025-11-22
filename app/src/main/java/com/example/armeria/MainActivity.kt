package com.example.armeria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.armeria.R
import com.example.armeria.controller.Controller
import com.example.armeria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init(){
        initRecyclerView()
        controller = Controller(this)
        controller.setAdapter()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
    }
}


