package com.example.eweek04a.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TodoCheckbox(checked : Boolean,
                 modifier: Modifier = Modifier,
                 //람다함수는 뒤에 작성
                 onCheckedChange:(Boolean)->Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = {checked -> onCheckedChange(checked)} //boolean에 해당하는 상태값을 밖으로 전달
    )
}