package com.maxim.domain.usecase

import com.maxim.domain.model.Item
import com.maxim.domain.model.ShoppingList
import com.maxim.domain.model.ShoppingListName
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AddItemUseCaseTest {

    private lateinit var addItemUseCase: AddItemUseCase
    private lateinit var shoppingList: ShoppingList

    @BeforeEach
    fun setUp() {
        addItemUseCase = AddItemUseCase()
        shoppingList = ShoppingList(ShoppingListName("testShoppingList"))
    }

    @Test
    fun `should add the item in list`() {
        val item1 = Item("Item 1")
        val item2 = Item("Item 2")

        addItemUseCase.execute(item1, shoppingList)
        addItemUseCase.execute(item2, shoppingList)

        assertTrue(shoppingList.listOfShopping.contains(item1))
        assertTrue(shoppingList.listOfShopping.contains(item2))
    }

    @Test
    fun `should not add duplicate item`() {
        val item1 = Item("Item 1")

        addItemUseCase.execute(item1, shoppingList)
        addItemUseCase.execute(item1, shoppingList)

        assertEquals(1, shoppingList.listOfShopping.size)
    }


}