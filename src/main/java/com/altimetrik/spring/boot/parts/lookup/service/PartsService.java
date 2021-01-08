package com.altimetrik.spring.boot.parts.lookup.service;

import com.altimetrik.spring.boot.parts.lookup.exception.PartsException;
import com.altimetrik.spring.boot.parts.lookup.model.Part;
import com.altimetrik.spring.boot.parts.lookup.model.PartRequest;
import com.altimetrik.spring.boot.parts.lookup.model.PartsResponse;
import com.altimetrik.spring.boot.parts.lookup.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartsService {

    private PartsRepository partsRepository;

    @Autowired
    public PartsService(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    public PartsResponse getPart(Long partId){
        Optional<Part> partOptional = partsRepository.findById(partId);

        Part part = partOptional
                .orElseThrow(() -> new PartsException("No parts found !!", HttpStatus.NOT_FOUND));

        return toPartsResponse(part).get();
    }

    public Part savePart(PartRequest partRequest) {
        Part part = partsRepository.save(toPart(partRequest));
        if(part == null){
            throw new PartsException("Error saving Part", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return part;
    }

    private Part toPart(PartRequest partRequest) {
        return Part.builder()
                .name(partRequest.getName())
                .description(partRequest.getDescription())
                .pricePerUnit(partRequest.getPricePerUnit())
                .dateTimeStamp(System.currentTimeMillis())
                .build();
    }

    private Optional<PartsResponse> toPartsResponse(Part part){
        return Optional.of(PartsResponse.builder()
                .name(part.getName())
                .description(part.getDescription())
                .price_per_unit(part.getPricePerUnit())
                .build());
    }
}
