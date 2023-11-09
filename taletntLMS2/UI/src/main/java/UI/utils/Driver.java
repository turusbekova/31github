package UI.utils;

import UI.dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Driver {

    private Driver() {
        //Singleton pattern
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                case "saucelab":
                    try {
                        driver = SauceLabsDriver.loadSauceLabs(ConfigReader.getProperty("platformName"), ConfigReader.getProperty("browserName"), ConfigReader.getProperty("browserVersion"));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                default:
                    driver = ChromeWebDriver.loadChromeDriver();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

