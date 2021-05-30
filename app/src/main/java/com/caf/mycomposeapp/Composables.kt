package com.caf.mycomposeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OtherScreen() {
    Surface(color = Color.LightGray) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val input = remember {
                mutableStateOf("Android Compose")
            }

            TextField(value = input.value, onValueChange = {
                input.value = it
            })
            Spacer(modifier = Modifier.padding(10.dp))
            val myText = remember {
                mutableStateOf("Cafo")
            }
            Text(text = myText.value, fontSize = 26.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                println("Clicked")
                when (myText.value) {
                    "Cafo" -> {
                        myText.value = "Cafo 1"
                    }
                    "Other" -> {
                        myText.value = "Cafo"
                    }
                    else -> {
                        myText.value = "Other"
                    }
                }
            }) {
                Text(text = "Button")
                Text(text = "Test")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.rdho),
                "Ronaldinho, old football player",
                modifier = Modifier
                    .width(300.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Image(
                painter = ColorPainter(Color.Blue),
                contentDescription = null,
                modifier = Modifier.size(16.dp, 16.dp)
            )
        }
    }
}