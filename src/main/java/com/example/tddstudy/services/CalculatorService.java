package com.example.tddstudy.services;

public class CalculatorService  implements ICalculatorService {
    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

}
