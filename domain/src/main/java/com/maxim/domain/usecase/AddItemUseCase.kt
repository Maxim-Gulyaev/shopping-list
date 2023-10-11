package com.maxim.domain.usecase

import com.maxim.domain.model.Item
import com.maxim.domain.model.ShoppingList

class AddItemUseCase {
    fun execute(item: Item, shoppingList: ShoppingList) {
        shoppingList.listOfShopping.add(item)
    }
}