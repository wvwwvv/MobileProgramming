package com.example.week5homework.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.week5homework.model.Item
import com.example.week5homework.model.ItemFactory
import com.example.week5homework.model.ItemStatus

@Composable
fun ItemList(itemList : MutableList<Item>, modifier: Modifier = Modifier) {
    Column {
       itemList.chunked(2).forEach { pair ->
           Row (
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ){
               pair.forEach { item ->
                   Row(
                       verticalAlignment = Alignment.CenterVertically,
                       modifier = Modifier.weight(1f)
                   ) {
                       ItemCheckbox(
                           checked = item.status == ItemStatus.CHECKED
                       ) { isChecked ->
                           val i = itemList.indexOf(item)
                           itemList[i] = item.copy(
                               status = if (isChecked) ItemStatus.CHECKED else ItemStatus.UNCHECKED
                           )

                       }
                       Text(
                           text = item.name,
                           fontSize = 12.sp
                       )
                   }
               }


            }

        }
    }
}


@Preview
@Composable
private fun ItemListPreview() {
    ItemList(ItemFactory.makeItemList())

}