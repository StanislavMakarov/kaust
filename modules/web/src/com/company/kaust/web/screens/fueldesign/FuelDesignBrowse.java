package com.company.kaust.web.screens.fueldesign;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.FuelDesign;

@UiController("kaust_FuelDesign.browse")
@UiDescriptor("fuel-design-browse.xml")
@LookupComponent("fuelDesignsTable")
@LoadDataBeforeShow
public class FuelDesignBrowse extends StandardLookup<FuelDesign> {
}