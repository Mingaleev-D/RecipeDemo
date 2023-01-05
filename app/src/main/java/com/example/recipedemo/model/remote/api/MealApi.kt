package com.example.recipedemo.model.remote.api

import com.example.recipedemo.model.model_dto.random.MealListRandomResponseDto
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 5/01/2023
 */

interface MealApi {

   @GET("random.php")
   suspend fun fetchRandomMeal():Response<MealListRandomResponseDto>
}