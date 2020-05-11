package com.example.myapplication.api

import com.example.myapplication.api.models.Questions
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StackService {

    @GET("questions")
    fun getLastQuestions(
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "activity",
        @Query("site") site: String = "stackoverflow"
    ) : Call<Questions>

}