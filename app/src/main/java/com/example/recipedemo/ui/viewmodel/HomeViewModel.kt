package com.example.recipedemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipedemo.common.Constants
import com.example.recipedemo.model.model_dto.random.Meal
import com.example.recipedemo.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 5/01/2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val repo: RepositoryImpl
) : ViewModel() {

   private var _mealRandomMutableLiveData =
      MutableLiveData<Meal>()
   val mealRandomLiveData: LiveData<Meal> get() = _mealRandomMutableLiveData

   fun getRandomMeal() {
      viewModelScope.launch(Dispatchers.IO) {
         try {
            val result = repo.fetchRandomMeal()

            if (result.isSuccessful && result.body() != null) {
               _mealRandomMutableLiveData.postValue(result.body()!!.meals[0])
            } else {
               Log.d(Constants.TAG, "getRandomMeal: notSuccessful")
            }
         } catch (e: Exception) {
            Log.d(Constants.TAG, "getRandomMealException: ${e.message}")
         }
      }

   }

}
