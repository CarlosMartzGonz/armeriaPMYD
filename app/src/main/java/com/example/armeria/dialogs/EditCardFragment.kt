package com.example.armeria.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.armeria.databinding.FragmentEditBinding
import com.example.armeria.models.Arma

class EditCardFragment : DialogFragment() {

    interface EditCardListener {
        fun onCardEdited(arma: Arma, position: Int)
    }

    private var listener: EditCardListener? = null
    private lateinit var arma: Arma
    private lateinit var binding: FragmentEditBinding

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

        listener = parentFragment as? EditCardListener ?: activity as? EditCardListener

        arguments?.let {
            val nombre = it.getString("nombre", "")
            val categoria = it.getString("categoria", "")
            val coste = it.getString("coste", "")
            val imagen = it.getString("imagen", "")
            val informacion = it.getString("informacion", "")

            arma = Arma(nombre, categoria, coste, imagen, informacion)
        }

        binding.editTextName.setText(arma.nombre)
        binding.editTextCategory.setText(arma.categoria)
        binding.editTextCost.setText(arma.coste)
        binding.editTextImage.setText(arma.imagen)
        binding.editTextInfo.setText(arma.informacion)

        binding.buttonSave.setOnClickListener {
            val updatedArma = Arma(
                binding.editTextName.text.toString(),
                binding.editTextCategory.text.toString(),
                binding.editTextCost.text.toString(),
                binding.editTextImage.text.toString(),
                binding.editTextInfo.text.toString()
            )
            listener?.onCardEdited(updatedArma, arguments?.getInt("position") ?: -1)
            dismiss()
        }

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    companion object {
        fun newInstance(arma: Arma, position: Int): EditCardFragment {
            val fragment = EditCardFragment()
            val args = Bundle()
            args.putString("nombre", arma.nombre)
            args.putString("categoria", arma.categoria)
            args.putString("coste", arma.coste)
            args.putString("imagen", arma.imagen)
            args.putString("informacion", arma.informacion)
            args.putInt("position", position)
            fragment.arguments = args
            return fragment
        }
    }
}