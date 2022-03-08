package com.anilderin.recipely.service

import com.anilderin.recipely.model.RecipeResponse.Meal
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPI {

    companion object {
        const val SEARCH_FOOD = "search.php?"
        const val CATEGORIES = "categories.php"
    }

    @GET(SEARCH_FOOD)
    suspend fun searchFood(
        @Query("s") searchTerm: String,
    ): Meal

    @GET(CATEGORIES)
    fun getCategories(strCategory: String): String
}