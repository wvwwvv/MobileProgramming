package com.example.week5homework.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week5homework.model.Item
import com.example.week5homework.model.ItemFactory

class ItemViewModel : ViewModel() {
    private val _itemList = ItemFactory.makeItemList()
    val itemList: MutableList<Item>
        get() = _itemList
}