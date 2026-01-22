package com.example.armeria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.armeria.databinding.FragmentProfileBinding
import com.example.armeria.objects_models.Session

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Session.usuarioLogueado?.let { usuario ->
            binding.tvUsername.text = usuario.username
            binding.tvEmail.text = "${usuario.username}@armeria.com"
            binding.tvRole.text = if (usuario.username == "admin") "Administrador" else "Usuario"

            Glide.with(this)
                .load(usuario.imagen)
                .circleCrop()
                .into(binding.ivProfileImage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}