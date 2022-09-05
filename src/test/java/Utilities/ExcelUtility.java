package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
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


    public static void main(String[] args) {
       ArrayList<ArrayList<String>> tablo =
        getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 3);

        System.out.println("tablo = " + tablo);
            
        }
    }

