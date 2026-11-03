package Arell.Andre.composepokedex.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import Arell.Andre.model.data.Users
import Arell.Andre.composepokedex.dummies.getPokemon
import Arell.Andre.composepokedex.dummies.showAllPokemons
import Arell.Andre.view.components.MenuPokedex
import Arell.Andre.view.screens.LoginScreen
import Arell.Andre.view.screens.PokemonDetailScreen
import Arell.Andre.view.screens.RegisterScreen
import Arell.Andre.view.viewmodel.UserViewModel

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val users = remember(context) { Users(context) }
    val userViewModel: UserViewModel = viewModel(factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = UserViewModel(users) as T
    })

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            if (userViewModel.isLoggedIn()) {
                androidx.compose.runtime.LaunchedEffect(Unit) {
                    navController.navigate("pokemon_list") {
                        popUpTo("login") { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                LoginScreen(viewModel = userViewModel, onLogin = {
                    navController.navigate("pokemon_list") {
                        popUpTo("login") { inclusive = true }
                        launchSingleTop = true
                    }
                })
            }
        }
        composable("register") { RegisterScreen(onBack = { navController.popBackStack() }) }
        composable("pokemon_list") {
            MenuPokedex(
                pokemonList = showAllPokemons(),
                innerPadding = PaddingValues(),
                isGrid = userViewModel.gridDisplay,
                onGridChange = userViewModel::updateGridDisplay,
                onLogout = {
                    userViewModel.logout()
                    navController.navigate("login") {
                        popUpTo("pokemon_list") { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onPokemonClick = { pokemon ->
                    navController.navigate("pokemon_detail/${pokemon.number}")
                }
            )
        }
        composable("pokemon_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: return@composable
            val pokemons = showAllPokemons()
            val pokemon = getPokemon(id)
            val index = pokemons.indexOfFirst { it.number == id }
            val previous = if (index > 0) pokemons[index - 1] else null
            val next = if (index >= 0 && index < pokemons.lastIndex) pokemons[index + 1] else null
            PokemonDetailScreen(
                pokemon = pokemon,
                neighbors = Pair(previous, next),
                onNavigate = { selectedPokemon ->
                    navController.navigate("pokemon_detail/${selectedPokemon.number}") {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

