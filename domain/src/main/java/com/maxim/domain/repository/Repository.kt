package com.maxim.domain.repository

import com.maxim.domain.model.ShoppingListName

interface Repository {
    fun getShoppingList(shoppingListName: ShoppingListName)
    fun saveShoppingList(shoppingListName: ShoppingListName)
}