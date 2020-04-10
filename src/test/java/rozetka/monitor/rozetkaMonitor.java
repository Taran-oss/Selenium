package rozetka.monitor;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class rozetkaMonitor {

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
    public void positiveBMonitor() {

        driver.get(homeUrl);

        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > app-rz-main-page > div > aside > main-page-sidebar > sidebar-fat-menu > div > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > app-rz-header > header > div > div.header-bottomline > div.menu-outer.js-rz-fat-menu > fat-menu > div > ul > li:nth-child(1) > div > div.menu__main-cats > div.menu__main-cats-inner > div:nth-child(2) > ul:nth-child(2) > li > ul > li:nth-child(1) > a")).click();

        wait.until(presenceOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/rz-category/div/main/div[1]/h1")));
        driver.findElement(By.xpath("//input[@formcontrolname='min']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='max']")).clear();
        WebElement filter = driver.findElement(By.xpath("//input[@formcontrolname='min']"));
        WebElement filter2 = driver.findElement(By.xpath("//input[@formcontrolname='max']"));
        filter.sendKeys("2500");
        filter2.sendKeys("3000");
        filter2.sendKeys(Keys.ENTER);

        wait.until(presenceOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/rz-category/div/main/div[1]/h1")));
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div.layout.layout_with_sidebar > section > div > ctg-grid > ul > li:nth-child(11) > app-goods-tile-default > div > div.goods-tile__inner > div.goods-tile__actions > app-compare-button > button > svg")).click();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div.layout.layout_with_sidebar > section > div > ctg-grid > ul > li:nth-child(12) > app-goods-tile-default > div > div.goods-tile__inner > div.goods-tile__actions > app-compare-button > button > svg")).click();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > rz-category > div > main > ctg-catalog > div.layout.layout_with_sidebar > section > div > ctg-grid > ul > li:nth-child(7) > app-goods-tile-default > div > div.goods-tile__inner > div.goods-tile__actions > app-compare-button > button > svg")).click();
        WebElement link = driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > app-rz-header > header > div > div.header-bottomline > ul > li.header-actions__item.header-actions__item_type_comparison.js-app-comparison > div > a > i > svg"));
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > app-rz-header > header > div > div.header-bottomline > ul > li.header-actions__item.header-actions__item_type_comparison.js-app-comparison > div > div > ul > li > a")).click();
        driver.findElement(By.cssSelector("#language-switcher > div:nth-child(1) > div > a.popup-close > img")).click();
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"content-inner-block\"]/div[2]/div[1]/div/div/div[1]/div[3]/h1")));

    }
}
