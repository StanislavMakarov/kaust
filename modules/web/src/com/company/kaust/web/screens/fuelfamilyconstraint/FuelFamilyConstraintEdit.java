package com.company.kaust.web.screens.fuelfamilyconstraint;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.FuelFamilyConstraint;

@UiController("kaust_FuelFamilyConstraint.edit")
@UiDescriptor("fuel-family-constraint-edit.xml")
@EditedEntityContainer("fuelFamilyConstraintDc")
@LoadDataBeforeShow
public class FuelFamilyConstraintEdit extends StandardEditor<FuelFamilyConstraint> {
}