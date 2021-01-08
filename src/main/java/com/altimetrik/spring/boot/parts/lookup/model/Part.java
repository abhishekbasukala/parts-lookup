package com.altimetrik.spring.boot.parts.lookup.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "part")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parts")
    private Long id;

    @Column(name = "parts_name")
    private String name;

    @Column(name = "parts_description")
    private String description;

    @Column(name = "price_per_unit")
    private double pricePerUnit;

    @Column(name = "date_timestamp")
    private Long dateTimeStamp;
}
