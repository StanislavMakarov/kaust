package com.company.kaust.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "KAUST_COMPONENT")
@Entity(name = "kaust_Component")
@NamePattern("%s|name")
public class Component extends StandardEntity {
    private static final long serialVersionUID = -2934053857988543766L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "SMILES", nullable = false, unique = true)
    @NotNull
    private String smiles;

    @Column(name = "INCHI", nullable = false, unique = true)
    @NotNull
    private String inchi;

    @Column(name = "FORMULA")
    private String formula;

    @Column(name = "CBS_VALUE")
    private Double cbs_value;

    @Column(name = "G3_VALUE")
    private Double g3_value;

    @Column(name = "G4_VALUE")
    private Double g4_value;

    @Column(name = "G4X_VALUE")
    private Double g4x_value;

    @Column(name = "DESCRIPTPRS")
    private String descriptprs;

    public String getDescriptprs() {
        return descriptprs;
    }

    public void setDescriptprs(String descriptprs) {
        this.descriptprs = descriptprs;
    }

    public Double getG4x_value() {
        return g4x_value;
    }

    public void setG4x_value(Double g4x_value) {
        this.g4x_value = g4x_value;
    }

    public Double getG4_value() {
        return g4_value;
    }

    public void setG4_value(Double g4_value) {
        this.g4_value = g4_value;
    }

    public Double getG3_value() {
        return g3_value;
    }

    public void setG3_value(Double g3_value) {
        this.g3_value = g3_value;
    }

    public Double getCbs_value() {
        return cbs_value;
    }

    public void setCbs_value(Double cbs_value) {
        this.cbs_value = cbs_value;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getInchi() {
        return inchi;
    }

    public void setInchi(String inchi) {
        this.inchi = inchi;
    }

    public String getSmiles() {
        return smiles;
    }

    public void setSmiles(String smiles) {
        this.smiles = smiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}