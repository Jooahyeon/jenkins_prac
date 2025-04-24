package com.example.demo.service;

import com.example.demo.dto.CalculatorDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceTest {

    private static final Logger log = LoggerFactory.getLogger(Chap0101BootprojectApplicationTests.class);
    @Autowired
    private CalculatorService calculatorService;

    @Test
    void contextLoads() {
    }


    //    RequestBody (자바스크립트의 객체를 뭐시기)
    @PostMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(@RequestBody CalculatorDTO calculatorDTO) {

        log.info("calculatorDTO: {}", calculatorDTO);
        int result = calculatorService.plusTwoNumbers(calculatorDTO);
        calculatorDTO.setSum(result);

        return ResponseEntity
                .ok()
                .body(calculatorDTO);

    }

}