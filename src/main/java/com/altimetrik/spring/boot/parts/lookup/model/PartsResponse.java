package com.altimetrik.spring.boot.parts.lookup.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class PartsResponse extends BaseResponse {

    private String name;
    private String description;
    private Double price_per_unit;
}
