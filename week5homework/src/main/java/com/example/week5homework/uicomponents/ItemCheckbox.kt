package com.example.week5homework.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ItemCheckbox(checked : Boolean,
                 modifier: Modifier = Modifier,
                 onCheckedChange:(Boolean)->Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = {checked -> onCheckedChange(checked)}
    )
}