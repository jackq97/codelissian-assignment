package com.jask.codelissianassignment.network

import com.jask.codelissianassignment.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything?q=apple&sortBy=popularity&apiKey=ead2b010db9f4fd481f43cc7bc9f2580&pageSize=100")
    suspend fun getNews(
        @Query("page") page: Int
    ): News
}