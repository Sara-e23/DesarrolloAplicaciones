package com.example.proyecto1.ui.Screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyecto1.R
import com.example.proyecto1.Data.Model.MenuModel
import com.example.proyecto1.ui.Components.PostCardComponent
import androidx.compose.ui.res.painterResource
import com.example.proyecto1.ui.Components.PostCardCompactComponent
import kotlinx.coroutines.launch
import java.lang.StackWalker.Option


@Composable
fun ComponentsScreen(navController: NavHostController){
    val menuOption = arrayOf(
        MenuModel(1, "Buttons", "button", Icons.Filled.Home),
        MenuModel(2, "Floating Buttons", "FButtons", Icons.Filled.Home),
        MenuModel(3, "Progress", "prog", Icons.Filled.Home),
        MenuModel(4, "Chips", "chip", Icons.Filled.Home),
        MenuModel(5, "Sliders", "slider", Icons.Filled.Home),
        MenuModel(6, "Switches", "switch", Icons.Filled.Home),
        MenuModel(7, "Badges", "badges", Icons.Filled.Home),
        MenuModel(8, "Snack Bars", "SBar", Icons.Filled.Home),
        MenuModel(9, "Alerts Dialogs", "AD", Icons.Filled.Home),
        MenuModel(10, "Top App Bar", "tap", Icons.Filled.Home)
    )

    var option by rememberSaveable { mutableStateOf("buttons") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet{
            Text("Menu", modifier = Modifier.padding(16.dp))
            HorizontalDivider()
            LazyColumn {
                items(menuOption) { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.image, contentDescription = "") },
                        label = { Text(item.title) },
                        selected = false,
                        onClick = {
                            option = item.text
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                }
            }
        }
        }
    ) {
        when(option){
            "button" -> { Buttons() }
            "FButtons" -> { FloatingButtons() }
            "prog" -> { Progress() }
            "chip" -> { Chips() }
            "slider" -> { Sliders() }
            "switch" -> { Switches() }
            "badges" -> { Badges() }
            "SBar" -> { SnackBars() }
            "AD" -> { AlertDialogs() }
            "tap" -> { Bars() }
        }
    }

}

//@Preview(showBackground = true)
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

@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),//espacio 100% del dispositivo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add button")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add button")
        }
        ExtendedFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, "Add button")
            Text("Button")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        modifier = Modifier
            .fillMaxSize(),//espacio 100% del dispositivo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}
//@Preview(showBackground = true)
@Composable
fun Chips() {//etiquetas y acciones rápidas
    Column(
        modifier = Modifier
            .fillMaxSize(),//espacio 100% del dispositivo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )//assistChip
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected = selected,//saber si el fitro está activo o no
            onClick = { selected = !selected},
            label = { Text("Filter Chip") },
            leadingIcon = if(selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            }else {
                null
            }
        )
        InputChipExample("Dismiss",{})
    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return
    InputChip(
        label = {Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Person",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        modifier = Modifier
            .fillMaxSize(),//espacio 100% del dispositivo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var SliderPosition by remember { mutableStateOf(58f)}
        Slider(
            value = SliderPosition,
            onValueChange = { SliderPosition = it},
            steps = 10, //en que cantidades se va a mover y un rango minimo
            valueRange = 0f .. 100f//rango de 0 a 100 en flotante
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()//convertir flotante a string
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        modifier = Modifier
            .fillMaxSize(),//espacio 100% del dispositivo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var checked by remember { mutableStateOf(true)}
        Switch(
            checked = checked,
            onCheckedChange = { checked = it}//actualizando el valor de la var
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = { checked2 = it},//actualizando el valor de la var
            thumbContent = if (checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Switch Check",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else{
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}

@Composable
fun Badges() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                    {
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart icon"
            )
        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Add item")
        }
    }
}

@Composable
fun SnackBars() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        //val=static
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }
        Button(::launchSnackBar){
            Text("Send Message")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }
        if(showAlertDialog){
            AlertDialog(
                icon = {Icon(Icons.Filled.Info, contentDescription = "Info Icon")},
                title = { Text("Confirm Deletion") },
                text = { Text("Do you really want to delete this file?") },
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = {showAlertDialog = true}) {
            Text("Delete File")
        }
        Text(selectedOption)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Blue,
                titleContentColor = Color.Gray
            ),
            title = { Text("Screen title") },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search button")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Search button")
                }
            }//actions
        )
        /*
        val arrayPosts = arrayOf(
            MenuModel(1, "Title 1", "Text 1", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(2, "Title 2", "Text 2", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(3, "Title 3", "Text 3", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(4, "Title 4", "Text 4", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(5, "Title 5", "Text 5", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(6, "Title 6", "Text 6", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(7, "Title 7", "Text 7", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(8, "Title 8", "Text 8", ImageVector.vectorResource(R.drawable.satosugu)),
            MenuModel(9, "Title 9", "Text 9", ImageVector.vectorResource(R.drawable.satosugu)),
        )
        LazyVerticalGrid (//LazyHorizontalGrid y en vez de columns son rows
            columns = GridCells.Adaptive(minSize = 100.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            items(arrayPosts){
                item -> PostCardComponent(item.id, item.title, item.text, item.image)
            }
        }*/

        Column (//lo que necesitamos para saber que tipo de dispositivo
            modifier = Modifier
                .weight(1F)
                .fillMaxSize()
        ){
            Adaptive()
        }

        BottomAppBar(
            containerColor = Color.LightGray,
            contentColor = Color.Red,
        ){
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
            IconButton(
                modifier = Modifier
                    .weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "")
            }
        }
    }
}

@Composable
fun Adaptive(){
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    // Compact Width < 600 dp Phone Portrait
    // Medium Width >= 600 dp  < 840 dp Tablet Portrait
    // Expanded Width >= 840 dp Tablet LandScape

    // Compact Height < 480 dp Phone LandScape
    // Medium Height >= 480 dp < 900 dp Tablet LandScape/Phone Portrait
    // Expanded Height >= 900 dp Tablet Portrait

    Column {
        Text(windowSize.toString())
        Text(height.toString())
        Text(width.toString())

    }
}