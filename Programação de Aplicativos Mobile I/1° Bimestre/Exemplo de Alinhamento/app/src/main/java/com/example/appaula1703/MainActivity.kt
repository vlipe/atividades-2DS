package com.example.appaula1703

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appaula1703.ui.theme.AppAula1703Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAula1703Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppAula()
                }
            }
        }
    }
}

@Composable
fun AppAula (){
    Column (
        Modifier
            .fillMaxSize()
    ) {
        Row (
            Modifier
                .fillMaxWidth()
                .padding(46.dp),
            Arrangement.Center
        ) {
            Text("AppAula")
        }
        Row (
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {

        }
    }
}

@Preview
@Composable
fun AppPreview(){
    AppAula()
}