package Arell.Andre.viewmodel;

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import Arell.Andre.model.domain.Pokemon

 class PokemonViewModel: ViewModel()  {

     var wildokemon by mutableStateOf<Pokemon?>(null)

     fun capturePokemon(){

     }
}
