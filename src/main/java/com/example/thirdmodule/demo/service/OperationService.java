package com.example.thirdmodule.demo.service;

import org.springframework.stereotype.Service;

@Service
public class OperationService {

    public double getAdditionOperationResult(double one, double two) {
        double result = one + two;
        return result;
    }

    public double getSubtractOperationResult(double one, double two) {
        double result = one - two;
        return result;
    }

    public double getMultiplyOperationResult(double one, double two) {
        double result = one * two;
        return result;
    }

    public double getDivideOperationResult(double one, double two) {
        if (two == 0) {
            throw new NumberFormatException("Error. Divison by zero");
        }
        double result = one / two;
        return result;
    }

}
