package com.example.starwarsmvpapp.main.rest

import com.example.starwarsmvpapp.main.model.characters.Characters
import io.reactivex.Single
import retrofit2.http.GET

interface StarWarsApi {
    @GET(STAR_WARS_PEOPLE)
    fun retrieveCharacters(): Single<Characters>

    //TODO add model and return type
    @GET(STAR_WARS_PLANETS)
    fun retrievePlanets()
    //TODO add model and return type
    @GET(STAR_WARS_STARSHIPS)
    fun retrieveStarships()

    companion object{
        private const val STAR_WARS_PEOPLE = "api/people"
        private const val STAR_WARS_PLANETS = "api/planets"
        private const val STAR_WARS_STARSHIPS = "api/starships"
        const val BASE_URL = "https://www.swapi.tech/"
    }
}