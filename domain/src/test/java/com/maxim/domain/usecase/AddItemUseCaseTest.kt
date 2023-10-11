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
        // Arrange
        val item1 = Item("Item 1")
        val item2 = Item("Item 2")

        // Act
        addItemUseCase.execute(item1, shoppingList)
        addItemUseCase.execute(item2, shoppingList)

        // Assert
        assertTrue(shoppingList.listOfShopping.contains(item1))
        assertTrue(shoppingList.listOfShopping.contains(item2))
    }

    @Test
    fun `should not add duplicate item`() {
        // Arrange
        val item1 = Item("Item 1")

        // Act
        addItemUseCase.execute(item1, shoppingList)
        addItemUseCase.execute(item1, shoppingList)

        // Assert
        assertEquals(1, shoppingList.listOfShopping.size)
    }


}