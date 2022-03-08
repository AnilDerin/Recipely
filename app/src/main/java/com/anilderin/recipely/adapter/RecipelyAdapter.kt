package com.anilderin.recipely.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anilderin.recipely.R
import com.anilderin.recipely.model.RecipeResponse.Meal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_recipe.view.*

class RecipelyAdapter : RecyclerView.Adapter<RecipelyAdapter.RecipelyViewHolder>() {

    val items = arrayListOf<Meal>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipelyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.food_recipe, parent, false)
        )


    override fun onBindViewHolder(holder: RecipelyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()

    inner class RecipelyViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Meal) {

            item.let {
                itemView.foodTitle.text = item.strMeal
                itemView.foodDescription.text = item.strInstructions
                Glide.with(itemView).load(item.strImageSource).into(itemView.foodImage)

            }
        }
    }

    fun setItems(response: ArrayList<Meal>) {
        items.addAll(response)
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }
}