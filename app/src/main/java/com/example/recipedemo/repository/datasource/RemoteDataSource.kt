package com.example.recipedemo.repository.datasource

import com.example.recipedemo.model.model_dto.random.MealListRandomResponseDto
import retrofit2.Response

/**
 * @author : Mingaleev D
 * @data : 5/01/2023
 */

interface RemoteDataSource  {

   suspend fun fetchRandomMeal():Response<MealListRandomResponseDto>
}