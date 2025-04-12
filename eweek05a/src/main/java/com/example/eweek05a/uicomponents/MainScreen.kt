package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.ImageViewModel


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel : ImageViewModel = viewModel()
) {

    val imageList = imageViewModel.imageList
    var scrollState = rememberScrollState()
    val orientation = LocalConfiguration.current.orientation //가로모드인지 세로모드인지

    if(orientation == Configuration.ORIENTATION_PORTRAIT) { //세로모드
        Column (
            modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ImageList(imageList = imageList)
        }
    }else {
        Row (
            modifier = Modifier.fillMaxHeight().horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ){
            ImageList(imageList = imageList)
        }
    }



    /*var img1State by rememberSaveable (stateSaver = ImageData.ImageSaver) {
        mutableStateOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img1),
                buttonType = ButtonType.BADGE,
                likes = 50
            )
        )
    }

    var img2State by rememberSaveable (stateSaver = ImageData.ImageSaver) {
        mutableStateOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img2),
                buttonType = ButtonType.EMOJI,
                likes = 100,
                dislikes = 10
            )
        )
    }

    //이거 왜 이미지 안뜸?
    Column {
        ImageWithButton(image = img1State.image) {
            ButtonWithBadge(likes = img1State.likes) {
                img1State = img1State.copy( likes = img1State.likes + 1) //copy 함수 내에서는 불변. like++ 쓰면 안됨
            }
        }
    }


    Column {
        ImageWithButton(image = img2State.image) {
            ButtonWithEmoji(
                likes = img2State.likes,
                dislikes = img2State.dislikes,
                onClickLikes = {img2State = img2State.copy( likes = img2State.likes + 1)},
                onClickDisLikes = {img2State = img2State.copy( dislikes = img2State.dislikes + 1)}
            )
        }
    }*/
}

