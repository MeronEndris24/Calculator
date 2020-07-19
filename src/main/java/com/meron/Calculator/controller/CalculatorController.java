package com.meron.Calculator.controller;

import com.meron.Calculator.domain.Calculator;
import com.meron.Calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CalculatorController {

    CalculatorService calculatorService;

    @Autowired
    CalculatorController(CalculatorService calculatorService)
    {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operator", "+");
        model.addAttribute("view", "views/calculatorForm");
        return "base-layout";
    }

    @PostMapping("/")
    public String index(@RequestParam String leftOperand, @RequestParam String operator,
                        @RequestParam String rightOperand, Model model)
    {
        double leftNumber;
        double rightNumber;

        try {
            leftNumber = Double.parseDouble(leftOperand);
            rightNumber = Double.parseDouble(rightOperand);
        }
        catch (NumberFormatException ex) {
            leftNumber = 0; rightNumber = 0;
        }

        double result = calculatorService.calculateResult(leftNumber, rightNumber, operator);
        List<Calculator> calPage = calculatorService.getCalculations().getContent();

        model.addAttribute("leftOperand", leftNumber);
        model.addAttribute("operator", operator);
        model.addAttribute("rightOperand", rightNumber);
        model.addAttribute("result", result);
        model.addAttribute("calPage", calPage);
        model.addAttribute("view", "views/calculatorForm");

        return "base-layout";
    }

}
