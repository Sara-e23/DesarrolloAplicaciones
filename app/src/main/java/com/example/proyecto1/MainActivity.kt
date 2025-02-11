package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Proyecto1Theme {
                Row(){//utilizaremos Row, Column y Box
                    Column(){
                        Text(text = "minho")
                        Text(text = "Welcome to your first app")
                    }
                    Column(){
                        Text(text = "minho")
                        Text(text = "Welcome to your first app")
                    }
                    Column(){
                        Text(text = "minho")
                        Text(text = "Welcome to your first app")
                    }
                }
                Text(text = "minsung")
                Text(text = "Welcome to your first app")
            //hay que poner layouts para no sobreponer objetos, tarea
                //layouts en android compose 1 y 2 funciones composable
                //se agregó la primera interfaz de texto en el archivo
                //interfaz main activity
                /*
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    }
                }*/
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Proyecto1Theme {
        Greeting("Android")
    }
  }
 */
