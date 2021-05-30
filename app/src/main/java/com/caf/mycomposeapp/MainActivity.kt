package com.caf.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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
    val myInput = remember { mutableStateOf("") }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF966868)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpecialText(string = "Compose")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialText(string = "Test")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialTextField(myInput.value) {
                myInput.value = it;
            }
        }
    }
}

@Composable
fun SpecialText(string: String) {
    Text(
        text = string, fontSize = 20.sp, fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun SpecialTextField(inputString: String, onValueChange: (String) -> Unit) {
    TextField(value = inputString, onValueChange = onValueChange, modifier = Modifier.padding(4.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}