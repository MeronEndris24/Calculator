package com.meron.Calculator.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double leftOperand;
    private double rightOperand;
    private String operator;
    private double result;

    public Calculator(double leftOperand, double rightOperand, String operator, double result) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
        this.result = result;
    }

}
