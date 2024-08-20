package com.example.tddstudy.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {
    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    @DisplayName("It should calculate a division with a valid entry and return the result correctly")
    void successfulIntegerDivisionCalculator() {
        var result = calculatorService.divide(4, 2);

        assertEquals(2, result);
    }

    @Test
    @DisplayName("It should fail when divide method have a division by zero")
    void failedIntegerDivisionCalculator() {
        Integer a = 4;
        Integer b = 0;
        assertThrows(ArithmeticException.class, () -> calculatorService.divide(a,b));
    }

    @Test
    @DisplayName("It should calculate a subtraction with a valid entry and return the result correctly")
    void successfulIntegerSubtractionCalculator() {
        var result = calculatorService.subtract(3,2);
        assertEquals(1,result);
    }
}