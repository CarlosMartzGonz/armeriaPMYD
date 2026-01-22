package com.example.armeria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.armeria.controller.Controller
import com.example.armeria.databinding.FragmentHomeBinding
import com.example.armeria.dialogs.AddCardFragment
import com.example.armeria.dialogs.EditCardFragment
import com.example.armeria.models.Arma

class HomeFragment : Fragment(), AddCardFragment.AddCardListener, EditCardFragment.EditCardListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var controller: Controller

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller = Controller(requireContext(), binding.myRecyclerView)

        controller.init(
            onEditClick = { arma ->
                val position = controller.getArmaPosition(arma)
                if (position != -1) {
                    val dialog = EditCardFragment.newInstance(arma, position)
                    dialog.show(childFragmentManager, "EditCardFragment")
                }
            },
            onDeleteClick = { arma ->
                val position = controller.getArmaPosition(arma)
                if (position != -1) {
                    controller.deleteArma(position)
                }
            },
            onItemClick = { position ->
                if (position < controller.getArmasCount()) {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(position)
                    findNavController().navigate(action)
                }
            }
        )

        binding.floatingBtnAdd.setOnClickListener {
            val dialog = AddCardFragment()
            dialog.show(childFragmentManager, "AddCardFragment")
        }
    }

    override fun onCardAdded(arma: Arma) {
        controller.addArma(arma)
    }

    override fun onCardEdited(arma: Arma, position: Int) {
        if (position != -1) {
            controller.updateArma(position, arma)
        }
    }

    override fun onResume() {
        super.onResume()
        controller.actualizarDatos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}