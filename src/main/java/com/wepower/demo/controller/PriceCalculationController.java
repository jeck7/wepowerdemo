package com.wepower.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wepower.demo.model.domain.SerachHistroy;
import com.wepower.demo.model.request.CalculationRequest;
import com.wepower.demo.model.response.CalculationResponce;
import com.wepower.demo.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceCalculationController {

    @Autowired
    CalculationService calculationService;

    @GetMapping("/history")
    public ResponseEntity<List<SerachHistroy>> history() throws JsonProcessingException {
        List<SerachHistroy> history = calculationService.history();
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @PostMapping("/calculateprice")
    public ResponseEntity<CalculationResponce> calculate(
            @RequestBody CalculationRequest request) throws JsonProcessingException {
        CalculationResponce calculationResponce = calculationService.calculatePrice(request);
        return new ResponseEntity<CalculationResponce>(calculationResponce, HttpStatus.OK);
    }
}
