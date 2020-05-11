package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.api.models.Questions
import com.example.myapplication.api.retrofitClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("debugApp", "getting last questions...")
        retrofitClient.getLastQuestions().enqueue(object : retrofit2.Callback<Questions>{

            override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
                if (response.isSuccessful){
                    response.body()?.items?.forEach {
                        Log.d("debugApp", "${it.owner.displayName} :: ${it.title}")
                    }
                }
                else {
                    Log.e("debugApp", "response not successful")
                }
            }

            override fun onFailure(call: Call<Questions>, t: Throwable) {
                Log.e("debugApp", "ERROR ONFAILURE $t")
            }

        })




    }
}
