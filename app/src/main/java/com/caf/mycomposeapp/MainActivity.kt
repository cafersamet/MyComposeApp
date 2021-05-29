package com.caf.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .background(color = Color.LightGray)
        .fillMaxSize(1f)) {
        Greeting(name = "Android", Color.Green)
        Greeting(name = "Compose", Color.Red)
        Row(modifier =
        Modifier
            .background(color = Color.Black)
            .padding(12.dp)
            .alpha(.34f)
            .clickable {
                println("Clicked")
            }
            .fillMaxSize(.5f)
        ) {
            Greeting(name = "Left", Color.Yellow)
            Greeting(name = "Right", Color.Magenta)
        }
        Box() {
            // Like stack
            Greeting(name = "Left", Color.Green)
            Greeting(name = "Right", Color.Blue)
        }
    }
}

@Composable
fun Greeting(name: String, color: Color) {
    Text(
        modifier = Modifier
            .fillMaxWidth(.75f)
            .background(color = color),
        text = "Hello $name!",
        color = Color.White,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}