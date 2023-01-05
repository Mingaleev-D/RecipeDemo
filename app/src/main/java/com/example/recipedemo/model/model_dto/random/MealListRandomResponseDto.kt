package com.example.recipedemo.model.model_dto.random


import com.google.gson.annotations.SerializedName

data class MealListRandomResponseDto(
    @SerializedName("meals")
    val meals: List<Meal>
)