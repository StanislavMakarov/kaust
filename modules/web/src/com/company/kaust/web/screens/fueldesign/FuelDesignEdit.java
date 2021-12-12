package com.company.kaust.web.screens.fueldesign;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.FuelDesign;

@UiController("kaust_FuelDesign.edit")
@UiDescriptor("fuel-design-edit.xml")
@EditedEntityContainer("fuelDesignDc")
@LoadDataBeforeShow
public class FuelDesignEdit extends StandardEditor<FuelDesign> {
}