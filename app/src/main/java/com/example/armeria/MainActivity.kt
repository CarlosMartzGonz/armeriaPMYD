package com.example.armeria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.armeria.controller.Controller
import com.example.armeria.databinding.ActivityMainBinding
import com.example.armeria.dialogs.AddCardFragment
import com.example.armeria.dialogs.EditCardFragment
import com.example.armeria.models.Arma

class MainActivity : AppCompatActivity(), AddCardFragment.AddCardListener, EditCardFragment.EditCardListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        controller = Controller(this, binding)
        controller.init { arma ->
            val dialog = EditCardFragment.newInstance(arma)
            dialog.show(supportFragmentManager, "EditCardFragment")
        }

        binding.floatingBtnAdd.setOnClickListener {
            val dialog = AddCardFragment()
            dialog.show(supportFragmentManager, "AddCardFragment")
        }
    }

    override fun onCardAdded(arma: Arma) {
        controller.addArma(arma)
    }

    override fun onCardEdited(arma: Arma) {
        controller.updateArma(arma)
    }
}