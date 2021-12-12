package com.company.kaust.web.screens.model;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.Model;

@UiController("kaust_Model.browse")
@UiDescriptor("model-browse.xml")
@LookupComponent("modelsTable")
@LoadDataBeforeShow
public class ModelBrowse extends StandardLookup<Model> {
}