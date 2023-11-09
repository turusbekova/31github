package UI.studentsMethods.aidar;

import UI.utils.Driver;
import org.assertj.core.condition.Negative;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {

    public Methods waitElementToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
    public Methods waitElementToBeVisible(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    public Methods waitElementToBeClickableAndVisible(WebElement element) {
        waitElementToBeClickable(element).waitElementToBeVisible(element);
        return this;
    }
    public Methods click(WebElement element) {
        waitElementToBeClickableAndVisible(element);
        element.click();
        return this;
    }

    public Methods sendKeys(WebElement element, String str) {
        element.sendKeys(str);
        return this;
    }
}
