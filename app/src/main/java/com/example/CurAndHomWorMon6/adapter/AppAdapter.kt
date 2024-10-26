package com.projectx.CurAndHomWorMon6.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projectx.CurAndHomWorMon6.R
import com.projectx.CurAndHomWorMon6.databinding.CharacterItemBinding
import com.projectx.CurAndHomWorMon6.models.Character

class AppAdapter(
    private val onItemClick: (Character) -> Unit
) : ListAdapter<Character, AppAdapter.CharacterViewHolder>(CharacterDiffCallback()) {

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.tvName.text = character.name
            binding.tvDeadOr.text = character.status
            binding.tvRase.text = character.species
            binding.tvLoc2.text = character.location.toString()
            binding.tvSeein2.text = character.created

            Glide.with(binding.ivImage.context)
                .load(character.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivImage)

            itemView.setOnClickListener { onItemClick(character) }
            binding.statusIndicator.setBackgroundColor(when (character.status) {
                "Alive" -> Color.GREEN
                "Dead" -> Color.BLACK
                "unknown" -> Color.GRAY
                else -> Color.TRANSPARENT
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}

