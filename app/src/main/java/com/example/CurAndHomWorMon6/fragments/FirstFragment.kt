package com.projectx.CurAndHomWorMon6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.CurAndHomWorMon6.Resource
import com.projectx.CurAndHomWorMon6.databinding.FragmentFirstBinding
import com.projectx.CurAndHomWorMon6.adapter.AppAdapter
import com.projectx.CurAndHomWorMon6.viewModel.FragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var appAdapter: AppAdapter
    private val viewModel by lazy {
        ViewModelProvider(this)[FragmentViewModel::class.java]
    }
    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvApp

        // Инициализация адаптера
        appAdapter = AppAdapter { character ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(character)
            findNavController().navigate(action)
        }
        recyclerView.adapter = appAdapter

        // Наблюдение за данными из ViewModel
        viewModel.characters.observe(viewLifecycleOwner) { res ->
            binding.progresBar.isVisible = res is Resource.Loading

            when (res) {
                is Resource.Loading -> {
                    // Можно оставить пустым, так как вы уже управляете видимостью ProgressBar выше
                }
                is Resource.Error -> {
                    // Обработка ошибки
                    Toast.makeText(requireContext(), res.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    // Обновление списка в адаптере
                    appAdapter.submitList(res.data)
                }
            }
        }
    }
}



