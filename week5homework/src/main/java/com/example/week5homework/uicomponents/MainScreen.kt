package com.example.week5homework.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week5homework.viewmodel.ItemViewModel


@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier, itemViewModel : ItemViewModel = viewModel()) {

    val items = itemViewModel.itemList
    val orientation = LocalConfiguration.current.orientation

    if(orientation == Configuration.ORIENTATION_PORTRAIT) { //세로모드
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            MyInfo()
            CharacterImage(
                itemList = items,
                modifier = Modifier.size(200.dp)
            )
            ItemList(itemList = items)
        }
    }else {
        Column {
            MyInfo()
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CharacterImage(
                    itemList = items,
                    modifier = Modifier.size(200.dp)
                )
                ItemList(itemList = items)
            }
        }
    }
}