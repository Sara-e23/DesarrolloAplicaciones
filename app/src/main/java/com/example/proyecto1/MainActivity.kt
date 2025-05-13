package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
//import androidx.media3.database.DatabaseProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto1.ui.Screens.AccountScreen
import com.example.proyecto1.ui.Screens.ComponentsScreen
import com.example.proyecto1.ui.Screens.FavoriteAccountsScreen
import com.example.proyecto1.ui.Screens.HomeScreens
import com.example.proyecto1.ui.Screens.LoginScreen
import com.example.proyecto1.ui.Screens.MainMenuScreens
import com.example.proyecto1.ui.Screens.ManageAccountScreen
import com.example.proyecto1.ui.Screens.TestScreen
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : ComponentActivity() {
    //lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        try{
//            database = DatabaseProvider.getDatabase(this)
//            Log.d("debug-db", "DATABASE LOADED SUCCESSFULLY" )
//        }catch (exception: Exception){
//            Log.d("debug-db", "ERROR: $exception" )
//        }

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
        composable("Login_Screen") { LoginScreen(navController) }
        composable("Account_Screen") { AccountScreen(navController) }
        composable("ManageAccount_Screen") { ManageAccountScreen(navController) }
        composable("FavoriteAccounts_Screen") { FavoriteAccountsScreen(navController) }
    }
}