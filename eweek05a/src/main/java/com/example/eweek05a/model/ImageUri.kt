package com.example.eweek05a.model

//자식 클래스 생성 범위 제한 : sealed class
sealed class ImageUri {
    //상속해서 ResIamge, WebImage 2개 만듦
    data class ResImage(val resID:Int) : ImageUri()
    data class WebImage(val webUrl:String) : ImageUri()
}