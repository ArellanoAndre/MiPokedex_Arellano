package Arell.Andre.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun pokemonHuntScreen(Paddings: PaddingValues,) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { /*TODO*/ }) {

            Text(text = "buscar pokemon en la hierva")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun pokemonHuntScreenPreview() {
    pokemonHuntScreen(PaddingValues(15.dp))
}