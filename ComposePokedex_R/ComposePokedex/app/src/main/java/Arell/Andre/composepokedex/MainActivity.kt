package Arell.Andre.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import Arell.Andre.composepokedex.navigation.MyApp
import Arell.Andre.composepokedex.ui.theme.ComposePokedexTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposePokedexTheme {
                MyApp()
            }
        }
    }
}