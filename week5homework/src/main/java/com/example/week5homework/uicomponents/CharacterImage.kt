package com.example.week5homework.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.week5homework.R
import com.example.week5homework.model.Item
import com.example.week5homework.model.ItemStatus

@Composable
fun CharacterImage(
    itemList : List<Item>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = "몸통"
        )

        itemList.forEach { item ->
            if (item.status == ItemStatus.CHECKED) {

                val imageName = when (item.name) {
                    "arms" -> R.drawable.arms
                    "ears" -> R.drawable.ears
                    "eyebrows" -> R.drawable.eyebrows
                    "eyes" -> R.drawable.eyes
                    "glasses" -> R.drawable.glasses
                    "hat" -> R.drawable.hat
                    "mouth" -> R.drawable.mouth
                    "mustache" -> R.drawable.mustache
                    "nose" -> R.drawable.nose
                    "shoes" -> R.drawable.shoes
                    else -> null
                }

                if (imageName != null) {
                    Image(
                        painter = painterResource(id = imageName),
                        contentDescription = "아이템 사진"
                    )
                }
            }
        }
    }
}