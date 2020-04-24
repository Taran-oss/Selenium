package RozetkaUP;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RozetkaCompare extends BaseTestClass{
    protected String url = "https://rozetka.com.ua/";

    @Test
    public void positiveBMonitor() {

        driver.get(url);

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
