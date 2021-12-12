package com.company.kaust.web.screens.compositionelement;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.CompositionElement;

@UiController("kaust_CompositionElement.edit")
@UiDescriptor("composition-element-edit.xml")
@EditedEntityContainer("compositionElementDc")
@LoadDataBeforeShow
public class CompositionElementEdit extends StandardEditor<CompositionElement> {
}