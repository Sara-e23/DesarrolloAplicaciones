package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Proyecto1Theme {
                Column(){//utilizaremos Row, Column y Box
                    Column(){
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                }
                Row(){
                    TextComposable()
                    TextComposable()
                    TextComposable()

                }
                Column(){
                    ModifierExample2()

                    CustomText()
                }
            }
        }
    }
    @Preview(showBackground = true)

    @Composable
    fun TextComposable(name: String = "Empty"){
        Text("Hello World")
        Text(name)
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExample1(){
        Column(
            modifier = Modifier
                .padding(50.dp, 30.dp, 20.dp, 10.dp)
        ){
            Text("Hello World")
        }
    }



@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .padding(10.dp)
            .height(300.dp)
            .width(300.dp)
    ){
        Text("1", Modifier.align(Alignment.TopStart))
        Text("2", Modifier.align(Alignment.TopCenter))
        Text("3", Modifier.align(Alignment.TopCenter))
    }

@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .padding(10.dp)
            .height(300.dp)
            .width(300.dp)
    ){
        Text("1", Modifier.align(Alignment.TopStart))
        Text("2", Modifier.align(Alignment.TopCenter))
        Text("3", Modifier.align(Alignment.TopCenter))
    }
}
}
    @Preview(showBackground = true)
    @Composable
    fun CustomText(){
        Column(){
            Text(
                StringResource(R.string.sample.text),
                color = colorResource(R.color.purple_200),
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic, //para cursivas
                fontWeight = FontWeight.ExtraBold,
            )
            val gradientColors = listOff(Color.Blue, Color.Red, Color.Black, color = colorResource(R.color.purple_200))
            Text(
                StringResource(R.string.sample.text),
                style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
            )
        }

    }
}