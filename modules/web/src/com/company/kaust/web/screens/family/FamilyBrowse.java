package com.company.kaust.web.screens.family;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.Family;

@UiController("kaust_Family.browse")
@UiDescriptor("family-browse.xml")
@LookupComponent("familiesTable")
@LoadDataBeforeShow
public class FamilyBrowse extends StandardLookup<Family> {
}