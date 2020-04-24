package RozetkaUP;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }


    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
