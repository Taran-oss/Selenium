package guru99PrintAllCookies;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class LoginPrintAllCookies {

    String homeUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String login = "1303";
    String psw = "Guru99";

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(homeUrl);

    }

    @AfterSuite
    public void quiteBrowser() {
        driver.quit();
    }

    @Test
    public void positiveLoginTest() {

        driver.get(homeUrl);
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(psw);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        File file = new File("browser.data");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fos = new FileWriter(file);
            BufferedWriter bos = new BufferedWriter(fos);

            for (Cookie ck : driver.manage().getCookies()) {
                bos.write((ck.getName() + ";"
                        + ck.getValue() + ";"
                        + ck.getDomain() + ";"
                        + ck.getPath() + ";"
                        + ck.getExpiry() + ";"
                        + ck.isSecure()));
                System.out.println(ck);
                bos.newLine();
            }
            bos.flush();
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
