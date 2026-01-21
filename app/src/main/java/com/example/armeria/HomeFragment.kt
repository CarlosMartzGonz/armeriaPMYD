package com.example.armeria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.armeria.adapter.AdapterArma
import com.example.armeria.dao.DaoArmas
import com.example.armeria.databinding.FragmentHomeBinding
import com.example.armeria.dialogs.AddCardFragment
import com.example.armeria.dialogs.EditCardFragment
import com.example.armeria.models.Arma

class HomeFragment : Fragment(), AddCardFragment.AddCardListener, EditCardFragment.EditCardListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AdapterArma
    private var listaDeArmas: MutableList<Arma> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaDeArmas = DaoArmas.myDao.getDataArmas().toMutableList()
        adapter = AdapterArma(
            armas = listaDeArmas,
            onEditClick = { arma ->
                val dialog = EditCardFragment.newInstance(arma)
                dialog.show(childFragmentManager, "EditCardFragment")
            },
            onDeleteClick = { arma ->
                val pos = listaDeArmas.indexOf(arma)
                if (pos != -1) {
                    listaDeArmas.removeAt(pos)
                    adapter.notifyItemRemoved(pos)
                }
            },
            onItemClick = { position ->
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(position)
                findNavController().navigate(action)
            }
        )
        binding.myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.myRecyclerView.adapter = adapter

        binding.floatingBtnAdd.setOnClickListener {
            val dialog = AddCardFragment()
            dialog.show(childFragmentManager, "AddCardFragment")
        }
    }

    override fun onCardAdded(arma: Arma) {
        listaDeArmas.add(arma)
        adapter.notifyItemInserted(listaDeArmas.size - 1)
    }

    override fun onCardEdited(arma: Arma) {
        val position = listaDeArmas.indexOfFirst { it.nombre == arma.nombre }
        if (position != -1) {
            listaDeArmas[position] = arma
            adapter.notifyItemChanged(position)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
