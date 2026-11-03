package Arell.Andre.view.screens

import Arell.Andre.composepokedex.R
import Arell.Andre.view.viewmodel.UserViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: UserViewModel, onLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        // Imagen de Charizard del proyecto
        Image(
            painter = painterResource(id = R.drawable.charizard),
            contentDescription = "Fondo de Charizard",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Capa oscura para mejorar la lectura
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.65f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "POKÉDEX",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(Modifier.height(28.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray
                )
            )

            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray
                )
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    if (viewModel.login(email, password)) onLogin()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Iniciar sesión")
            }

            if (viewModel.loginError) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = viewModel.errorDescription,
                    color = Color(0xFFFF8080),
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}
