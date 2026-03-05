package Arellano.Andre.composepokedex.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import Arellano.Andre.composepokedex.R

@Composable
fun PokemonNavItem(position: String, image: Int, name: String, number: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = image), contentDescription = "Imagen de $name", modifier = Modifier.size(70.dp))
        val formattedNumber = number.toString().padStart(4, '0')
        val textValue = "$name N.º $formattedNumber"

        if (position.lowercase() == "left") {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(24.dp).background(Color.DarkGray, CircleShape), contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null, tint = Color.White)
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = textValue, color = Color.DarkGray, fontSize = 12.sp)
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = textValue, color = Color.DarkGray, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(6.dp))

                Box(modifier = Modifier.size(24.dp).background(Color.DarkGray, CircleShape), contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun PokemonFooter(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PokemonNavItem(
            position = "left",
            image = R.drawable.arbok_poke,
            name = "Arbok",
            number = 24
        )

        PokemonNavItem(
            position = "right",
            image = R.drawable.raichu,
            name = "Raichu",
            number = 26
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FooterPreview(){
    PokemonFooter()
}