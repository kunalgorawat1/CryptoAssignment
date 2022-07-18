package com.example.cryptoassignment.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonWithBorder() {
    Button(
        onClick = {
            //onclick
        },
        border = BorderStroke(1.dp, Color.Blue),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
    ) {
        Text(text = "Deposit", color = Color.Blue)
    }
}