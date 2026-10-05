package Arell.Andre.composepokedex.navigation

import Arell.Andre.composepokedex.components.MenuPokedex
import Arell.Andre.composepokedex.dummies.getPokemon
import Arell.Andre.composepokedex.dummies.showAllPokemons
import Arell.Andre.composepokedex.screens.LoginScreen
import Arell.Andre.composepokedex.screens.PokemonDetailScreen
import Arell.Andre.composepokedex.screens.RegisterScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // LOGIN
        composable("login") {

            LoginScreen(
                onLogin = {

                    navController.navigate(
                        "pokemon_list"
                    ) {

                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },

                onRegister = {
                    navController.navigate(
                        "register"
                    )
                }
            )
        }

        // REGISTRO
        composable("register") {

            RegisterScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // POKÉDEX
        composable("pokemon_list") {

            val pokemons = showAllPokemons()

            MenuPokedex(
                pokemonList = pokemons,
                innerPadding = PaddingValues(),
                onPokemonClick = { pokemon ->

                    navController.navigate(
                        "pokemon_detail/${pokemon.number}"
                    )
                }
            )
        }

        // DETALLE
        composable(
            route = "pokemon_detail/{id}"
        ) { backStackEntry ->

            val id = backStackEntry
                .arguments
                ?.getString("id")
                ?.toIntOrNull()
                ?: return@composable

            val pokemons = showAllPokemons()

            val pokemon = getPokemon(id)

            val index = pokemons.indexOfFirst {
                it.number == id
            }

            val previous =
                if (index > 0) {
                    pokemons[index - 1]
                } else {
                    null
                }

            val next =
                if (
                    index >= 0 &&
                    index < pokemons.lastIndex
                ) {
                    pokemons[index + 1]
                } else {
                    null
                }

            PokemonDetailScreen(
                pokemon = pokemon,
                neighbors = Pair(
                    previous,
                    next
                ),
                onNavigate = { selectedPokemon ->

                    navController.navigate(
                        "pokemon_detail/${selectedPokemon.number}"
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}