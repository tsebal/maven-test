package ru.javarush.tsebal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    //<methodWeTest><ShouldReturnSomething/ShouldDoSomething/ShouldThrowException><If/When><Condition>
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Testing calculator division.")
    void calculateShouldReturnDivisionResultForPositiveNumbers() {
        int actual = calculator.calculate(1, Operation.DIV, 2);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateShouldThrowExceptionWhenDivisionIsZero() {
        CalculationRuntimeException actualException = Assertions.assertThrows(CalculationRuntimeException.class,
                () -> calculator.calculate(1, Operation.DIV, 0), "Exception should be thrown.");

        Assertions.assertEquals("Divisor is zero.", actualException.getMessage());
    }
}