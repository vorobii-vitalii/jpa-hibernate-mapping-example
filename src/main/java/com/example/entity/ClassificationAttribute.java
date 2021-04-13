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

@Entity
@Data
@Table(name = "classification_attribute")
public class ClassificationAttribute {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "scope")
    private String scope;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "classification_attribute_type_id")
    private ClassificationAttributeType classificationAttributeType;

}
