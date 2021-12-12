package com.company.kaust.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

@MetaClass(name = "kaust_ThermoSearch")
@NamePattern("%s|name")
public class ThermoSearch extends BaseUuidEntity {
    private static final long serialVersionUID = 618677860596403626L;

    @MetaProperty
    private String name;

    @MetaProperty
    private String smiles;

    @MetaProperty
    private String inchi;

    @MetaProperty
    private String descriptors;

    public String getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(String descriptors) {
        this.descriptors = descriptors;
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