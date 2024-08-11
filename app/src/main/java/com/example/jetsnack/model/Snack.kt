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
        price = 1000

    ),
    Snack(
        id = 2L,
        name = "Personal pizza",
        tagline = "A tag line",
        imageRes = R.drawable.personalpizza,
        price = 299
    ),
    Snack(
        id = 3L,
        name = "Cheesy Garlic Breads",
        tagline = "A tag line",
        imageRes = R.drawable.garlicgreads  ,
        price = 299
    ),

    //Soft drinks
    Snack(
        id = 4L,
        name = "Coca-Cola",
        tagline = "A tag line",
        imageRes = R.drawable.rcola,
        price = 299
    ),
    Snack(
        id = 5L,
        name = "Zero Coca-Cola",
        tagline = "A tag line",
        imageRes = R.drawable.zcola,
        price = 299
    ),
    Snack(
        id = 6L,
        name = "Soda",
        tagline = "A tag line",
        imageRes = R.drawable.soda,
        price = 299
    ),
    Snack(
        id = 7L,
        name = "Mango",
        tagline = "A tag line",
        imageRes = R.drawable.mango,
        price = 299
    ),

    Snack(
        id = 8L,
        name = "Fanta",
        tagline = "A tag line",
        imageRes = R.drawable.fanta,
        price = 299
    ),
    Snack(
        id = 9L,
        name = "Sprite",
        tagline = "A tag line",
        imageRes = R.drawable.rsprite,
        price = 299
    ),
    Snack(
        id = 10L,
        name = "Zero-Sprite",
        imageRes = R.drawable.zsprite,
        price = 299
    ),
)

