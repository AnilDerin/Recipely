package com.anilderin.recipely.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anilderin.recipely.model.RecipeResponse
import com.anilderin.recipely.service.RecipeAPIService
import kotlinx.coroutines.launch

class RecipelyViewModel : ViewModel() {

    private val recipeAPIService = RecipeAPIService()

    private val _foodSearchLiveData = MutableLiveData<RecipeResponse>()
    val foodSearchLiveData: LiveData<RecipeResponse> = _foodSearchLiveData



    /*fun searchFood(strMeal: String) {

        viewModelScope.launch {

            recipeAPIService.searchFood(strMeal)
        }
    }

    fun getCategories(strCategory : String) {
        viewModelScope.launch {
            recipeAPIService.getCategories(strCategory)
        }
    }*/
}