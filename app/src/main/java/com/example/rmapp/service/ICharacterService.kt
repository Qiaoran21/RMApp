package com.example.rmapp.service

import AllCharacter
import retrofit2.http.GET

interface ICharacterService {
    @GET("character")
    suspend fun getCharacters(): AllCharacter
}