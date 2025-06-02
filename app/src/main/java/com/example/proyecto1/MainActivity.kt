package com.example.proyecto1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto1.Data.Model.database.AppDatabase
import com.example.proyecto1.Data.Model.database.DatabaseProvider
import com.example.proyecto1.ui.Screens.AccountsScreen
import com.example.proyecto1.ui.Screens.Calendar
import com.example.proyecto1.ui.Screens.ComponentsScreen
import com.example.proyecto1.ui.Screens.FavoriteAccountsScreen
import com.example.proyecto1.ui.Screens.HomeScreens
import com.example.proyecto1.ui.Screens.LoginScreen
import com.example.proyecto1.ui.Screens.MainMenuScreens
import com.example.proyecto1.ui.Screens.ManageAccountScreen
import com.example.proyecto1.ui.Screens.TestScreen
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : FragmentActivity() {
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try{
            database = DatabaseProvider.getDatabase(this)
            Log.d("debug-db", "DATABASE LOADED SUCCESSFULLY" )
        }catch (exception: Exception){
            Log.d("debug-db", "ERROR: $exception" )
        }
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
        composable("Login_screen") { LoginScreen(navController) }
        composable("Accounts_screen") { AccountsScreen(navController) }
        composable("ManageAccount_screen") { ManageAccountScreen(navController) }
        composable(
            route = "manageAcScreen/{id}",
            arguments = listOf(navArgument("id") { defaultValue = -1 })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
            ManageAccountScreen(
                navController = navController,
                accountId = id //
            )
        }
        composable("ManageAccount_screen") { FavoriteAccountsScreen(navController) }
        composable("Calendar_screen") { Calendar(navController) }
    }
}