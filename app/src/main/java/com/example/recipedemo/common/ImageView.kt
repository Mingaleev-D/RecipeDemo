package com.example.recipedemo.common

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author : Mingaleev D
 * @data : 5/01/2023
 */

fun ImageView.load(url: String){
   Glide.with(context).load(url).into(this)
}