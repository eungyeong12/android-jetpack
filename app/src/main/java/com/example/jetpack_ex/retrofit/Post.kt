package com.example.jetpack_ex.retrofit

// 데이터를 매핑하기 위한 데이터 클래스
data class Post (
    val userId : Int,
    val id : Int,
    val title : String,
    val body : String
)