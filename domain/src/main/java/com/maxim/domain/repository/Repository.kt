package com.maxim.domain.repository

import com.maxim.domain.model.ShoppingList
import com.maxim.domain.model.ShoppingListName

interface Repository {
    fun getShoppingList(shoppingListName: ShoppingListName): ShoppingList
    fun saveShoppingList(shoppingListName: ShoppingListName)
}