package com.example.eweek05a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ButtonWithEmoji(
    likes: Int,
    dislikes: Int,
    onClickLikes: () -> Unit, //like와 dislike 2개 상태 전달
    onClickDisLikes: () -> Unit
) {
    Row(
        //modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onClickLikes() }) { //아이콘 생성하고 버튼 기능 사용 가능
                Text(text = "😁", fontSize = 32.sp) //win . 로 이모티콘 열기
            }
            Text(text = likes.toString(), fontSize = 16.sp)
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onClickDisLikes() }) {
                Text(text = "😢", fontSize = 32.sp)
            }
            Text(text = dislikes.toString(), fontSize = 16.sp)
        }
    }
}


@Preview
@Composable
private fun ButtonWithEmojiPreview() {
    var likes by remember { mutableIntStateOf(0) }
    var dislikes by remember { mutableIntStateOf(0) }

    ButtonWithEmoji(likes, dislikes, { likes++ }, { dislikes++ })
}
