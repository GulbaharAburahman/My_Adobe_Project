package com.unitedcoder.commonuse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class UtilityClass {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;

    String filePath;



    public static String readFromConfig(String fileName, String key){
        Properties properties=new Properties();
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }




    public int getRowCount(int sheetIndex) throws IOException {
        fi=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheetAt(sheetIndex);
        int rowCount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(int sheetIndex,int rowNumber) throws IOException {
        fi=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheetAt(sheetIndex);
        row=sheet.getRow(rowNumber);
        int cellCount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    public String getCellData( String filePath,int sheetIndex, int rowNumber,int cellNumber) throws IOException {
        fi=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheetAt(sheetIndex);
        row=sheet.getRow(rowNumber);
        cell= row.getCell(cellNumber);

        DataFormatter formatter=new DataFormatter();
        String data;
        try {
            data= formatter.formatCellValue(cell);
        }catch (Exception e){
            data="";
        }
        workbook.close();
        fi.close();
        return data;
    }
    public void writeToExcelFileMultipleCells(String fileName, String sheetName, List<String> contents, String cellValueTobeSetStyle) throws IOException, InvalidFormatException {
        //define a file to write
        File excelFile = new File(fileName);
        //define a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //add worksheet to the workbook
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //define rows in the worksheet
        int totalRows = contents.size();

        for (int rowNumber = 0; rowNumber < totalRows; rowNumber++) {
            XSSFRow row = sheet.createRow(rowNumber);  //add row to the sheet
            String[] rowContent = contents.get(rowNumber).split(","); //separating content with ","
            int totalCells = rowContent.length;
            for (int cellNumber = 0; cellNumber < totalCells; cellNumber++) {
                XSSFCell cell = row.createCell(cellNumber); //add cell to the row
                //add value to the cell
                cell.setCellValue(rowContent[cellNumber]);
                if (rowContent[cellNumber].equalsIgnoreCase(cellValueTobeSetStyle)) {
                    XSSFCellStyle style = workbook.createCellStyle();
                    style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());  // set cell field colour
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cell.setCellStyle(style);
                }
            }
        }
        FileOutputStream outputStream = new FileOutputStream(excelFile);
        workbook.write(outputStream);
        outputStream.close();
    }


    public void writeToExcel(String fileName, String sheetName, List<String> content) {
        File file = new File(fileName);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        int rowSize = content.size();
        for (int rowNumber = 0; rowNumber < rowSize; rowNumber++) {
            XSSFRow row = sheet.createRow(rowNumber);
            String[] rowContent = content.get(rowNumber).split(",");
            int totalCell = rowContent.length;
            for (int cellNumber = 0; cellNumber < totalCell; cellNumber++) {
                XSSFCell cell = row.createCell(cellNumber);
                cell.setCellValue(rowContent[cellNumber]);
            }
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToExistingExcel(String filePath, int sheetIndex, int rowNum , int columnNum1,int columnNum2, int columnNum3,int columnNum4,String value1,String value2 , String value3,String value4){

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //define a workbook
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //add worksheet to the workbook
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        //define rows in the worksheet
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell1 =row.createCell(columnNum1);
        cell1.setCellValue(value1);
        XSSFCell cell2=row.createCell(columnNum2);
        cell2.setCellValue(value2);
        XSSFCell cell3=row.createCell(columnNum3);
        cell3.setCellValue(value3);
        XSSFCell cell4=row.createCell(columnNum4);
        cell4.setCellValue(value4);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public String readDataFromExcelColumn(String fileNme,int sheetIndex,int rowNumber,int columnNumber){
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = new FileInputStream(fileNme);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook= null;

        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet= workbook.getSheetAt(sheetIndex);
        XSSFRow row=sheet.getRow(rowNumber);
        String cellValue=null;
        if(row==null){
            System.out.println("Empty Row!!!!");
        }
        else {
            XSSFCell cell=row.getCell(columnNumber);
            CellType cellType=cell.getCellType();
            switch (cellType){
                case STRING :
                    cellValue=cell.getStringCellValue();
                    break;

                case NUMERIC:
                    cellValue=String.valueOf(cell.getNumericCellValue());
                    break;

            }

        }
        return cellValue;
    }










}
