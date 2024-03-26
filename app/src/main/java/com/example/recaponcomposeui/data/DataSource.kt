package com.example.recaponcomposeui.data

import com.example.recaponcomposeui.R
import com.example.recaponcomposeui.model.CartType

class DataSource(){
    fun loadCartItems():List<CartType>{
        return listOf<CartType>(
            CartType(R.string.name,R.drawable.allela),
            CartType(R.string.daaaaaa,R.drawable.allelaclass),
            CartType(R.string.deee,R.drawable.giraffe),
            CartType(R.string.dod,R.drawable.a),
        )
    }
}