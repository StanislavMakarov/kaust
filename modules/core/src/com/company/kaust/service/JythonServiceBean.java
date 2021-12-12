package com.company.kaust.service;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

import static org.jgroups.util.Util.assertEquals;

@Service(JythonService.NAME)
public class JythonServiceBean implements JythonService {
/*
    public void givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("python", resolvePythonScriptPath("hello.py"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        List<String> results = readProcessOutput(process.getInputStream());

        assertThat("Results should not be empty", results, is(not(empty())));
        assertThat("Results should contain output of script: ", results, hasItem(
                containsString("Hello Baeldung Readers!!")));

        int exitCode = process.waitFor();
        assertEquals("No errors should be detected", 0, exitCode);
    }

*/
    public void givenPythonInterpreter_whenPrintExecuted_thenOutputDisplayed() {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            StringWriter output = new StringWriter();
            pyInterp.setOut(output);

            pyInterp.exec("print('Hello Baeldung Readers!!')");
            assertEquals("Should contain script output: ", "Hello Baeldung Readers!!", output.toString()
                    .trim());
        }
    }
}