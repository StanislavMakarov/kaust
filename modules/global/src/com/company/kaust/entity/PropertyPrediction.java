package com.company.kaust.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "KAUST_PROPERTY_PREDICTION")
@Entity(name = "kaust_PropertyPrediction")
public class PropertyPrediction extends StandardEntity {
    private static final long serialVersionUID = 8442916585139473631L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "propertyPrediction")
    private List<CompositionElement> elements;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "YSI_SCALE_ID")
    private YsiScale ysiScale;

    @Column(name = "RON")
    private BigDecimal ron;

    @Column(name = "MON")
    private BigDecimal mon;

    @Column(name = "YSI")
    private BigDecimal ysi;

    public BigDecimal getYsi() {
        return ysi;
    }

    public BigDecimal getMon() {
        return mon;
    }

    public BigDecimal getRon() {
        return ron;
    }

    public YsiScale getYsiScale() {
        return ysiScale;
    }

    public void setYsiScale(YsiScale ysiScale) {
        this.ysiScale = ysiScale;
    }

    public List<CompositionElement> getElements() {
        return elements;
    }

    public void setElements(List<CompositionElement> elements) {
        this.elements = elements;
    }
}