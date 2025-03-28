package com.Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class DPExcel {
    @DataProvider(name = "excelData", parallel = true)
    public Object[][] excelDataProvider() throws IOException {
        return getExcelData("C:\\Users\\yuvar\\TESTNG_Assessment\\TESTNG_Assessment\\testdata.xlsx", "Sheet1");
    }

    public Object[][] getExcelData(String fileName, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int noOfRows = sheet.getPhysicalNumberOfRows() - 1; 
        int noOfCols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[noOfRows][noOfCols];

        for (int i = 0; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i + 1); 
            for (int j = 0; j < noOfCols; j++) {
                XSSFCell cell = row.getCell(j);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i][j] = String.valueOf(cell.getNumericCellValue());
                            break;
                        default:
                            data[i][j] = "";
                    }
                } else {
                    data[i][j] = "";
                }
            }
        }
        return data;
    }
}
