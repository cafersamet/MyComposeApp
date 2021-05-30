package com.caf.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caf.mycomposeapp.model.CryptoModel
import com.caf.mycomposeapp.service.ApiManager
import com.caf.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    ApiManager.getCryptoList { response ->
        if (response.isSuccessful) {

        }
    }


    Scaffold(topBar = { AppBar() }) {

    }
}

@Composable
fun AppBar() {
    TopAppBar(contentPadding = PaddingValues(10.dp)) {
        Text(text = "Retrofit Compose", fontSize = 24.sp)
    }
}

@Composable
fun CryptoList(cryptos: List<CryptoModel>) {
    LazyColumn(contentPadding = PaddingValues(4.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}

@Composable
fun CryptoRow(crypto: CryptoModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface)
    ) {
        Text(
            text = crypto.currency, style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = crypto.price, style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(2.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoRow(crypto = CryptoModel("BTC", "0.119999"))
}