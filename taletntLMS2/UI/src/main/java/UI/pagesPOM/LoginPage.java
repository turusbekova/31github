package UI.pagesPOM;

import UI.dataProviders.ConfigReader;
import UI.studentsMethods.aidar.Methods;
import UI.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    Methods methods = new Methods();

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='login']")
    WebElement userNameInputElement;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInputElement;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButtonElement;

    public void loginToSystem() {
        Driver.getDriver().get(ConfigReader.getProperty("environment"));
        methods.sendKeys(userNameInputElement, ConfigReader.getProperty("usernameLMS"));
        methods.sendKeys(passwordInputElement, ConfigReader.getProperty("passwordLMS"));
        methods.click(submitButtonElement);
    }
}
