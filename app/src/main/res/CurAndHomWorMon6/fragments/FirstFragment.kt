package com.projectx.CurAndHomWorMon6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

    private var characteList: List<Character> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val recyclerView = binding.rvApp


        appAdapter = AppAdapter(emptyList()) { character ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(character)
            findNavController().navigate(action)
        }



        recyclerView.adapter = appAdapter

        viewModel.characters.observe(viewLifecycleOwner, { characters ->
            appAdapter.updateData(characters)
        })
    }
}


