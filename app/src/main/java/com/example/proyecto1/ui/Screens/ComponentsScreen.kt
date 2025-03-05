package com.example.proyecto1.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import java.lang.StackWalker.Option


@Composable
fun ComponentsScreen(navController: NavHostController){
    //Buttons()


    var option by rememberSaveable { mutableStateOf("buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()//linea para dividir

                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.AccountBox, contentDescription = "") },
                    label = { Text("First Menu Item") },
                    selected = false,
                    onClick = {
                        option = "First"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "") },
                    label = { Text("Second Menu Item") },
                    selected = false,
                    onClick = {
                        option = "Second"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "") },
                    label = { Text("Third Menu Item") },
                    selected = false,
                    onClick = {
                        option = "Third"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
            }
        }
    ) {
        Column {
            when(option){//cuando option tenga el valor de first
                "First" -> {
                    Buttons()
                }
                "Second" -> {
                    Buttons()//floating buttons
                }
                "Third" -> {
                    Buttons()
                }
            }
        }
        //Text(option)//todo lo que este en pantalla
    }
}

@Preview(showBackground = true)
@Composable
fun Buttons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),//espacio 100% del dispositivo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Button(onClick = {}) {
            Text("Filled")//rellenado
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")//claro
        }
        OutlinedButton(onClick = {}) {
            Text("Outlined")//delinedo
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated")//sombra
        }
        TextButton(onClick = {}) {
            Text("Text")//texto botón
        }
    }
}