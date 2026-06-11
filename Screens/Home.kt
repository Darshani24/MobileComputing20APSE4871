package com.example.practical2.Screens

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    Box(){
        Text(text = "Welcome",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color=Color(0xFF0D47A1),
            modifier = Modifier.padding(start = 5.dp, top = 25.dp)
        )
    }
}