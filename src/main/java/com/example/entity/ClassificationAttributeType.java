package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "classification_attribute_type")
public class ClassificationAttributeType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private String value;

    @Column(name = "validation_reg_exp")
    private String validationRegularExpression;

    @OneToOne(mappedBy = "classificationAttributeType")
    private ClassificationAttribute classificationAttribute;

}
