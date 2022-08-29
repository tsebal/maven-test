package ru.javarush.tsebal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private static final Map<Operation, BiFunction<Integer, Integer, Integer>> OPERATION_BY_ACTION = new HashMap<>();

    static {
        OPERATION_BY_ACTION.put(Operation.ADD, Integer::sum);
        OPERATION_BY_ACTION.put(Operation.MINUS, (a, b) -> a - b);
        OPERATION_BY_ACTION.put(Operation.MULT, (a, b) -> a * b);
        OPERATION_BY_ACTION.put(Operation.DIV, Calculator::division);
    }

    public int calculate(int argument1, Operation operation, int argument2) {
        return OPERATION_BY_ACTION.getOrDefault(operation, DEFAULT_ACTION).apply(argument1, argument2);
    }

    private static final BiFunction<Integer, Integer, Integer> DEFAULT_ACTION = (a, b) -> 0;

    private static int division(Integer a, Integer b) {
        if (b == 0) {
            throw new CalculationRuntimeException("Divisor is zero.");
        }
        return a / b;
    }
}

enum Operation {
    ADD,
    MINUS,
    MULT,
    DIV
}

class CalculationRuntimeException extends RuntimeException {
    public CalculationRuntimeException(String message) {
        super(message);
    }
}