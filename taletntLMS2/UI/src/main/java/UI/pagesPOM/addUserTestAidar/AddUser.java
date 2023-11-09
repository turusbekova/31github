package UI.pagesPOM.addUserTestAidar;

import UI.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AddUser extends BasePage {
    public AddUser() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "xpath")
    WebElement element;
    @FindBy(xpath = "(//div[@class='controls'])[9]/select")
    WebElement selectElement;
    @FindBy(xpath = "(//div[@class='controls'])[9]/select/option")
    WebElement optionElements;
    @FindBy(xpath = "(//a[@href=\"https://aidar.talentlms.com/user/create\"])[2]")
    WebElement addUserElement;

    static By optionLanguages = By.xpath("(//div[@class='controls'])[9]/select/option");

    static By timeZonesLocator = By.xpath("//select[@name='timezone']/option");

    public void adminClickOnUserButton() {
        methods.click(element);
    }



    public List<String> getAllTimeZone() {
        loginPage.loginToSystem();
        addUserElement.click();
        List<String> timeZones = new ArrayList<>();
        List<WebElement> timeZonesList = Driver.getDriver().findElements(timeZonesLocator);
        for (WebElement timeZone : timeZonesList) {
            System.out.println(timeZone.getText());
            timeZones.add(timeZone.getText());
        }
        return timeZones;
    }


    public List<String> getAllLanguages() {
        loginPage.loginToSystem();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addUserElement.click();
        List<String> languageString = new ArrayList<>();
        List<WebElement> languages = Driver.getDriver().findElements(optionLanguages);
        for (WebElement language : languages) {
            languageString.add(language.getText());
        }
        return languageString;
    }
}
