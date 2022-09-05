package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _06_ApachePOISteps {
    DialogContent dc = new DialogContent();

    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        // excelden oku ve citizenship i create et
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen",2);

        for (ArrayList<String> satir : tablo )
        {
            dc.findAndClick("addButton");
            dc.findAndSend("nameInput",satir.get(0));
            dc.findAndSend("shortName",satir.get(1));
            dc.findAndClick("saveButton");
        }
    }

    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        // kaydettiklerini yine excelden okuyarak sil
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen",1);

        for (ArrayList<String> satir : tablo){
            dc.SearchAndDelete(satir.get(0));
            dc.findAndContainsText("successMessage","success");
        }

    }
}
