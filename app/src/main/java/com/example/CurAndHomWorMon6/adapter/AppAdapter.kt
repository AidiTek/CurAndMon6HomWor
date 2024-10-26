package com.projectx.CurAndHomWorMon6.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projectx.CurAndHomWorMon6.R
import com.projectx.CurAndHomWorMon6.databinding.CharacterItemBinding
import com.projectx.CurAndHomWorMon6.models.Character

class AppAdapter(
    private var characterList: List<Character>,
    private val onItemClick: (Character) -> Unit
) : RecyclerView.Adapter<AppAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.tvName.text = character.name
            binding.tvDeadOr.text = character.status
            binding.tvRase.text = character.species
            binding.tvLoc2.text = character.location.toString()
            binding.tvSeein2.text = character.created
            Glide.with(binding.ivImage.context)
                .load(character.image)
                .placeholder(R.drawable.lana)
                .into(binding.ivImage)

            itemView.setOnClickListener {
                onItemClick(character)
            }
            when (character.status) {
                "Alive" -> binding.statusIndicator.setBackgroundColor(Color.GREEN)
                "Dead" -> binding.statusIndicator.setBackgroundColor(Color.BLACK)
                "unknown" -> binding.statusIndicator.setBackgroundColor(Color.GRAY)
                else -> binding.statusIndicator.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size

    fun updateData(newCharacterList: List<Character>) {
        characterList = newCharacterList
        notifyDataSetChanged()
    }
}
