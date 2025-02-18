package com.example.proyecto1.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreens(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(0.dp,60.dp,0.dp,0.dp)//el menu se queda en la parte superior
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Content1()
        Content2()
        Content1()
        Content2()
        Content1()

        Text("Home Screen")
//        Button(
//            onClick = (navController.navigate("Home Screen"))
//        ) {
//            Text("Go to Home Screen")
//        }
    }
}

@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(5.dp)
    ){
        Text(text = "esto es un titulo"
        fontSize = 24.dp,
            fontHeight = Fontheight.Bold,
                modifier = Modifier
                    .padding(10.dp)
    }
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
        painter = painterResources(R.drawable.logo_android),
        contentDescription = "Android logo",
        contentScale = ContentScale.Crop
    )
    Text(
        stringResource(R.string.Oracion_larga)//text de strings
        textAlign = TextAlign.Justify,
        lineHeight = 10.dp,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(5.dp)
    ){
        Row(
            (
                    Text(text = "esto es un titulo"
                                fontSize = 24.dp,
                            fontHeight = Fontheight.Bold,
                            modifier = Modifier
                                .padding(10.dp)

                    )
        )

    }
}

@Composable
fun Content3(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            height(10.dp)
            background(Color.Black)
            .padding(10.dp)
    ){
        Icon(
            Icons.Filled.Menu,
            contentDescription = "menu",
            Tint = Color.White,
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            stringResource(R.string.Oracion_larga),
            colo = Color.White,
            FontSize = Color.
        )
    }
}