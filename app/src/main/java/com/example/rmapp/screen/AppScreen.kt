package com.example.rmapp.screen

import AllCharacter
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rmapp.viewModel.CharacterViewModel

@Composable
fun AppScreen(viewModel: CharacterViewModel) {
    val characters by viewModel.characters.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    Column {
        if (characters == null) {
            Text(text = "Loading..........")
        } else {
            CharacterItem(characters)
        }
    }
}

@Composable
fun CharacterItem(characters: AllCharacter?) {
    Column(modifier = Modifier) {
        characters?.characterList?.forEach { character ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Row {
                    AsyncImage(
                        model = character.image,
                        contentDescription = null,
                    )
                    Column {
                        Text(text = character.name)
                        Text("Species: ${character.species}")
                        Text("Gender: ${character.gender}")
                        Text("Origin: ${character.origin.name}")
                    }
                }
            }
        }
    }
}