package com.company.kaust.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Table(name = "KAUST_COMPOSITION_ELEMENT")
@Entity(name = "kaust_CompositionElement")
public class CompositionElement extends StandardEntity {
    private static final long serialVersionUID = 1197148886009150673L;

    @Column(name = "SMILES", nullable = false)
    @NotNull
    private String smiles;

    @Column(name = "VALUE_")
    private BigDecimal value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROPERTY_PREDICTION_ID")
    private PropertyPrediction propertyPrediction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUEL_DESIGN_ID")
    private FuelDesign fuelDesign;

    public FuelDesign getFuelDesign() {
        return fuelDesign;
    }

    public void setFuelDesign(FuelDesign fuelDesign) {
        this.fuelDesign = fuelDesign;
    }

    public PropertyPrediction getPropertyPrediction() {
        return propertyPrediction;
    }

    public void setPropertyPrediction(PropertyPrediction propertyPrediction) {
        this.propertyPrediction = propertyPrediction;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getSmiles() {
        return smiles;
    }

    public void setSmiles(String smiles) {
        this.smiles = smiles;
    }
}