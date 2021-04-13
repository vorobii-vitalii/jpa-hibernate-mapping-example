package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "classification_attribute_value")
public class ClassificationAttributeValue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "decimal_value")
    private BigDecimal decimalValue;

    @Column(name = "int_value")
    private Long intValue;

    @Column(name = "txt_value")
    private String textValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    @OneToOne
    @JoinColumn(name = "classification_attribute_id")
    private ClassificationAttribute classificationAttribute;



}
