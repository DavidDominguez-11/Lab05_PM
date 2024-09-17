package com.dom.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dom.laboratorio5.ui.theme.Laboratorio5Theme

class Perfil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PerfilScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PerfilScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        // Sección de perfil
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Ajusta la altura según sea necesario
                .background(Color.LightGray) // Cambia este color según sea necesario
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iconoperfilej), // Reemplaza con tu icono de usuario
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "David Dominguez 23712",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
        // Sección de botones
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            PerfilOption(
                icon = painterResource(id = R.drawable.iconeditperfil), // Reemplaza con tu icono de editar perfil
                label = "Editar Perfil"
            )
            Spacer(modifier = Modifier.height(8.dp))
            PerfilOption(
                icon = painterResource(id = R.drawable.iconoeditcontrasena), // Reemplaza con tu icono de cambiar contraseña
                label = "Cambiar Contraseña"
            )
            Spacer(modifier = Modifier.height(8.dp))
            PerfilOption(
                icon = painterResource(id = R.drawable.icononotis), // Reemplaza con tu icono de notificaciones
                label = "Notificaciones"
            )
            Spacer(modifier = Modifier.height(8.dp))
            PerfilOption(
                icon = painterResource(id = R.drawable.iconofavorito), // Reemplaza con tu icono de favoritos
                label = "Favoritos"
            )
        }
    }
}

@Composable
fun PerfilOption(icon: Painter, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview() {
    Laboratorio5Theme {
        PerfilScreen()
    }
}