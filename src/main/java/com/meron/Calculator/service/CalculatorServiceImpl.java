package com.meron.Calculator.service;

import com.meron.Calculator.domain.Calculator;
import com.meron.Calculator.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    CalculatorRepository repository;

    @Autowired
    CalculatorServiceImpl(CalculatorRepository calculatorRepository)
    {
        this.repository = calculatorRepository;
    }

    @Override
    public double calculateResult(double leftOperand, double rightOperand, String operator) {
        double result = 0;
        switch(operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                result = leftOperand / rightOperand;
                break;
            case "^":
                result = Math.pow(leftOperand, rightOperand);
                break;
            default:
                result = 0;
        }
        repository.save(new Calculator(leftOperand, rightOperand, operator, result));
        return result;
    }

    @Override
    public Page<Calculator> getCalculations() {
        return repository.findAll(PageRequest.of(0, 10, Sort.by("id").descending()));
    }
}
