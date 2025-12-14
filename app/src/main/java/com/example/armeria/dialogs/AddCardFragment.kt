package com.example.armeria.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.armeria.databinding.FragmentAddBinding
import com.example.armeria.models.Arma

class AddCardFragment : DialogFragment() {

    interface AddCardListener {
        fun onCardAdded(arma: Arma)
    }

    private lateinit var listener: AddCardListener
    private lateinit var binding: FragmentAddBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as AddCardListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val category = binding.editTextCategory.text.toString()
            val cost = binding.editTextcost.text.toString()
            val image = binding.editTextImage.text.toString()

            if (name.isNotEmpty() && category.isNotEmpty() && cost.isNotEmpty() && image.isNotEmpty()) {
                val newArma = Arma(name, category, cost, image)
                listener.onCardAdded(newArma)
                dismiss()
            }
        }

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }
}