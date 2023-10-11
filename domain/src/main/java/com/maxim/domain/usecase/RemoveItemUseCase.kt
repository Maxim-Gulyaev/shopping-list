package com.maxim.domain.usecase

import com.maxim.domain.model.Item
import com.maxim.domain.model.ShoppingList

class RemoveItemUseCase {
    fun execute(item: Item, shoppingList: ShoppingList): Boolean =
        shoppingList.listOfShopping.remove(item)
}