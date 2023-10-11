package com.maxim.domain.usecase

import com.maxim.domain.model.ShoppingList
import com.maxim.domain.model.ShoppingListName
import com.maxim.domain.repository.Repository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

class GetShoppingListUseCaseTest {

    private val repository = mock<Repository>()
    private val getShoppingListUseCase = GetShoppingListUseCase(repository)

    @Test
    fun `should get shopping list`() {
        // Arrange
        val shoppingListName = ShoppingListName("TestShoppingList")
        val expectedShoppingList = ShoppingList(shoppingListName)
        `when`(repository.getShoppingList(shoppingListName)).thenReturn(expectedShoppingList)

        // Act
        val result = getShoppingListUseCase.execute(shoppingListName)

        // Assert
        assertNotNull(result)
        assertEquals(expectedShoppingList, result)
    }
}