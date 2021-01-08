package com.altimetrik.spring.boot.parts.lookup.controller;

import com.altimetrik.spring.boot.parts.lookup.model.BaseResponse;
import com.altimetrik.spring.boot.parts.lookup.model.PartRequest;
import com.altimetrik.spring.boot.parts.lookup.model.PartsResponse;
import com.altimetrik.spring.boot.parts.lookup.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/part")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping("/{id}")
    public ResponseEntity<PartsResponse> getPartsById(@PathVariable(value = "id") Long partId){
        PartsResponse partsResponse = partsService.getPart(partId);
        return ResponseEntity.ok(partsResponse);
    }

    @PostMapping("/")
    public ResponseEntity<BaseResponse> savePart(@RequestBody PartRequest partRequest){
        partsService.savePart(partRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new BaseResponse(String.valueOf(HttpStatus.CREATED.value())
                        , "Successfully saved a part"));
    }

}
