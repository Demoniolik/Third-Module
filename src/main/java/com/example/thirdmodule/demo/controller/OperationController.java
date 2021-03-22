package com.example.thirdmodule.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class OperationController {
    private static final List<String> listOfLastTenOperations= new LinkedList<>();

    @RequestMapping("/add")
    public double addNumbers(@RequestParam double one, @RequestParam double two) {
        double result = one + two;
        String currentOperation = one + " + " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/subtract")
    public double subtractNumbers(@RequestParam double one, @RequestParam double two) {
        double result = one - two;
        String currentOperation = one + " - " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/multiply")
    public double multiplyNumbers(@RequestParam double one, @RequestParam double two) {
        double result = one * two;
        String currentOperation = one + " * " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/divide")
    public double divideNumbers(@RequestParam double one, @RequestParam double two) {
        if (two == 0) {
            throw new NumberFormatException("Error. Divison by zero");
        }
        double result = one / two;
        String currentOperation = one + " / " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/operations")
    public List<String> operationsNumbers() {
        return listOfLastTenOperations;
    }

    private void addOperations(String currentOperation) {
        if (listOfLastTenOperations.size() == 10) {
            listOfLastTenOperations.remove(0);
        }
        listOfLastTenOperations.add(currentOperation);
    }
}
