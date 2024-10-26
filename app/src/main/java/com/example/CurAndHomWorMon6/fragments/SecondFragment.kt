package com.projectx.CurAndHomWorMon6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.projectx.CurAndHomWorMon6.R
import com.projectx.CurAndHomWorMon6.databinding.FragmentSecondBinding
import com.projectx.CurAndHomWorMon6.models.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }

    private var character: Character? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        character = arguments?.getParcelable("character")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        character?.let { it ->
            binding.characterName.text = it.name
            binding.characterStatus.text = it.status
            binding.characterGender.text = "Gender: ${it.gender}"
            binding.characterLocation.text = "Last known location: ${it.location.name}"
            binding.characterFirstSeen.text = "First seen in: ${it.episode.joinToString()}"

            Glide.with(this)
                .load(it.image)
                .placeholder(R.drawable.placeholder_image)
                .into(binding.characterImage)
        }
    }
}
