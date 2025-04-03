package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        //mutableStateListOf<Item>() //빈거
        TodoItemFactory.makeTodoList()
    }

    var showPendingOnly by remember { mutableStateOf(false) }


    Column (modifier = modifier.fillMaxSize()){
        TodoListTitle()

        PendingSwitch(checked = showPendingOnly, onCheckedChange = {showPendingOnly = it})

        TodoList(todoList, showPendingOnly ,modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            TodoItemInput(todoList)
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}