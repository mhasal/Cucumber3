package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelUtility {
    // Kendisine verilen path deki excelin, istenilen, sheetindeki
    // verilen kolon kadar bilgisini okuyup, ArrayList formatında geri döndüren fonksiyonu yazınız.
    // getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2); 0-2

    public static ArrayList<ArrayList<String>>getListData(String path, String sheetName, int columnCount){
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        Workbook workbook=null;
        try {

            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sayfa = workbook.getSheet(sheetName);

        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++) {

            ArrayList<String> satirData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                satirData.add(sayfa.getRow(i).getCell(j).toString());
            }

            tablo.add(satirData);
        }


        return tablo;
    }

    // TODO: kendisine verilen path, scenario, browserTipi, zaman parametreleri ile
    // TODO: yeni bir excele bütün raporu yazacak. Dosyanın varlığını yokluğunu kontrol etmeyi googledan bulunuz.

    public static void writeExcel(String path, Scenario scenario, String browserName, String time) {

        File f = new File(path);

        if (!f.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");
            Row newRow = sheet.createRow(0); // satır oluşturuldu 0. yerde

            Cell newCell = newRow.createCell(0); // yeni satırda ilk hücre oluşturuldu
            newCell.setCellValue(scenario.getId()); // bilgi yazıldı

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(3);
            newCell.setCellValue(scenario.getStatus().toString());

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close(); // hafıza boşaltıldı
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else
        {
            FileInputStream inputStream = null;
            Workbook workbook = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            Row newRow = sheet.createRow(rowCount);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);


            try {
                FileOutputStream outputStream = null;
                inputStream.close();
                outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }


    public static void main(String[] args) {
       ArrayList<ArrayList<String>> tablo =
        getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 3);

        System.out.println("tablo = " + tablo);
            
        }
    }

