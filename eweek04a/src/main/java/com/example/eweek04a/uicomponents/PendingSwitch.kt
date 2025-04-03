package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PendingSwitch(
    checked : Boolean,
    onCheckedChange : (Boolean) -> Unit,
    modifier : Modifier = Modifier
) {

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text= "미완료 항목만 보기"
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier
        )
    }


}

@Preview
@Composable
private fun PendingSwitchPreview() {
    var isChecked by remember { mutableStateOf(true)}

    PendingSwitch(
        checked = isChecked,
        onCheckedChange = {value -> isChecked = value}
    )
}
