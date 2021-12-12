package com.company.kaust.web.screens.thermosearch;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.ThermoSearch;

@UiController("kaust_ThermoSearch.edit")
@UiDescriptor("thermo-search-edit.xml")
@EditedEntityContainer("thermoSearchDc")
@LoadDataBeforeShow
public class ThermoSearchEdit extends StandardEditor<ThermoSearch> {
}