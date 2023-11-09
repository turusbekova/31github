package UI.utils;


import UI.dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDriver {
    public static WebDriver loadSauceLabs(String platformName, String browserType, String browserVersion)throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName );
        capabilities.setCapability("browserName", browserType);
        capabilities.setCapability("browserVersion", browserVersion);

       WebDriver driver = null;
       try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("sauceLabsUrl")), capabilities);
        }catch (MalformedURLException e) {
           e.printStackTrace();
       }
       return driver;
    }
}
