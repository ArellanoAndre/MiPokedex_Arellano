package Arell.Andre.view.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonDescription(
    description: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 14.dp)
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {

        Text(
            text = "INFORMACIÓN",
            color = Color(0xFF1F1F1F),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = description,
            color = Color(0xFF444444),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}