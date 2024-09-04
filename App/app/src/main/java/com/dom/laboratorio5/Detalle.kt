package com.dom.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dom.laboratorio5.ui.theme.Laboratorio5Theme

class Detalle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DetalleScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DetalleScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        // Imagen en la mitad superior
        Image(
            painter = painterResource(id = R.drawable.conciertoej), // Reemplaza con tu recurso de imagen
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)  // Toma la mitad de la pantalla
        )
        // Sección de detalles
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(16.dp)
        ) {
            Text(
                text = "Título del Evento",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Lugar del Evento",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Fecha: 01/01/2024",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hora: 20:00",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Descripción larga del evento. Aquí se incluye información detallada sobre el evento, lo que puedes esperar, y cualquier otra información relevante que el usuario necesita saber. La descripción puede ser extensa y proporcionar detalles completos sobre lo que sucederá en el evento.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.weight(1f))  // Empuja los botones hacia el fondo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Acción de "Favorito" */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Favorito")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Acción de "Comprar" */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Comprar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetalleScreenPreview() {
    Laboratorio5Theme {
        DetalleScreen()
    }
}
