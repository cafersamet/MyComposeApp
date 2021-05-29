package com.caf.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitScreen()
        }
    }
}

@Composable
private fun InitScreen() {
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize(1f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(name = "Android", Color.Green)
        Greeting(name = "Compose", Color.Red)
        Spacer(modifier = Modifier.padding(10.dp))


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Greeting(name = "1", Color.Blue)
            Greeting(name = "2", Color.Cyan)
            Greeting(name = "3", Color.Magenta)
        }


        Spacer(
            modifier = Modifier
                .width(100.dp)
                .height(15.dp)
        )
        Box() {
            // Like stack
            Greeting(name = "Box1", Color(0xFF2196F3))
//            Greeting(name = "Box2", Color.Blue)
        }
    }
}

@Composable
fun Greeting(name: String, color: Color) {
    Text(
        modifier = Modifier
            //use as first parameter
            .clickable {
                println("Clicked $name")
            }
//            .fillMaxWidth(.75f)
            .background(color = color)
            .padding(8.dp),
        text = "Hello $name!",
        color = Color.White,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}