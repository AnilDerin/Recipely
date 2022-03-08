package com.anilderin.recipely.model


import com.google.gson.annotations.SerializedName

class RecipeResponse {
    @SerializedName("meals")
    var meals: ArrayList<Meal>? = null


    data class Meal(
        var dateModified: Any? = null,
        var idMeal: String? = null,
        var strArea: String? = null,
        var strCategory: String? = null,
        var strCreativeCommonsConfirmed: Any? = null,
        var strDrinkAlternate: Any? = null,
        var strImageSource: Any? = null,
        var strInstructions: String? = null,
        var strMeal: String? = null,
        var strMealThumb: String? = null,
        var strSource: Any? = null,
        var strTags: String? = null,
        var strYoutube: String? = null,
    )
}