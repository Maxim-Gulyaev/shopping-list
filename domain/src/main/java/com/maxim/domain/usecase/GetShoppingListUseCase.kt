package com.maxim.domain.usecase

import com.maxim.domain.model.ShoppingListName
import com.maxim.domain.repository.Repository

class GetShoppingListUseCase(private val repository: Repository) {
    fun execute(shoppingListName: ShoppingListName) = repository.getShoppingList(shoppingListName)
}