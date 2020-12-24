package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {
    public ArrayList<String> getData(String testCaseName, String sheetName) throws IOException {
        ArrayList<String> ar = new ArrayList<>();
        FileInputStream file = new FileInputStream("src/main/resources/Book2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int sheets = workbook.getNumberOfSheets();
        for (int i=0; i<sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator(); //row is collection of cell
                int j=0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("testCases")) {
                        column=j;
                    }j++;
                }
                while (rows.hasNext()) {
                    Row row = rows.next();
                    if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)); {
                        Iterator<Cell> cv = row.cellIterator();
                        while (cv.hasNext()) {
                            Cell  c = cv.next();
                            if (c.getCellType()== CellType.STRING) {
                                ar.add(cv.next().getStringCellValue());
                            }
                            else {
                                ar.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }

                        }
                    }
                }


            }

        }
        return ar;
    }
}
