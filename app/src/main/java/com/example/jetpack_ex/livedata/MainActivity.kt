package com.example.jetpack_ex.livedata

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpack_ex.R

// LiveData
// 데이터를 관찰해줄 수 있는 친구(LifeCycle 과 결합해서)

class MainActivity : AppCompatActivity() {

    private var testMutableLiveData = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main10)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
        }

        testMutableLiveData.observe(this, Observer {
            Log.d("testMutableLiveData", testMutableLiveData.value.toString())
            findViewById<TextView>(R.id.textArea).text = testMutableLiveData.value.toString()
        })
    }
}