package com.company.kaust.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "KAUST_FUEL_DESIGN")
@Entity(name = "kaust_FuelDesign")
@NamePattern("%s %s %s|targetRon,targetMon,targetYsi")
public class FuelDesign extends StandardEntity {
    private static final long serialVersionUID = -8088632963032198130L;

    @Column(name = "TARGET_RON")
    private BigDecimal targetRon;

    @Column(name = "TARGET_MON")
    private BigDecimal targetMon;

    @Column(name = "TARGET_YSI")
    private BigDecimal targetYsi;

    @Column(name = "NUMBER_OF_COMPONENTS")
    private Integer numberOfComponents;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "fuelDesign")
    private List<CompositionElement> constraintElements;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "fuel")
    private List<FuelFamilyConstraint> familyConstraints;

    public List<FuelFamilyConstraint> getFamilyConstraints() {
        return familyConstraints;
    }

    public void setFamilyConstraints(List<FuelFamilyConstraint> familyConstraints) {
        this.familyConstraints = familyConstraints;
    }

    public List<CompositionElement> getConstraintElements() {
        return constraintElements;
    }

    public void setConstraintElements(List<CompositionElement> constraintElements) {
        this.constraintElements = constraintElements;
    }

    public Integer getNumberOfComponents() {
        return numberOfComponents;
    }

    public void setNumberOfComponents(Integer numberOfComponents) {
        this.numberOfComponents = numberOfComponents;
    }

    public BigDecimal getTargetYsi() {
        return targetYsi;
    }

    public void setTargetYsi(BigDecimal targetYsi) {
        this.targetYsi = targetYsi;
    }

    public BigDecimal getTargetMon() {
        return targetMon;
    }

    public void setTargetMon(BigDecimal targetMon) {
        this.targetMon = targetMon;
    }

    public BigDecimal getTargetRon() {
        return targetRon;
    }

    public void setTargetRon(BigDecimal targetRon) {
        this.targetRon = targetRon;
    }
}