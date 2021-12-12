package com.company.kaust.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "KAUST_YSI_SCALES")
@Entity(name = "kaust_YsiScales")
@NamePattern("%s|name")
public class YsiScale extends StandardEntity {
    private static final long serialVersionUID = 9137114179288755872L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SMILES_A")
    private String smiles_a;

    @Column(name = "YSI_A")
    private BigDecimal ysi_a;

    @Column(name = "SMILES_B")
    private String smiles_b;

    @Column(name = "YSI_B")
    private BigDecimal ysi_b;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getYsi_b() {
        return ysi_b;
    }

    public void setYsi_b(BigDecimal ysi_b) {
        this.ysi_b = ysi_b;
    }

    public String getSmiles_b() {
        return smiles_b;
    }

    public void setSmiles_b(String smiles_b) {
        this.smiles_b = smiles_b;
    }

    public BigDecimal getYsi_a() {
        return ysi_a;
    }

    public void setYsi_a(BigDecimal ysi_a) {
        this.ysi_a = ysi_a;
    }

    public String getSmiles_a() {
        return smiles_a;
    }

    public void setSmiles_a(String smiles_a) {
        this.smiles_a = smiles_a;
    }
}