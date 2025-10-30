package com.example.ahorcadogame

import Level
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LevelAdapter(
    private val levels: List<Level>,
    private val onItemClick: (Level) -> Unit
) : RecyclerView.Adapter<LevelAdapter.LevelViewHolder>() {

    class LevelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val levelImage: ImageView = view.findViewById(R.id.levelImage)
        val wordText: TextView = view.findViewById(R.id.wordText)
        val lettersText: TextView = view.findViewById(R.id.lettersText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)
        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val level = levels[position]
        holder.levelImage.setImageResource(level.imageRes)
        holder.wordText.text = level.name
        holder.lettersText.text = "Letras: ${level.letters}"

        holder.itemView.setOnClickListener {
            onItemClick(level)
        }
    }

    override fun getItemCount(): Int = levels.size
}