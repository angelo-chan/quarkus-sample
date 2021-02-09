package org.acme.sample.excel.base;

import org.apache.poi.ss.usermodel.Sheet;

import java.io.OutputStream;

public abstract class SingleSheetExcel extends BaseExcel {

    protected Sheet sheet;

    public SingleSheetExcel(String sheetName) {
        super();
        sheet = workbook.createSheet(sheetName);
    }

    public abstract void createCaption();

    public abstract void createContent();

    public void write(OutputStream outputStream) {
        createCaption();
        createContent();
        super.write(outputStream);
    }
}
