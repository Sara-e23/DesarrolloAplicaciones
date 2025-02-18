package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto1.ui.Screens.HomeScreens
import com.example.proyecto1.ui.Screens.MainMenuScreens
import com.example.proyecto1.ui.Screens.TestScreen
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {  // Método que se ejecuta al crear la actividad
        super.onCreate(savedInstanceState)
        setContent {  // Establece el contenido de la actividad usando Jetpack Compose
            Proyecto1Theme {  // Aplica el tema de la aplicación
                ComposableMultiScreenApp()  // Llama a la función principal de navegación
            }
        }
    }
}

// Función composable que maneja la navegación entre pantallas
@Composable
fun ComposableMultiScreenApp() {
    val navController = rememberNavController()  // Crea un controlador de navegación y lo recuerda
    SetupNavGraph(navController = navController)  // Configura la navegación con el controlador
}

// Configuración del sistema de navegación de la app
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Main_Menu") {
        // Define la estructura de navegación de la app con una pantalla de inicio

        composable("Main_Menu") { MainMenuScreens(navController) }  // Ruta para la pantalla del menú principal
        composable("Home_Screens") { HomeScreens(navController) }  // Ruta para la pantalla de inicio
        composable("Test_Screen") { TestScreen(navController) }  // Ruta para la pantalla de prueba
    }
}