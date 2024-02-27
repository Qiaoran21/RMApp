package com.example.rmapp.data

import AllCharacter
import android.util.Log
import com.example.rmapp.service.RetrofitInstance

class CharacterRepo {
    private val characterService = RetrofitInstance.characterService

    suspend fun getCharacters(): AllCharacter {
        return characterService.getCharacters()
    }
}
