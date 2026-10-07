package Arell.Andre.model.data

import Arell.Andre.composepokedex.R
import Arell.Andre.model.domain.Pokemon

val pokemonList = listOf(

    Pokemon(
        name = "Bulbasaur",
        number = 1,
        type = "Grass/Poison",
        description = "There is a plant seed on its back from the day this Pokémon is born.",
        height = 0.7f,
        weight = 6.9f,
        fav = false,
        ability = "Overgrow",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Charmander",
        number = 4,
        type = "Fire",
        description = "The flame on its tail shows the strength of its life force.",
        height = 0.6f,
        weight = 8.5f,
        fav = true,
        ability = "Blaze",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Squirtle",
        number = 7,
        type = "Water",
        description = "After birth, its back swells and hardens into a shell.",
        height = 0.5f,
        weight = 9.0f,
        fav = false,
        ability = "Torrent",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Pikachu",
        number = 25,
        type = "Electric",
        description = "When several of these Pokémon gather, their electricity could build and cause lightning storms.",
        height = 0.4f,
        weight = 6.0f,
        fav = true,
        ability = "Static",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Jigglypuff",
        number = 39,
        type = "Normal/Fairy",
        description = "Uses its alluring eyes to enrapture its foe, then sings a pleasant melody to lull them to sleep.",
        height = 0.5f,
        weight = 5.5f,
        fav = false,
        ability = "Cute Charm",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Gengar",
        number = 94,
        type = "Ghost/Poison",
        description = "Under a full moon, this Pokémon likes to mimic the shadows of people and laugh at their fright.",
        height = 1.5f,
        weight = 40.5f,
        fav = true,
        ability = "Cursed Body",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Snorlax",
        number = 143,
        type = "Normal",
        description = "Its stomach is said to be so strong that it can even eat moldy or rotten food.",
        height = 2.1f,
        weight = 460.0f,
        fav = false,
        ability = "Immunity",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Mewtwo",
        number = 150,
        type = "Psychic",
        description = "It was created by a scientist after years of horrific gene-splicing and DNA engineering experiments.",
        height = 2.0f,
        weight = 122.0f,
        fav = true,
        ability = "Pressure",
        image = R.drawable.pikachu
    ),

    Pokemon(
        name = "Lucario",
        number = 448,
        type = "Fighting/Steel",
        description = "By catching the aura emanating from others, it can read their thoughts and movements.",
        height = 1.2f,
        weight = 54.0f,
        fav = true,
        ability = "Steadfast",
        image = R.drawable.lucario
    ),

    Pokemon(
        name = "Mimikyu",
        number = 778,
        type = "Ghost/Fairy",
        description = "Its actual appearance is unknown. A scholar who saw what was under its rag was overwhelmed by terror.",
        height = 0.2f,
        weight = 0.7f,
        fav = false,
        ability = "Disguise",
        image = R.drawable.pikachu
    )
)

val onePokemon = pokemonList.first()