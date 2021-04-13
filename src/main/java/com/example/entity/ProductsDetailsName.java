package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class ProductsDetailsName {

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

}
