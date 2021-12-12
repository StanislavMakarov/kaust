package com.company.kaust.web.screens.compositionelement;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.CompositionElement;

@UiController("kaust_CompositionElement.browse")
@UiDescriptor("composition-element-browse.xml")
@LookupComponent("compositionElementsTable")
@LoadDataBeforeShow
public class CompositionElementBrowse extends StandardLookup<CompositionElement> {
}