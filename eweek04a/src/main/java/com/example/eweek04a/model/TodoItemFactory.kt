package com.example.eweek04a.model

import androidx.compose.runtime.mutableStateListOf

object TodoItemFactory {
    //mutableListOf -> mutableStateListOf 변경 : list도 state 변경 감지시 recomposing
    fun makeTodoList() = mutableStateListOf(
        Item("202011244 강상민","04-03 10:00", TodoStatus.PENDING),
        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
        Item("책 읽기", "02-01 08:30", TodoStatus.PENDING),
        Item("점심 먹기", "02-01 12:30", TodoStatus.COMPLETED),
        Item("모프 공부하기", "02-01 17:30", TodoStatus.PENDING)
    )
}

