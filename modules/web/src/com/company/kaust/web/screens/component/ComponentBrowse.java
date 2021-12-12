package com.company.kaust.web.screens.component;

import com.company.kaust.entity.Component;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.model.DataLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UiController("kaust_Component.browse")
@UiDescriptor("component-browse.xml")
@LookupComponent("componentsTable")
@LoadDataBeforeShow
public class ComponentBrowse extends StandardLookup<Component> {
    @Inject
    private Dialogs dialogs;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private Logger log;
    @Inject
    private Notifications notifications;
    @Inject
    private Messages messages;
    @Inject
    private DataManager dataManager;
    @Inject
    private DataLoader componentsDl;

    public void componentsImport() {
        InputDialog inputDialog = dialogs.createInputDialog(this)
                .withCaption("Select Excel file")
                .withParameters(InputParameter.fileParameter("inputFile"))
                .show();

        inputDialog.addAfterCloseListener(afterCloseEvent -> {
            FileUploadField field = (FileUploadField) inputDialog.getWindow().getComponentNN("inputFile");
            if (field.getFileId() == null) {
                return;
            }
            final File file = fileUploadingAPI.getFile(field.getFileId());
            try {
                performImport(file);
            } catch (IOException e) {
                log.error("ERROR ", e);

                notifications.create(Notifications.NotificationType.HUMANIZED)
                        .withCaption(String.format(messages.getMessage(this.getClass(), "ErrorFileImport"), e.getMessage()))
                        .show();
            }
        });
    }


    private void performImport(File file) throws IOException {
        if (!file.exists()) {
            log.debug("file {} not found.", file.getAbsolutePath());
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withCaption(messages.getMessage(this.getClass(), "WarningFileNotFound"))
                    .show();
            return;
        }
/*

        if (!validateFile(file)) {
            log.debug("file {} is not valid.", file.getAbsolutePath());
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withCaption(messages.getMessage(this.getClass(), "WarningFileNotValid"))
                    .show();
            return;
        }
*/

        FileInputStream fileStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileStream);

        XSSFSheet sheet = workbook.getSheetAt(0);

        CommitContext context = new CommitContext();

        List<Component> components = new ArrayList<>();
        int firstRow = sheet.getFirstRowNum();
        int lastRow = sheet.getLastRowNum();

        // Fist row in Excel table contains headings
        for (int i = firstRow + 1; i <= lastRow; i++) {
            Row ro = sheet.getRow(i);

            if (ro == null) {
                continue;
            }

            Component component = dataManager.create(Component.class);

            if (ro.getCell(1) != null) component.setName(getCellValue(ro.getCell(1)));
            if (ro.getCell(2) != null) component.setSmiles(getCellValue(ro.getCell(2)));
            if (ro.getCell(3) != null) component.setInchi(getCellValue(ro.getCell(3)));
            if (ro.getCell(4) != null) component.setFormula(getCellValue(ro.getCell(4)));
            if (ro.getCell(5) != null) component.setCbs_value(Double.valueOf(getCellValue(ro.getCell(5))));
            if (ro.getCell(6) != null) component.setG3_value(Double.valueOf(getCellValue(ro.getCell(6))));
            if (ro.getCell(7) != null) component.setG4_value(Double.valueOf(getCellValue(ro.getCell(7))));
            if (ro.getCell(8) != null) component.setG4x_value(Double.valueOf(getCellValue(ro.getCell(8))));

            components.add(component);
            context.addInstanceToCommit(component);
        }

        dataManager.commit(context);

        fileStream.close();

        getScreenData().loadAll();
    }


    private String getCellValue(Cell cell) {
        String value = null;
        CellType cellType = cell.getCellType();
        if (cellType.equals(CellType.NUMERIC)) {
            value = String.valueOf(Double.valueOf(String.valueOf(cell.getNumericCellValue()).trim()).longValue());
        } else if (cellType.equals(CellType.STRING)) {
            value = cell.getStringCellValue().trim();
        }
        return value;
    }

    public void removeAllComponents() {
        LoadContext<Component> loadContext = LoadContext.create(Component.class);
        List<Component> components =  dataManager.loadList(loadContext);

        if (components.isEmpty()) return;

        CommitContext commitContext = new CommitContext();
        for (Component c: components) {
            commitContext.addInstanceToRemove(c);
        }
        dataManager.commit(commitContext);
        componentsDl.load();
    }
}