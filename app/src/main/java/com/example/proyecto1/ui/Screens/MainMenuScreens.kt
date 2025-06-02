package com.example.proyecto1.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainMenuScreens(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(10.dp)
            .fillMaxSize(),//prueba
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Home Screens")
        Button(
            onClick = { navController.navigate("Home_Screens") }
        ) {
            Text("Go to Home Screens")
        }

        Text("Text Screen")
        Button(
            onClick = { navController.navigate("Text_Screen") }
        ) {
            Text("Go to Text Screen")
        }
        Text("Components Screen")
        Button(
            onClick = { navController.navigate("components_screen") }
        ) {
            Text("Go to Components Screen")
        }
        Text("Login Screen")
        Button(
            onClick = { navController.navigate("Login_screen") }
        ) {
            Text("Go to Login Screen")
        }
        //apis
        Text("Api Screens")
        Button(
            onClick = { navController.navigate("Calendar_screen") }
        ) {
            Text("Go to Calendar Screen")
        }
    }
}