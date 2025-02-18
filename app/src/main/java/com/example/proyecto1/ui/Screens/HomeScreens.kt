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
    // Llamada a la barra superior (top bar)
    topbar()

    // Columna principal con desplazamiento vertical
    Column(
        modifier = Modifier
            .padding(0.dp, 60.dp, 0.dp, 0.dp)  // Aplica un padding en la parte superior de 60dp
            .fillMaxSize()  // Hace que la columna ocupe toda la pantalla
            .verticalScroll(rememberScrollState())  // Habilita el desplazamiento vertical para el contenido
    ) {
        // Llamadas a los composables Content1 y Content2 repetidos
        Content1()
        Content2()
        Content1()
        Content2()
        Content1()
        Content2()

        // Texto que indica que estamos en la pantalla principal
        Text("Home Screen")

        // Botón para volver al menú principal
        Button(
            onClick = { navController.navigate("Main_Menu") }
        ) {
            Text("Return to Main Menu")
        }

        // Botón para ir a la pantalla de prueba
        Button(
            onClick = { navController.navigate("Test_Screen") }
        ) {
            Text("Go to Test Screen")
        }
    }
}

// Función composable para el contenido de la tarjeta 1 (Content1)
@Preview(showBackground = true)
@Composable
fun Content1() {
    Card(
        modifier = Modifier
            .background(Color.Blue)  // Fondo azul para la tarjeta
            .fillMaxWidth()  // La tarjeta ocupa todo el ancho
            .padding(5.dp)  // Padding alrededor de la tarjeta
    ) {
        // Título dentro de la tarjeta
        Text(
            text = "This is a title",
            fontSize = 24.sp,  // Tamaño de fuente grande
            fontWeight = FontWeight.Bold,  // Negrita
            modifier = Modifier
                .padding(10.dp)  // Padding dentro del texto
        )

        // Imagen dentro de la tarjeta
        Image(
            modifier = Modifier
                .fillMaxWidth()  // Imagen ocupa todo el ancho
                .height(200.dp),  // Imagen con altura de 200dp
            painter = painterResource(R.drawable.satosugu),  // Reemplaza con tu recurso de imagen
            contentDescription = "Audi TTS",  // Descripción de la imagen
            contentScale = ContentScale.Crop  // Escala la imagen recortándola
        )

        // Texto dentro de la tarjeta
        Text(
            text = stringResource(R.string.Texto),  // Texto que se obtiene de los recursos de cadena
            textAlign = TextAlign.Justify,  // Alineación del texto justificada
            lineHeight = 10.sp,  // Altura de las líneas
            modifier = Modifier.padding(10.dp)  // Padding dentro del texto
        )
    }
}

// Función composable para el contenido de la tarjeta 2 (Content2)
@Preview(showBackground = true)
@Composable
fun Content2() {
    Card(
        modifier = Modifier
            .background(Color.Blue)  // Fondo azul para la tarjeta
            .fillMaxWidth()  // La tarjeta ocupa todo el ancho
            .padding(5.dp)  // Padding alrededor de la tarjeta
    ) {
        // Contenedor para la imagen con un Row (fila)
        Row() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()  // Imagen ocupa todo el ancho
                    .width(80.dp)  // Imagen con ancho de 80dp
                    .height(100.dp),  // Imagen con altura de 100dp
                painter = painterResource(R.drawable.satosugu),  // Reemplaza con tu recurso de imagen
                contentDescription = "Geto",  // Descripción de la imagen
                contentScale = ContentScale.Inside  // Escala la imagen dentro de los límites
            )
        }

        // Contenedor de texto con un Column (columna)
        Column() {
            // Título dentro de la tarjeta
            Text(
                text = "This is a title",
                fontSize = 12.sp,  // Tamaño de fuente más pequeño
                fontWeight = FontWeight.Bold,  // Negrita
                modifier = Modifier
                    .padding(5.dp)  // Padding alrededor del texto
            )

            // Texto adicional dentro de la tarjeta
            Text(
                text = stringResource(R.string.Texto),  // Texto obtenido de los recursos de cadena
                textAlign = TextAlign.Left,  // Alineación a la izquierda
                lineHeight = 14.sp,  // Altura de las líneas
                fontSize = 10.sp,  // Tamaño de fuente más pequeño
                modifier = Modifier.padding(10.dp)  // Padding dentro del texto
            )
        }
    }
}

// Función composable que crea la barra superior (top bar) con un icono y un texto
@Preview
@Composable
fun topbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()  // La barra superior ocupa todo el ancho
            .height(60.dp)  // La barra tiene una altura de 60dp
            .background(Color.Black)  // Fondo negro para la barra
            .padding(10.dp)  // Padding dentro de la barra
    ) {
        // Icono de menú dentro de la barra superior
        Icon(
            Icons.Filled.Menu,  // Icono de menú
            contentDescription = "Menu Icon",  // Descripción del icono
            tint = Color.Red,  // Color del icono (rojo)
            modifier = Modifier
                .size(50.dp)  // Tamaño del icono (50dp)
        )

        // Título de la aplicación en la barra superior
        Text(
            stringResource(R.string.app_name),  // Nombre de la aplicación obtenido de los recursos
            color = Color.White,  // Color blanco para el texto
            fontSize = 20.sp,  // Tamaño de fuente de 20sp
            textAlign = TextAlign.Center  // Alineación centrada del texto
        )
    }
}