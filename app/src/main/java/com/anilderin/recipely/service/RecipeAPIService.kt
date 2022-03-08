package com.anilderin.recipely.service

import com.anilderin.recipely.model.RecipeResponse.Meal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeAPIService {


    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RecipeAPI::class.java)

    suspend fun searchFood(strMeal: String): Meal {
        return api.searchFood(strMeal)
    }

    fun getCategories(strCategory: String): String {
        return api.getCategories(strCategory)
    }

}