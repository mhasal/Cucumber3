package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormContent extends Parent {
    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

   // WebElement ddMenu = GWD.driver.findElement(By.xpath("(//input[@formcontrolname='employeeId'])"));
   // Select menu = new Select(ddMenu);

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;
    @FindBy (xpath = "(//ms-text-field[@formcontrolname='firstName']/input)")
    private WebElement firstName;

    @FindBy (xpath = "(//ms-text-field[@formcontrolname='lastName']/input)")
    private WebElement lastName;

    @FindBy (xpath = "(//input[@formcontrolname='employeeId'])")
    private WebElement empID;


    WebElement myElement;

    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "academicPeriod" : myElement = academicPeriod; break;
            case "academicPeriod1" : myElement = academicPeriod1; break;
            case "gradeLevel" : myElement = gradeLevel; break;
            case "gradeLevel2" : myElement = gradeLevel2; break;
            case "addButton" : myElement = addButton; break;
            case "empID" : myElement = empID; break;
        }
        clickFunction(myElement);
    }

    public void findAndSend(String strElement, String value) {
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "firstName": myElement = firstName; break;
            case "lastName" : myElement = lastName; break;


        }
        sendKeysFunction(myElement, value);
    }
    }