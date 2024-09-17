package com.dom.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dom.laboratorio5.ConciertosScreen
import com.dom.laboratorio5.LugaresList
import com.dom.laboratorio5.PerfilScreen
import com.dom.laboratorio5.R
import com.dom.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()  // Crear NavController
    Scaffold(
        bottomBar = { BottomNavBar(navController) }  // Barra de navegación inferior
    ) { innerPadding ->
        NavHostContainer(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Conciertos,
        BottomNavItem.Lugares,
        BottomNavItem.Perfil
    )
    NavigationBar {  // Usa NavigationBar en lugar de BottomNavigation
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),  // Los íconos de cada ítem
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = false,  // Puedes mejorar la lógica de selección
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object Conciertos : BottomNavItem("Conciertos", R.drawable.nav_iconoconciertos, "conciertos")
    object Lugares : BottomNavItem("Lugares", R.drawable.nav_iconolugares, "lugares")
    object Perfil : BottomNavItem("Perfil", R.drawable.nav_iconoperfil, "perfil")
}

@Composable
fun NavHostContainer(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "conciertos") {
        composable("conciertos") {
            ConciertosScreen(navController)  // Pantalla de Conciertos
        }
        composable("lugares") {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                LugaresList(modifier = Modifier.padding(innerPadding),navController)
            }
        }
        composable("perfil") {
            PerfilScreen()  // Pantalla de Perfil
        }
        composable("detalle") {
            DetalleScreen()
        }
    }
}
