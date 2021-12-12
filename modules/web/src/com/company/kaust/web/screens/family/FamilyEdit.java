package com.company.kaust.web.screens.family;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.Family;

@UiController("kaust_Family.edit")
@UiDescriptor("family-edit.xml")
@EditedEntityContainer("familyDc")
@LoadDataBeforeShow
public class FamilyEdit extends StandardEditor<Family> {
}