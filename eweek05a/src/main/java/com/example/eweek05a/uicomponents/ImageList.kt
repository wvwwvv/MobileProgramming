package com.example.eweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData

@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageList: MutableList<ImageData>
    ) {
    imageList.forEachIndexed {index, imageData ->
        when(imageData.buttonType) {

            ButtonType.ICON -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithIcon(
                        likes = imageData.likes,
                        onClick = {
                            imageList[index] = imageData.copy(likes = imageData.likes + 1)
                        }
                    )
                }
            }
            ButtonType.BADGE -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithBadge(
                        likes = imageData.likes,
                        onClick = {
                            imageList[index] = imageData.copy( likes = imageData.likes + 1)
                        }
                    )
                }
            }
            ButtonType.EMOJI -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithEmoji(
                        likes = imageData.likes,
                        dislikes = imageData.dislikes,
                        onClickLikes = {
                            imageList[index] = imageData.copy(likes = imageData.likes + 1)
                        },
                        onClickDisLikes = {
                            imageList[index] = imageData.copy(dislikes = imageData.dislikes + 1)
                        }
                    )
                }
            }
        }
    }
}