package com.refinitiv.risk.calculator.web.rest;

import com.refinitiv.risk.calculator.domain.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorResource {

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Map<String,String> body) {
        Result result = new Result();
        //TODO Calculate logic goes here
        result.setOperation("add");
        result.setResult(0d);
        return ResponseEntity.ok().body(result);
    }
}
