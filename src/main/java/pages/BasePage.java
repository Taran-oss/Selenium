package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$x;


public class BasePage {
    private final WebDriver webDriver = WebDriverRunner.getWebDriver();
    SelenideElement closePopUp = $x("//div[@class='el-dialog__header']/button[@class='el-dialog__headerbtn']");

    public BasePage waitForPageToLoad() {
        new WebDriverWait(webDriver, 10000).until(
                webDriver1 -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public HomePage closePopUp() {
        if (closePopUp.isDisplayed()) {
            closePopUp.click();
        }
        return null;
    }
}