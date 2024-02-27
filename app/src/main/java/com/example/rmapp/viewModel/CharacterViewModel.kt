package com.example.rmapp.viewModel

import AllCharacter
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rmapp.data.CharacterRepo
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    private val repository = CharacterRepo()

    private val appCharacters = MutableLiveData<AllCharacter>()
    val characters: LiveData<AllCharacter> = appCharacters

    fun fetchCharacters() {
        viewModelScope.launch {
            val characterResult = repository.getCharacters()
            appCharacters.value = characterResult
        }
    }
}