package com.example.armeria.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.armeria.databinding.FragmentEditBinding
import com.example.armeria.models.Arma

class EditCardFragment : DialogFragment() {

    interface EditCardListener {
        fun onCardEdited(arma: Arma)
    }

    private lateinit var listener: EditCardListener
    private lateinit var arma: Arma
    private lateinit var binding: FragmentEditBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as EditCardListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val nombre = it.getString("nombre", "")
            val categoria = it.getString("categoria", "")
            val coste = it.getString("coste", "")
            val imagen = it.getString("imagen", "")
            arma = Arma(nombre, categoria, coste, imagen)
        }

        binding.editTextName.setText(arma.nombre)
        binding.editTextCategory.setText(arma.categoria)
        binding.editTextCost.setText(arma.coste)
        binding.editTextImage.setText(arma.imagen)

        binding.buttonSave.setOnClickListener {
            val updatedArma = Arma(
                binding.editTextName.text.toString(),
                binding.editTextCategory.text.toString(),
                binding.editTextCost.text.toString(),
                binding.editTextImage.text.toString()
            )
            listener.onCardEdited(updatedArma)
            dismiss()
        }

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        fun newInstance(arma: Arma): EditCardFragment {
            val fragment = EditCardFragment()
            val args = Bundle()
            args.putString("nombre", arma.nombre)
            args.putString("categoria", arma.categoria)
            args.putString("coste", arma.coste)
            args.putString("imagen", arma.imagen)
            fragment.arguments = args
            return fragment
        }
    }
}