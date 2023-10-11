package com.maxim.domain.model

data class ShoppingList(val shoppingListName: ShoppingListName) {
    val listOfShopping = mutableSetOf<Item>()
}
