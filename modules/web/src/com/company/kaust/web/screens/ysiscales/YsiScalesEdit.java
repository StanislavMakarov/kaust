package com.company.kaust.web.screens.ysiscales;

import com.haulmont.cuba.gui.screen.*;
import com.company.kaust.entity.YsiScale;

@UiController("kaust_YsiScales.edit")
@UiDescriptor("ysi-scales-edit.xml")
@EditedEntityContainer("ysiScalesDc")
@LoadDataBeforeShow
public class YsiScalesEdit extends StandardEditor<YsiScale> {
}