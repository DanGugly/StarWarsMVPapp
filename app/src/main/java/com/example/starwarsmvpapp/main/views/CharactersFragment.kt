package com.example.starwarsmvpapp.main.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarsmvpapp.databinding.FragmentCharacterBinding
import com.example.starwarsmvpapp.main.adapters.CharactersAdapter
import com.example.starwarsmvpapp.main.model.characters.StarChars
import com.example.starwarsmvpapp.main.presenters.CharactersPresenter
import com.example.starwarsmvpapp.main.presenters.ICharactersView

class CharactersFragment : Fragment(), ICharactersView {

    private val presenter : CharactersPresenter by lazy {
        CharactersPresenter(this)
    }

    private lateinit var binding: FragmentCharacterBinding
    private val charactersAdapter = CharactersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        binding.charactersRecycler.apply{
            // adding the layout manager
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            // setting the adapter
            adapter = charactersAdapter
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        //Retrieve data from server, result posted into viewcontract by methods characterupdated and onerrordata
        presenter.getCharacterFromServer()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CharactersFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
    override fun characterUpdated(characters: List<StarChars>?) {
        if (characters != null) {
            charactersAdapter.updateCharacters(characters)
        }
    }

    override fun onErrorData(error: Throwable) {
        Log.d("NetErr", error.localizedMessage)
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_LONG).show()
    }
}