package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun TodoList(todoList : MutableList<Item>, showPendingOnly : Boolean = false, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column (
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ){
        todoList.forEachIndexed {index, item -> //인자가 하나면 생략하고 it접근 됨
            if (showPendingOnly && item.status != TodoStatus.PENDING) return@forEachIndexed
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ){
                Row {
                    TodoCheckbox(checked = item.status == TodoStatus.COMPLETED) { isChecked ->
                        // "State Hoisting"
                        //isChecked 값에 따라 item.Status 값 변경되어야 함
                        //그리고 화면도 다시 그려야 함 : list 데이터가 상태로서 사용돼야함
                        //매개 변수로 들어온 객체 (item)은 변경 불가
                        //todoList의 index 번쨰 객체로 접근
                        //객체의 일부 속성만 변경시키는 것은 list의 변화로 감지 못함 -> 새로운 객체 생성 필요
                        //copy를 사용하되 status만 isChecked를 이용해 값 변경
                        todoList[index] = item.copy(
                            status = if(isChecked) TodoStatus.COMPLETED
                                        else TodoStatus.PENDING
                        )


                    }
                    TodoItem(item = item)
                }
            }

        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList())

}