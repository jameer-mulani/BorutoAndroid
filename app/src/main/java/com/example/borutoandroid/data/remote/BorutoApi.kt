package com.example.borutoandroid.data.remote

import com.example.borutoandroid.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {
    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page")
        page: Int
    ): ApiResponse

    @GET("boruto/heroes/search")
    suspend fun searchHero(
        @Query("name")
        name: String
    ): ApiResponse

}