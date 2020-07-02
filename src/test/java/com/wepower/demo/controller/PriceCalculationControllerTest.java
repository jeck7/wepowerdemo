package com.wepower.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wepower.demo.model.domain.SerachHistroy;
import com.wepower.demo.model.request.CalculationRequest;
import com.wepower.demo.model.response.CalculationResponce;
import com.wepower.demo.service.CalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PriceCalculationControllerTest {
    @Mock
    CalculationService calculationService;
    @InjectMocks
    PriceCalculationController priceCalculationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testHistory() throws JsonProcessingException {
        when(calculationService.history()).thenReturn(Arrays.<SerachHistroy>asList(new SerachHistroy()));

        ResponseEntity<List<SerachHistroy>> result = priceCalculationController.history();
        //Assertions.assertEquals(null, result);
    }

    @Test
    void testCalculate() throws JsonProcessingException {
        when(calculationService.calculatePrice(any())).thenReturn(new CalculationResponce());

        ResponseEntity<CalculationResponce> result = priceCalculationController.calculate(new CalculationRequest());
        //Assertions.assertEquals(null, result);
    }
}
