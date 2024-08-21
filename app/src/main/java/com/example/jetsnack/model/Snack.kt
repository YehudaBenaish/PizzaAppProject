package com.example.jetsnack.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.jetsnack.R

@Immutable
data class Snack(
    val id: Long,
    val name: String,
    @DrawableRes
    val imageRes: Int,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet()
)

/**
 * Static data
 */

val snacks = listOf(
    Snack(
        id = 1L,
        name = "פיצה משפחתית",
        imageRes = R.drawable.pizza,
        price = 1500

    ),
    Snack(
        id = 2L,
        name = "מרגריטה",
        imageRes = R.drawable.personalpizza,
        price = 1000
    ),
    Snack(
        id = 3L,
        name = "לחם שום מוקרם",
        imageRes = R.drawable.garlicgreads  ,
        price = 800
    ),
    Snack(
        id = 4L,
        name = "סלט הבית",
        imageRes = R.drawable.sald ,
        price = 800
    ),

    //Soft drinks
    Snack(
        id = 5L,
        name = "Coca-Cola",
        imageRes = R.drawable.rcola,
        price = 200
    ),
    Snack(
        id = 6L,
        name = "Zero Coca-Cola",
        imageRes = R.drawable.zcola,
        price = 200
    ),
    Snack(
        id = 7L,
        name = "Soda",
        imageRes = R.drawable.soda,
        price = 200
    ),
    Snack(
        id = 8L,
        name = "Mango",
        imageRes = R.drawable.mango,
        price = 200
    ),

    Snack(
        id = 9L,
        name = "Fanta",
        imageRes = R.drawable.fanta,
        price = 200
    ),
    Snack(
        id = 10L,
        name = "Sprite",
        imageRes = R.drawable.rsprite,
        price = 200
    ),
    Snack(
        id = 11L,
        name = "Zero-Sprite",
        imageRes = R.drawable.zsprite,
        price = 200
    ),
)

