package com.example.jetpack_ex.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// API 요청을 정의하는 인터페이스
interface MyApi {

    @GET("posts/1")
    fun getPost1() : Call<Post>

    @GET("posts/{number}")
    fun getPostNumber(
        @Path("number") number : Int
    ) : Call<Post>
}