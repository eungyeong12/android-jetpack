package com.example.jetpack_ex.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // API의 기본 URL 설정
    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Retrofit 클라이언트 생성
    val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Retrofit 인스턴스를 반환
    fun getInstance() : Retrofit {
        return client
    }
}