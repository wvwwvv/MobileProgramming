package com.example.eweek05a.model

import androidx.compose.runtime.saveable.listSaver

//saver 필요

data class ImageData(
    val image:ImageUri,
    val buttonType:ButtonType = ButtonType.ICON,

    var likes:Int = 0,
    var dislikes:Int = 0
) {
    companion object{
        //복원 데이터타입 ImageData, 저장 Any
        val ImageSaver = listSaver<ImageData, Any>(
            save = {
                //묶은 데이터 펼쳐서 저장
                item->
                listOf(
                    when(item.image) {
                        //R 인지 Url인지에 따라
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUrl
                    },
                    //열거체 타입은 name 속성이 있음
                    item.buttonType.name,
                    item.likes,
                    item.dislikes
                )
            },
            restore = {
                //저장을 list로 했기떄문에 전달되는 타입 list
                list ->
                //int나 string을 그냥 넣을 수 없음. resImage나 webImage로 변환해서 넣어줌
                val img = list[0]
                val image = when(img) {
                    is Int -> ImageUri.ResImage(img)
                    is String -> ImageUri.WebImage(img)
                    else -> throw IllegalArgumentException("타입 오류")
                }

                ImageData(
                    image = image,
                    buttonType = ButtonType.valueOf(list[1] as String), //버튼 타입을 열거체 타입으로 만들어줌
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }
}
