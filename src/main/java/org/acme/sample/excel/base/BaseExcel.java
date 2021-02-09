package org.acme.sample.excel.base;

import org.acme.sample.exception.base.InternalServerErrorException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;

public class BaseExcel {

    protected CellStyle defaultCaptionCellStyle;
    protected CellStyle defaultContentCellStyle;

    Workbook workbook;

    public BaseExcel() {
        workbook = new XSSFWorkbook();

        Font times10Bold = workbook.createFont();
        times10Bold.setFontName("Times");
        times10Bold.setFontHeightInPoints((short) 10);
        times10Bold.setBold(true);
        Font times10NoBold = workbook.createFont();
        times10NoBold.setFontName("Times");
        times10NoBold.setFontHeightInPoints((short) 10);
        times10NoBold.setBold(false);

        defaultCaptionCellStyle = createCellStyle(times10Bold);
        defaultContentCellStyle = createCellStyle(times10NoBold);
    }

    public void write(OutputStream outputStream) {
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new InternalServerErrorException(e);
        }
    }

    public void addCaption(Row row, int column, String s) {
        Cell cell = row.createCell(column, CellType.STRING);
        cell.setCellValue(s);
        cell.setCellStyle(defaultCaptionCellStyle);
    }

    public void addStringCell(Row row, int column, String s) {
        Cell cell = row.createCell(column, CellType.STRING);
        cell.setCellValue(s);
        cell.setCellStyle(defaultContentCellStyle);
    }

    public void addLongCell(Row row, int column, long s) {
        Cell cell = row.createCell(column, CellType.NUMERIC);
        cell.setCellValue(s);
        cell.setCellStyle(defaultContentCellStyle);
    }

    public void addIntCell(Row row, int column, int s) {
        Cell cell = row.createCell(column, CellType.NUMERIC);
        cell.setCellValue(s);
        cell.setCellStyle(defaultContentCellStyle);
    }

    public void addDoubleCell(Row row, int column, double s) {
        Cell cell = row.createCell(column, CellType.NUMERIC);
        cell.setCellValue(s);
        cell.setCellStyle(defaultContentCellStyle);
    }

    private CellStyle createCellStyle(Font font) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFont(font);
        cellStyle.setWrapText(false);
        return cellStyle;
    }
}
