package utility;


import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {
        String excelPath = "C:\\Users\\Akshay\\git\\Amazon\\Amazon_1\\src\\test\\resources\\TestData\\TestData.xlsx";

        try (FileInputStream inputStream = new FileInputStream(excelPath)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming we are reading from the first sheet

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

