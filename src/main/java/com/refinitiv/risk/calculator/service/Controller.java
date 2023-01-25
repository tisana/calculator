package com.refinitiv.risk.calculator.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Controller {
    private String calculate(int x, String operation, int y){
        String result;
        switch (operation){
            case "+":
                result = String.valueOf(x + y);
                break;
            case "-":
                result = String.valueOf(x - y);
                break;
            case "*":
            case "x":
                result = String.valueOf(x * y);
                break;
            case "/":
                result = String.valueOf((double)(x) / y);
                break;
            default:
                result = "Unrecognised operation error";
        }
        return result;
    }
    @GetMapping("/")
    String welcome() {
        return "Welcome";
    }
    @GetMapping("/{numberA}/{numberB}") // divide
    String calc(@PathVariable int numberA, @PathVariable int numberB){
        return calculate(numberA, "/", numberB);
    }
    @GetMapping("/{mathematicalExpression}") // making the request as natural as possible, so the input could be 123+45
    String calc(@PathVariable String mathematicalExpression){
        String regex = "\\D";
        Pattern expression = Pattern.compile(regex);
        Matcher operator = expression.matcher(mathematicalExpression.toLowerCase());
        if (operator.find()){
            String[] numStr = mathematicalExpression.split(regex);
            return calculate(Integer.parseInt(numStr[0]), operator.group(), Integer.parseInt(numStr[1]));
        } else {
            return "Incorrect mathematical expression";
        }
    }
}
