package com.company.kaust.web.screens.fuelfamilyconstraint;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.FuelFamilyConstraint;

@UiController("kaust_FuelFamilyConstraint.browse")
@UiDescriptor("fuel-family-constraint-browse.xml")
@LookupComponent("fuelFamilyConstraintsTable")
@LoadDataBeforeShow
public class FuelFamilyConstraintBrowse extends StandardLookup<FuelFamilyConstraint> {
}