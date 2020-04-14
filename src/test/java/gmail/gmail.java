package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.testng.AssertJUnit.assertEquals;


public class gmail {

    String homeUrl = "https://www.google.com/intl/ru/gmail/about/for-work/";
    String login = "test50699@gmail.com";
    String psw = "asdfghjkl1111";


    WebDriver driver;
    WebDriverWait wait;


    @BeforeSuite
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(homeUrl);
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void quiteBrowser() {
        driver.quit();
    }

    @Test
    public void positiveLoginTest() throws AWTException, InterruptedException {

        driver.get(homeUrl);
        driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(login);
        driver.findElement(By.xpath("//*[@id='identifierNext']/span/span")).click();
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordElement.click();
        passwordElement.sendKeys(psw);
        driver.findElement(By.xpath("//*[@id='passwordNext']/span/span")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\":5i\"]/div")));

        driver.findElement(By.xpath("//*[@id=\":59\"]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\":ak\"]")).sendKeys("Word List");
        driver.findElement(By.xpath("//*[@id=\":bp\"]")).sendKeys("Home Work");

        driver.findElement(By.cssSelector("#\\:av")).click();
        driver.findElement(By.cssSelector("#\\:b2")).sendKeys(login);

        driver.findElement(By.cssSelector("#\\:c2")).click();
        Robot robot = new Robot();
        robot.setAutoDelay(1000);
        StringSelection ss = new StringSelection("C:\\Users\\USER\\Desktop\\Microsoft Word Document");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\":9y\"]")).click();
        driver.findElement(By.xpath("//*[@id=\":2q\"]")).click();

        assertEquals(driver.findElement(By.xpath("//h2[@class='hP']")).getText(),"Word List");
        assertEquals(driver.findElement(By.xpath("//div[@class='a3s aXjCH ']/div[@dir='ltr']")).getText(),"Home Work");
        assertEquals(driver.findElement(By.xpath("//div[@class='aYz']/div/div[@class='aQA']/span")).getText(),"Microsoft Word Document");


    }
}