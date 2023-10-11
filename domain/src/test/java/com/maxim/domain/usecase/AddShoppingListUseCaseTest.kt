package com.maxim.domain.usecase

import com.maxim.domain.model.ShoppingListName
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AddShoppingListUseCaseTest {

    private lateinit var addShoppingListUseCase: AddShoppingListUseCase

    @BeforeEach
    fun setUp() {
        addShoppingListUseCase = AddShoppingListUseCase()
    }

    @Test
    fun `should create shopping list`() {
        // Arrange
        val shoppingListName = ShoppingListName("TestShoppingList")

        // Act
        val shoppingList = addShoppingListUseCase.execute(shoppingListName)

        // Assert
        assertNotNull(shoppingList)
        assertEquals(shoppingListName, shoppingList.shoppingListName)
    }
}