package com.example.appaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appaula.ui.theme.AppAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAulaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppLogin()
                }
            }
        }
    }
}

@Composable
fun AppLogin() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF2196F3), Color(0xFF197602))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(80.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = "App Login",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF197602)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = user,
                    onValueChange = { user = it },
                    label = { Text("Usuário") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1976D2),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Logar", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                TextButton(onClick = {}) {
                    Text(
                        "Esqueceu a senha?",
                        color = Color(0xFF1976D2),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FelipeVivencio() {
    AppAulaTheme {
        AppLogin()
    }
}
