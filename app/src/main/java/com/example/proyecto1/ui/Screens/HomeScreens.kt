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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyecto1.R

@Composable
fun HomeScreens(navController: NavHostController) {
    topbar()

    Column(
        modifier = Modifier
            .padding(0.dp, 60.dp, 0.dp, 0.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Content1()
        Content2()
        Content1()
        Content2()
        Content1()
        Content2()

        Text("Home Screen")

        Button(
            onClick = { navController.navigate("Main_Menu") }
        ) {
            Text("Return to Main Menu")
        }

        Button(
            onClick = { navController.navigate("Text_Screen") }
        ) {
            Text("Go to Text Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content1() {
    Card(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = "This is a title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )

        //imagen en la tarjeta
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(R.drawable.satosugu),
            contentDescription = "SatoSugu",
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(R.string.Texto),
            textAlign = TextAlign.Justify,
            lineHeight = 10.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Content2() {
    Card(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(80.dp)
                    .height(100.dp),
                painter = painterResource(R.drawable.satosugu),
                contentDescription = "Imagen Satosugu",
                contentScale = ContentScale.Inside
            )
        }
        Column() {
            Text(
                text = "This is a title",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(5.dp)
            )

            Text(
                text = stringResource(R.string.Texto),
                textAlign = TextAlign.Left,
                lineHeight = 14.sp,
                fontSize = 10.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
fun topbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(10.dp)
    ) {
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Menu Icon",
            tint = Color.Green,
            modifier = Modifier
                .size(50.dp)
        )

        //barra superior
        Text(
            stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}