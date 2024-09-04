package com.dom.laboratorio5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dom.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        Greeting(name = "Menu de visualizacion")
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { openConciertosActivity() }) {
                            Text("Ir a Conciertos")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { openListadoLugares() }) {
                            Text("Ir a Listado Lugares")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { openDetalles() }) {
                            Text("Ir a DEtalles")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { openPerfil() }) {
                            Text("Ir a perfil")
                        }
                    }
                }
            }
        }
    }

    private fun openConciertosActivity() {
        val intent = Intent(this, ConciertosActivity::class.java)
        startActivity(intent)
    }
    private fun openListadoLugares() {
        val intent = Intent(this, ListadoLugares::class.java)
        startActivity(intent)
    }
    private fun openDetalles() {
        val intent = Intent(this, Detalle::class.java)
        startActivity(intent)
    }
    private fun openPerfil() {
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio5Theme {
        Greeting("Android")
    }
}
