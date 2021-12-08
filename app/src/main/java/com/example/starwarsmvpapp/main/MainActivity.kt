package com.example.starwarsmvpapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starwarsmvpapp.R
import com.example.starwarsmvpapp.databinding.ActivityMainBinding
import com.example.starwarsmvpapp.main.adapters.FragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.starWarsContainer.adapter = FragmentAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.starWarsMenu, binding.starWarsContainer){ tab, position ->
            when(position){
                0 -> {
                    tab.text = "Characters"
                    tab.icon = getDrawable(R.drawable.ic_chars_foreground)
                }
                1 -> {
                    tab.text = "Planets"
                    tab.icon = getDrawable(R.drawable.ic_planets_foreground)
                }
                else -> {
                    tab.text = "Starships"
                    tab.icon = getDrawable(R.drawable.ic_starship_foreground)
                }
            }
        }.attach()
    }
}