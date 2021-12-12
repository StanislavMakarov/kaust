package com.company.kaust.web.screens.component;

import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import static javatests.TestSupport.assertEquals;

@UiController("kaust_PythonScreen")
@UiDescriptor("python-screen.xml")
public class PythonScreen extends Screen {
    public void execPython() {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.exec("x = 10+10");
            PyObject x = pyInterp.get("x");
            assertEquals("x: ", 20, String.valueOf(x.asInt()));
        }
    }
}

