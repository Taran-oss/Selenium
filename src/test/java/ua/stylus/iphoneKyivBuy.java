package ua.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class iphoneKyivBuy {

    public static void main(String[] args) {
        WebDriver driver;
        File file = new File("C:\\Users\\USER\\Desktop\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        WebElement search =driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("iphone kyiv buy");
        search.sendKeys(Keys.ENTER);
        System.out.println();


        WebElement offenses = driver.findElement(By.id("tads"));
        List<WebElement> columns = offenses.findElements(By.className("UdQCqe"));
        boolean isElement=false;
        for (WebElement cell : columns)
            if (cell.getText().equals("stylus.ua › Apple")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(cell).click(cell).perform();
                isElement=true;
                break;
            }

    }

}
