package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GWDBasic {

        public static WebDriver driver;

        // Bana neler lazım: 1 browser tipi lazım burada ona göre oluşturacağım
        // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
        // çünkü runner classdaki işaret edilen tüm senaryolarda aynısının çalışması lazım
        // demek ki hem her pipeline için (Local) ve de ona özel static bir driver a ihtiyaç var
        private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1, WebDriver 2
        private static ThreadLocal<String> threadBrowser = new ThreadLocal<>(); // chrome, firefox vs.

        public static WebDriver getDriver(){

            if (driver == null) {
                Locale.setDefault(new Locale("EN"));
                System.setProperty("user.language","EN");
                Logger.getLogger("").setLevel(Level.SEVERE);
                System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                // firefox
                //  WebDriverManager.firefoxdriver().setup();
                //  driver = new FirefoxDriver();

            }

            return driver;
        }

        public static void quitDriver(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (driver != null){
                driver.quit();
                driver = null;
            }
        }
        public static void Bekle(int saniye)
        {
            try {
                Thread.sleep(saniye*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

