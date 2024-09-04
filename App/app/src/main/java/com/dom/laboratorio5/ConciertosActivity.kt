package com.dom.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dom.laboratorio5.R
import com.dom.laboratorio5.ui.theme.Laboratorio5Theme

class ConciertosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                ConciertosScreen()
            }
        }
    }
}

@Composable
fun ConciertosScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HeaderSection()
        }
        item {
            SectionTitle(title = "Favoritos")
        }
        items(3) {  // Cambia el número para la cantidad de Cards que desees mostrar
            ConcertCard(
                title = "Concierto Favorito $it",
                description = "Descripción del concierto favorito $it",
                imageRes = R.drawable.ejemploeventoimg  // Reemplaza con tu recurso de imagen
            )
        }
        item {
            SectionTitle(title = "Todos los conciertos")
        }
        items(10) {  // Cambia el número para la cantidad de Cards que desees mostrar
            ConcertCard(
                title = "Concierto $it",
                description = "Descripción del concierto $it",
                imageRes = R.drawable.ejemploeventoimg  // Reemplaza con tu recurso de imagen
            )
        }
    }
}

@Composable
fun HeaderSection() {
    Text(
        text = "Todo eventos",
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun ConcertCard(title: String, description: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = description,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color.Gray
            )
        }
    }
}

