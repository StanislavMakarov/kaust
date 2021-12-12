package com.company.kaust.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "KAUST_FUEL_FAMILY_CONSTRAINT")
@Entity(name = "kaust_FuelFamilyConstraint")
public class FuelFamilyConstraint extends StandardEntity {
    private static final long serialVersionUID = -8182409490076886233L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUEL_ID")
    private FuelDesign fuel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_ID")
    private Family family;

    @Column(name = "VALUE_")
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public FuelDesign getFuel() {
        return fuel;
    }

    public void setFuel(FuelDesign fuel) {
        this.fuel = fuel;
    }
}