package com.example.thirdmodule.demo.controller;

import com.example.thirdmodule.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class OperationController {
    private static final List<String> listOfLastTenOperations= new LinkedList<>();
    private OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @RequestMapping("/add")
    public double addNumbers(@RequestParam double one, @RequestParam double two) {
        double result = operationService.getAdditionOperationResult(one, two);
        String currentOperation = one + " + " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/subtract")
    public double subtractNumbers(@RequestParam double one, @RequestParam double two) {
        double result = operationService.getSubtractOperationResult(one, two);
        String currentOperation = one + " - " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/multiply")
    public double multiplyNumbers(@RequestParam double one, @RequestParam double two) {
        double result = operationService.getMultiplyOperationResult(one, two);
        String currentOperation = one + " * " + two + " = " + result;
        addOperations(currentOperation);
        return result;
    }

    @RequestMapping("/divide")
    public double divideNumbers(@RequestParam double one, @RequestParam double two) {
        double result = operationService.getDivideOperationResult(one, two);
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
