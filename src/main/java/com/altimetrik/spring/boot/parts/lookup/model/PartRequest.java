package com.altimetrik.spring.boot.parts.lookup.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartRequest {

    private String name;
    private String description;
    private Double pricePerUnit;

}
