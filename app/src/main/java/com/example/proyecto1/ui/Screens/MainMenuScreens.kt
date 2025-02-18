package com.example.proyecto1.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainMenuScreens(navController:NavHostController){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()

    ) {
        Text("Main Menu")
    //        Button(
//            onClick = (navController.navigate("MainMenuScreens"))
//        ) {
//            Text("Go to Home Screens")
//        }
    }
}