package com.example.starwarsmvpapp.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.starwarsmvpapp.main.views.CharactersFragment
import com.example.starwarsmvpapp.main.views.PlanetsFragment
import com.example.starwarsmvpapp.main.views.StarshipsFragment

class FragmentAdapter(
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    //How many fragments we are using
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CharactersFragment.newInstance()
            1 -> PlanetsFragment.newInstance()
            2 -> StarshipsFragment.newInstance()
            else -> CharactersFragment.newInstance()
        }
    }
}