package com.example.week5homework.model

import androidx.compose.runtime.mutableStateListOf

object ItemFactory {
    fun makeItemList() = mutableStateListOf(
        Item("arms", ItemStatus.UNCHECKED),
        Item("ears", ItemStatus.UNCHECKED),
        Item("eyebrows", ItemStatus.UNCHECKED),
        Item("eyes", ItemStatus.UNCHECKED),
        Item("glasses", ItemStatus.UNCHECKED),
        Item("hat", ItemStatus.UNCHECKED),
        Item("mouth", ItemStatus.UNCHECKED),
        Item("mustache", ItemStatus.UNCHECKED),
        Item("nose", ItemStatus.UNCHECKED),
        Item("shoes", ItemStatus.UNCHECKED)
    )
}