package com.example.recipedemo.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

/**
 * @author : Mingaleev D
 * @data : 5/01/2023
 */


fun isOnline(context: Context): Boolean {
   val connectivityManager =
      context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
   val capabilities =
      connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
   if (capabilities != null) {
      if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
         Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
         return true
      } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
         Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
         return true
      } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
         Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
         return true
      }
   }
   return false
}