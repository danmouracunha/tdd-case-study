package com.example.tddstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CustomLinkedListTest {

    @Order(1)
    @ParameterizedTest
    @DisplayName("Should add one valid input and increment size without throw Exception")
    @MethodSource("sourceDifferentInputs")
    public void testCustomLinkedListAdd_whenHasAValidInput_thenDontThrowException(List<Integer> dataInput, CustomLinkedList<Integer> currentList) {
        long sizeBeforeAdding = currentList.getSize();
        // Act & Assert
        for (Integer valueToAdd : dataInput) {
            assertDoesNotThrow(() -> currentList.add(valueToAdd));
        }
        assertEquals(dataInput.size() + sizeBeforeAdding, currentList.getSize());
    }

    @Order(2)
    @Test
    @DisplayName("Should get one position without throw Exception")
    public void testCustomLinkedListGet_whenHasAValidInput_thenReturnCorrectPosition() {
        // Arrange
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("122");
        customLinkedList.add("222");
        customLinkedList.add("333");
        // Act & Assert
        var value = assertDoesNotThrow(() -> customLinkedList.get(1));
        // Assert
        assertEquals("222", value);

    }
    @Test
    @Order(3)
    public void testCustomLinkedListRemove_whenHasOneElement_shouldHaveSizeZeroAndNoElements() {
        // Arrange
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Testing-123");
        // Act
        customLinkedList.remove(0);
        // Assert
        assertEquals(0, customLinkedList.getSize());
        assertThrows(RuntimeException.class, () -> customLinkedList.get(0));
    }

    @Test
    @Order(4)
    public void testCustomLinkedListRemove_whenHasMoreThanOneElement_shouldHaveSizeZeroAndNoElements() {
        // Arrange
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Testing-123");
        customLinkedList.add("Testing-321");
        customLinkedList.add("Testing-111");
        // Act
        customLinkedList.remove(1);
        // Assert
        assertEquals("Testing-123", customLinkedList.get(0));
        assertEquals("Testing-111", customLinkedList.get(1));
        assertEquals(2, customLinkedList.getSize());
    }

    private static Stream<Arguments> sourceDifferentInputs() {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        return Stream.of(Arguments.of(new ArrayList<>(), new CustomLinkedList<>()),
                Arguments.of(new ArrayList<>(List.of(2, 3, 4)), customLinkedList));
    }


}