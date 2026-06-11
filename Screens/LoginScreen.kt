package com.example.practical2.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practical2.data.UserDao
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.*
import androidx.compose.foundation.layout.*
@Composable
fun LoginScreen(
    userDao: UserDao,
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var errorMessage by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Login")

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                scope.launch {
                    val user = userDao.login(
                        email,
                        password
                    )

                    if (user != null) {
                        errorMessage = ""
                        onLoginSuccess()

                    } else {
                        errorMessage = "Invalid email or password"
                    }
                }
            }
        ) {
            Text("Login")
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = errorMessage,
                color = Color.Red
            )
        }

        TextButton(
            onClick = onRegisterClick
        ) {
            Text("Go to Register")
        }
    }
}