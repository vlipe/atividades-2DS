package com.example.appaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appaula.ui.theme.AppAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAulaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                }
            }
        }
    }
}

@Composable
fun App(){
    Column (){
        Row (
            Modifier
                .padding(35.dp)
        ){
            Text("Oi, Jeferson.")
        }
        Row (
            Modifier
                .padding(10.dp)

        ){
            Text("Aula de PAM é legal.")
        }
        Row (
            Modifier
                //
            /*

            */
        ){
        }
    }
}

@Preview
@Composable
fun AppPreview(){
    App()
}