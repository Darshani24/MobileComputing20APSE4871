package com.example.practical2.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.practical2.data.UserDao
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practical2.data.User
@Composable
fun RegisterScreen(
    userDao: UserDao,
    onComplete: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Register")

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Button(
            onClick = {
                scope.launch {
                    val user = User(
                        name = name,
                        email = email,
                        password = password
                    )

                    userDao.insertUser(user)
                    onComplete()
                }
            }
        ) {
            Text("Register")
        }
    }
}