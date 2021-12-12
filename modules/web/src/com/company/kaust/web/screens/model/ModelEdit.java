package com.company.kaust.web.screens.model;

import com.company.kaust.entity.Model;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UiController("kaust_Model.edit")
@UiDescriptor("model-edit.xml")
@EditedEntityContainer("modelDc")
@LoadDataBeforeShow
public class ModelEdit extends StandardEditor<Model> {

    @Inject
    private Metadata metadata;
    @Inject
    private FileLoader fileLoader;
    @Inject
    private DataManager dataManager;
    @Inject
    private TextArea<String> textAreaIn;
    @Inject
    private TextArea<String> textAreaOut;

    private FileDescriptor fileDescriptor;
    @Inject
    private Dialogs dialogs;
    @Inject
    private Logger log;
    @Inject
    private Notifications notifications;
    @Inject
    private Messages messages;
    @Inject
    private FileUploadingAPI fileUploadingAPI;

/*
    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        Model model = getEditedEntity();
        if(getEditedEntity().getFileDescriptor() != null)
            fileDescriptor = getEditedEntity().getFileDescriptor();
    }
*/


    public void onButtonInClick() {
        byte[] bytes = textAreaIn.getRawValue().getBytes();

        fileDescriptor = metadata.create(FileDescriptor.class);
        fileDescriptor.setName("Input.txt");
        fileDescriptor.setExtension("txt");
        fileDescriptor.setSize((long) bytes.length);
        fileDescriptor.setCreateDate(new Date());

        try {
            fileLoader.saveStream(fileDescriptor, () -> new ByteArrayInputStream(bytes));
        } catch (FileStorageException e) {
            throw new RuntimeException(e);
        }

        dataManager.commit(fileDescriptor);
        getEditedEntity().setFileDescriptor(fileDescriptor);
    }

    public void onButtonOutClick() {
        if(getEditedEntity().getFileDescriptor() != null) {
            fileDescriptor = getEditedEntity().getFileDescriptor();
            try {
                InputStream inputStream = fileLoader.openStream(fileDescriptor);
                textAreaOut.setValue(IOUtils.toString(inputStream, StandardCharsets.UTF_8));
            } catch (FileStorageException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void driversImport() {

        InputDialog inputDialog = dialogs.createInputDialog(this)
                .withCaption("Select file")
                .withParameters(InputParameter.fileParameter("inputFile"))
                .show();

        inputDialog.addAfterCloseListener(afterCloseEvent -> {
            FileUploadField field = (FileUploadField) inputDialog.getWindow().getComponentNN("inputFile");
            if (field.getFileId() == null) {
                return;
            }
            final File file = fileUploadingAPI.getFile(field.getFileId());
/*
            try {
                performImport(file);
            } catch (IOException e) {
                log.error("ERROR ", e);

                notifications.create(Notifications.NotificationType.HUMANIZED)
                        .withCaption(String.format(messages.getMessage(this.getClass(), "ErrorFileImport"), e.getMessage()))
                        .show();
            }
*/

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

        List<String> drivers = new ArrayList<>();

        for(int i=sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++){
            Row ro=sheet.getRow(i);

            if (ro == null) {
                continue;
            }

            if (ro.getCell(0) == null) {
                log.debug("company is empty in excel file");
                continue;
            }

            final String companyName = getCellValue(ro.getCell(0));

            final String mobilePhone = getCellValue(ro.getCell(4));
            if (mobilePhone == null) {
                log.debug("phone number is empty in excel file");
                continue;
            }

//            Driver driver = dataManager.create(Driver.class);

//            driver.setCompany(company);
//
//            if (ro.getCell(1) != null) driver.setLastName(getCellValue(ro.getCell(1)));
//            if (ro.getCell(2) != null) driver.setFirstName(getCellValue(ro.getCell(2)));
//            if (ro.getCell(3) != null) driver.setMiddleName(getCellValue(ro.getCell(3)));
//            drivers.add(driver);
//            context.addInstanceToCommit(driver);
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


}