package com.example.armeria

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.armeria.controller.Controller
import com.example.armeria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        controller = Controller(this, binding)
        controller.init()

        binding.floatingBtnAdd.setOnClickListener {
            Toast.makeText(this, "Añadir nueva arma", Toast.LENGTH_SHORT).show()
        }
    }
}