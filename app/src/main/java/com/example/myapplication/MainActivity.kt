package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.api.models.Questions
import com.example.myapplication.api.retrofitClient
import kotlinx.android.synthetic.main.activity_main.*
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
                    response.body()?.let { questions ->
                        val adapter = QuestionsRecyclerAdapter(questions.items) { item ->
                            val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                            startActivity(browseIntent)
                        }
                        recyclerView.adapter = adapter
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
