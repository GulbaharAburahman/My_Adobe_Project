package com.unitedcoder.commonuse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UtilityClass {

   public static  String filePath;



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




    public static int getRowCount(int sheetIndex) throws IOException {
      FileInputStream  fi=new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(fi);
       XSSFSheet sheet= workbook.getSheetAt(sheetIndex);
        int rowCount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    public static int getCellCount(int sheetIndex,int rowNumber) throws IOException {
        FileInputStream fi=new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(fi);
        XSSFSheet  sheet= workbook.getSheetAt(sheetIndex);
        XSSFRow row=sheet.getRow(rowNumber);
        int cellCount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData( String filePath,int sheetIndex, int rowNumber,int cellNumber) throws IOException {
       FileInputStream fi=new FileInputStream(filePath);
       XSSFWorkbook  workbook=new XSSFWorkbook(fi);
       XSSFSheet sheet= workbook.getSheetAt(sheetIndex);
       XSSFRow  row=sheet.getRow(rowNumber);
        XSSFCell cell= row.getCell(cellNumber);

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





    // write to an existing file in a column
    public static void  WriteCellData( String filePath,int sheetIndex, int rowNumber,int cellNumber,String value ) throws IOException {
        FileInputStream fi= new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(fi);
        XSSFSheet sheet= workbook.getSheetAt(sheetIndex);
        XSSFRow row = sheet.getRow(rowNumber);
        XSSFCell cell=row.createCell(cellNumber);
        cell.setCellValue(value);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        fi.close();
    }



    //create a new Excel file and write a table
    public static void writeToExcel(String fileName, String sheetName, List<String> content) {
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



    //write list of strings to one row
    public static void writeListToExistingExcel(String filePath, int sheetIndex, int rowNum , ArrayList<String> list) throws IOException {

        FileInputStream inputStream= new FileInputStream(filePath);

        //define a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        //add worksheet to the workbook
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        //define rows in the worksheet
        XSSFRow row = sheet.createRow(rowNum);
        for(int i=0 ; i<list.size(); i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(list.get(i));
        }
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        inputStream.close();
    }













}
