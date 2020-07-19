package com.meron.Calculator.service;

import com.meron.Calculator.domain.Calculator;
import org.springframework.data.domain.Page;

public interface CalculatorService {

    double calculateResult(double leftOperand, double rightOperand, String operator);
    public Page<Calculator> getCalculations();

}
