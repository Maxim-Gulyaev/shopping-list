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
        val item1 = Item("Item 1")
        val item2 = Item("Item 2")

        // Add items to the shopping list
        shoppingList.listOfShopping.add(item1)
        shoppingList.listOfShopping.add(item2)

        // Remove an item
        val result = removeItemUseCase.execute(item1, shoppingList)

        // Verify that the item was removed
        assertTrue(result)
        assertFalse(shoppingList.listOfShopping.contains(item1))
        assertEquals(1, shoppingList.listOfShopping.size) // Ensure that only one item is left in the list
    }

    @Test
    fun `should not remove not existing item from list`() {
        val item1 = Item("Item 1")
        val item2 = Item("Item 2")
        val itemToRemove = Item("Item to Remove")

        // Add items to the shopping list
        shoppingList.listOfShopping.add(item1)
        shoppingList.listOfShopping.add(item2)

        // Attempt to remove a non-existing item
        val result = removeItemUseCase.execute(itemToRemove, shoppingList)

        // Verify that the item was not removed
        assertFalse(result)
        assertEquals(2, shoppingList.listOfShopping.size) // Ensure that no items were removed from the list
    }
}