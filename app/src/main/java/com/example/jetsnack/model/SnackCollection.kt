package com.example.jetsnack.model

import androidx.compose.runtime.Immutable

@Immutable
data class SnackCollection(
    val id: Long,
    val name: String,
    val snacks: List<Snack>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }

/**
 * A fake repo
 */
object SnackRepo {
    fun getSnacks(): List<SnackCollection> = snackCollections
    fun getSnack(snackId: Long) = snacks.find { it.id == snackId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
    fun getInspiredByCart() = inspiredByCart
    fun getFilters() = filters
    fun getPriceFilters() = priceFilters
    fun getCart() = cart
    fun getSortFilters() = sortFilters
    fun getCategoryFilters() = categoryFilters
    fun getSortDefault() = sortDefault
    fun getLifeStyleFilters() = lifeStyleFilters
}



private val mainFoods = SnackCollection(
    id = 1L,
    name = "Our main ones!",
    type = CollectionType.Highlight,
    snacks = snacks.subList(0, 4)
)

private val softDrinks = SnackCollection(
    id = 2L,
    name = "soft drinks",
    snacks = snacks.subList(5, 11)
)


private val also = mainFoods.copy(
    id = 5L,
    name = "Customers also bought"
)

private val inspiredByCart = mainFoods.copy(
    id = 6L,
    name = "Inspired by your cart"
)

private val snackCollections = listOf(
    mainFoods,
    softDrinks,
)

private val related = listOf(
    also,
    softDrinks
)

private val cart = listOf(
    OrderLine(snacks[4], 2),
    OrderLine(snacks[6], 3),
    OrderLine(snacks[8], 1)
)

@Immutable
data class OrderLine(
    val snack: Snack,
    val count: Int
)
