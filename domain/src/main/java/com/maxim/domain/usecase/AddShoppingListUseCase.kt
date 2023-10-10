package com.maxim.domain.usecase

import com.maxim.domain.model.ShoppingList
import com.maxim.domain.model.ShoppingListName

class AddShoppingListUseCase {
    fun execute(shoppingListName: ShoppingListName): ShoppingList = ShoppingList(shoppingListName)
}