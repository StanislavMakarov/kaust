package com.company.kaust.web.screens.component;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.Component;

@UiController("kaust_Component.edit")
@UiDescriptor("component-edit.xml")
@EditedEntityContainer("componentDc")
@LoadDataBeforeShow
public class ComponentEdit extends StandardEditor<Component> {
}