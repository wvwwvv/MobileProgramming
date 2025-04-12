package com.example.week5homework.model

import androidx.compose.runtime.saveable.listSaver

data class Item (
    val name : String,
    var status : ItemStatus = ItemStatus.UNCHECKED
){
    companion object {
        val ItemSaver = listSaver<Item, Any>(
            save = { item ->
                listOf(item.name, item.status)
            },
            restore = { list ->
                Item(
                    name = list[0] as String,
                    status = ItemStatus.valueOf(list[1] as String)
                )
            }

        )
    }
}