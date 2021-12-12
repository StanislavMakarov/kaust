package com.company.kaust.web.screens.ysiscales;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.YsiScale;

@UiController("kaust_YsiScales.browse")
@UiDescriptor("ysi-scales-browse.xml")
@LookupComponent("ysiScalesesTable")
@LoadDataBeforeShow
public class YsiScalesBrowse extends StandardLookup<YsiScale> {
}