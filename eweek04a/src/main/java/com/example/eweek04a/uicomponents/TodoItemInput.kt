package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList : MutableList<Item>, modifier: Modifier = Modifier) {
    var textFieldState by remember {mutableStateOf("")} //state 선언, 다시 생성 안되도록 보장

    Row {
        TextField(
            value = textFieldState, //입력하는 값이 value로 요 내용 가져다가 시간정보 생성해서 list에 add
            onValueChange = {text:String -> textFieldState = text},
            placeholder = {Text("할 일을 입력하세요.")}
        )
        Button(onClick = {
            //list 에 추가하는 내용 여기 작성
            if (textFieldState.isNotBlank()) {
                val currentTime = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
                todoList.add(Item(textFieldState, currentTime))
            }
            textFieldState = ""
        }) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}