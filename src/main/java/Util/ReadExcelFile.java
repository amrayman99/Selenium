package Util;

import base.BaseTest;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile extends BaseTest {

    public ReadExcelFile() throws IOException {
    }

    public static Object[][] getDataFromExcel(String sheetName) throws Exception {

        File file = new File("src/main/resources/DataDriven.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        Object data[][] = new Object[rows][columns];

        for(int i=0 ; i<rows ; i++) {
            for (int k = 0 ; k<columns ; k++) {
                data[i][k] = sheet.getRow(i).getCell(k).toString();
            }
        }
        return data;
    }
}
