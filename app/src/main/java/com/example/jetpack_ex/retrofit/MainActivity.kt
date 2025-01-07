package com.example.jetpack_ex.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jetpack_ex.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Simple Retrofit Ex

// https://jsonplaceholder.typicode.com/
// https://jsonplaceholder.typicode.com/posts
// https://jsonplaceholder.typicode.com/posts/3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main15)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrofit을 통해 MyApi 인터페이스 생성
        val api = RetrofitInstance.getInstance().create(MyApi::class.java)

        // 1. 유저 정보를 가져와서 (userId)
        api.getPost1().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
                // 2. userId 기반으로 데이터를 가져오고 가져온 닉네임값
                api.getPostNumber(2).enqueue(object : Callback<Post> {
                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        Log.d("API2", response.body().toString())
                        // 3. 닉네임 기반으로 데이터를 가져오고 유저의 댓글을 가져와서
                        api.getPostNumber(3).enqueue(object : Callback<Post> {
                            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                Log.d("API3", response.body().toString())
                                // 4. 유저의 댓글 기반으로, 대댓글
                                api.getPostNumber(4).enqueue(object : Callback<Post> {
                                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                        Log.d("API4", response.body().toString())
                                    }

                                    override fun onFailure(call: Call<Post>, t: Throwable) {
                                        Log.d("API4", "fail")
                                    }

                                })
                            }

                            override fun onFailure(call: Call<Post>, t: Throwable) {
                                Log.d("API3", "fail")
                            }

                        })
                    }

                    override fun onFailure(call: Call<Post>, t: Throwable) {
                        Log.d("API2", "fail")
                    }

                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })
    }
}