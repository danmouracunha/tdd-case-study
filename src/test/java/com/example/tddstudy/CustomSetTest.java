package com.example.tddstudy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CustomSetTest {

    @Order(1)
    @ParameterizedTest
    @DisplayName("Should add one valid input and increment size without throw Exception")
    @MethodSource("sourceDifferentInputs")
    public void testCustomSetAdd_whenHasAValidInput_thenDontThrowException(List<Integer> dataInput, CustomSet<Integer> currentList) {
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
    public void testCustomSetGet_whenHasAValidInput_thenReturnCorrectPosition() {
        // Arrange
        CustomSet<String> customSet = new CustomSet<>();
        customSet.add("122");
        customSet.add("222");
        customSet.add("333");
        // Act & Assert
        var value = assertDoesNotThrow(() -> customSet.get(1));
        // Assert
        assertEquals("222", value);

    }

    private static Stream<Arguments> sourceDifferentInputs() {
        CustomSet<Integer> customSet = new CustomSet<>();
        customSet.add(1);
        return Stream.of(Arguments.of(new ArrayList<>(), new CustomSet<>()),
                Arguments.of(new ArrayList<>(List.of(2, 3, 4)), customSet));
    }


}