package com.example.recipedemo.repository

import com.example.recipedemo.model.remote.api.MealApi
import com.example.recipedemo.repository.datasource.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 5/01/2023
 */

class RepositoryImpl @Inject constructor(
   private val api: MealApi
) : RemoteDataSource {

   override suspend fun fetchRandomMeal() =
      withContext(Dispatchers.IO) {
         api.fetchRandomMeal()
      }
}