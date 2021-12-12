package com.company.kaust.web.screens.actions;

import com.haulmont.cuba.gui.components.ActionType;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.components.actions.EditAction;

@ActionType("predict")
public class PredictAction  extends EditAction {
    public PredictAction(ListComponent target) {
        super(target);
    }

}
