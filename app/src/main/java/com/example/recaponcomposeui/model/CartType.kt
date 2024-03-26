package com.example.recaponcomposeui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CartType(
   @StringRes val stringResourceId : Int,
   @DrawableRes val drawableResourceId : Int
)
