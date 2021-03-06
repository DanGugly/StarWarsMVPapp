package com.example.starwarsmvpapp.main.presenters

import android.util.Log
import com.example.starwarsmvpapp.main.model.characters.StarChars
import com.example.starwarsmvpapp.main.rest.StarWarsRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * This class will be your presenter that will handle the logic for the characters.
 *
 * Everytime we instantiate the presenter class we need to pass the view contract as a parameter
 */
class CharactersPresenter(
    private val characterViewContract: ICharactersView
) : ICharactersPresenter {

    // This method that is being override from the contract in presenter
    // this is one of the capabilities of our presenter
    // will make call to server and then retrieve the data
    override fun getCharacterFromServer() {
        // I am retrieving the character from server
        // changing to the worker thread
        // observing on the main thread
        // and subscribing to get the data
        let {
            StarWarsRetrofit.getNetworkApi()
                .retrieveCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { characters ->
                        // here I am calling the characters updated method from the view contract interface
                        // in order to update the view

                        // here we can use the 'let' scope block
                        characters?.let {
                            Log.d("SERVERDATA",characters.toString())
                            characterViewContract.characterUpdated(characters.StarChars)
                        }

//                        if (characters!=null){
//                            Log.d("SERVERDATA",characters.toString())
//                            characterViewContract.characterUpdated(characters.StarChars)
//                        }
                    },
                    { throwable ->
                        // I am updating hte view contract when an error occurs
                        characterViewContract.onErrorData(throwable)
                    }
                )
        }
    }
}

interface ICharactersPresenter {
    fun getCharacterFromServer()
}

interface ICharactersView {
    fun characterUpdated(characters: List<StarChars>?)
    fun onErrorData(error: Throwable)
}