package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto1.ui.Screens.ComponentsScreen
import com.example.proyecto1.ui.Screens.HomeScreens
import com.example.proyecto1.ui.Screens.MainMenuScreens
import com.example.proyecto1.ui.Screens.TestScreen
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto1Theme {
                ComposableMultiScreenApp()
            }
        }
    }
}

@Composable
fun ComposableMultiScreenApp() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Main_Menu") {

        composable("Main_Menu") { MainMenuScreens(navController) }
        composable("Home_Screens") { HomeScreens(navController) }
        composable("Text_Screen") { TestScreen(navController) }
        composable("components_screen") { ComponentsScreen(navController) }
    }
}