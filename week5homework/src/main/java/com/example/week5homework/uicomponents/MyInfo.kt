package com.example.week5homework.uicomponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MyInfo(modifier: Modifier = Modifier) {
    Text (
        text = "202011244 강상민",
        fontSize = 24.sp
    )
}