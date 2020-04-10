package rozetka.tablet.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class rozetkaTablet {
    String homeUrl = "https://rozetka.com.ua/";

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get(homeUrl);
        driver.manage().window().maximize();


    }

    @AfterSuite
    public void quiteBrowser() {
        driver.quit();
    }

    @Test
    public void positivAddFilters() {

        driver.get(homeUrl);
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        search.sendKeys("samsung");
        search.sendKeys(Keys.ENTER);

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"head_banner_container\"]/div/div[2]/div[2]/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"80253\"]/li[1]/a")).click();

        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div.layout.layout_with_sidebar > aside > ctg-filter-stack > div:nth-child(2) > div > div > div > div.scrollbar__inner > ctg-filter-section-checkbox > ul:nth-child(1) > li:nth-child(1) > a > label")).click();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div.layout.layout_with_sidebar > aside > ctg-filter-stack > div:nth-child(2) > div > div > div > div.scrollbar__inner > ctg-filter-section-checkbox > ul:nth-child(1) > li:nth-child(3) > a > label")).click();

    }

    @Test
    public void positiveAddPrice() {

        driver.get(homeUrl);
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        search.sendKeys("samsung");
        search.sendKeys(Keys.ENTER);

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"head_banner_container\"]/div/div[2]/div[2]/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"80253\"]/li[1]/a")).click();

        driver.findElement(By.xpath("//input[@formcontrolname='min']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='max']")).clear();
        WebElement filter = driver.findElement(By.xpath("//input[@formcontrolname='min']"));
        WebElement filter2 = driver.findElement(By.xpath("//input[@formcontrolname='max']"));
        filter.sendKeys("5000");
        filter2.sendKeys("15000");
        filter2.sendKeys(Keys.ENTER);

    }

    @Test
    public void positivKindofCheaper() {

        driver.get(homeUrl);
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        search.sendKeys("samsung");
        search.sendKeys(Keys.ENTER);

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"head_banner_container\"]/div/div[2]/div[2]/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"80253\"]/li[1]/a")).click();

        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div:nth-child(1) > div > ctg-sort > select")).click();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div:nth-child(1) > div > ctg-sort > select > option:nth-child(2)")).click();
    }
}
