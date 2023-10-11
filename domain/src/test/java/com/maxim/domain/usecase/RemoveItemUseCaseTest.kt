package com.maxim.domain.usecase

import com.maxim.domain.model.Item
import com.maxim.domain.model.ShoppingList
import com.maxim.domain.model.ShoppingListName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RemoveItemUseCaseTest {

    private lateinit var removeItemUseCase: RemoveItemUseCase
    private lateinit var shoppingList: ShoppingList

    @BeforeEach
    fun setUp() {
        removeItemUseCase = RemoveItemUseCase()
        shoppingList = ShoppingList(ShoppingListName("testShoppingList"))
    }

    @Test
    fun `should remove the item from list`() {
        // Arrange
        val item1 = Item("Item 1")
        val item2 = Item("Item 2")
        shoppingList.listOfShopping.add(item1)
        shoppingList.listOfShopping.add(item2)

        // Act
        val result = removeItemUseCase.execute(item1, shoppingList)

        // Assert
        assertTrue(result)
        assertFalse(shoppingList.listOfShopping.contains(item1))
        assertEquals(1, shoppingList.listOfShopping.size)
    }

    @Test
    fun `should not remove not existing item from list`() {
        // Arrange
        val item1 = Item("Item 1")
        val item2 = Item("Item 2")
        val itemToRemove = Item("Item to Remove")
        shoppingList.listOfShopping.add(item1)
        shoppingList.listOfShopping.add(item2)

        // Act
        val result = removeItemUseCase.execute(itemToRemove, shoppingList)

        // Assert
        assertFalse(result)
        assertEquals(2, shoppingList.listOfShopping.size)
    }
}