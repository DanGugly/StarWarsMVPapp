package com.example.starwarsmvpapp.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsmvpapp.R
import com.example.starwarsmvpapp.main.model.characters.StarChars

class CharactersAdapter(
    private val charactersList:MutableList<StarChars> = mutableListOf()
) : RecyclerView.Adapter<CharactersAdapterViewHolder>(){

    fun updateCharacters(newChars: List<StarChars>){
        charactersList.clear()
        charactersList.addAll(newChars)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersAdapterViewHolder {
        val forecastView = LayoutInflater.from(parent.context).inflate(
            R.layout.character_items,
            parent,
            false
        )
        return CharactersAdapterViewHolder(forecastView)
    }

    override fun onBindViewHolder(holder: CharactersAdapterViewHolder, position: Int) {
        val character = charactersList[position]
        holder.characterName.text = character.name
    }

    override fun getItemCount(): Int = charactersList.size

}

class CharactersAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val characterName : TextView = itemView.findViewById(R.id.character_name)
}