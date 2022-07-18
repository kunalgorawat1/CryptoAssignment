package com.example.cryptoassignment.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SimpleButton() {
    Button(onClick = {
        //your onclick code here
    }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {
        Text(text = "Buy", color = Color.White)
    }
}