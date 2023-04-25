package com.test.inditex.controller;

import com.test.inditex.domain.PricesResponse;
import com.test.inditex.service.InditexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final InditexService inditexService;

    @GetMapping("/{date}/{productId}/{brandId}")
    public ResponseEntity<List<PricesResponse>> getInditexData(@PathVariable String date,
                                                               @PathVariable Integer productId,
                                                               @PathVariable Integer brandId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        LocalDateTime tranformedDate = LocalDateTime.parse(date,formatter);
        return new ResponseEntity<>(inditexService.getData(tranformedDate,productId,brandId), HttpStatus.OK);
    }
}
