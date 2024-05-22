package web.service;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\\\\\\\\\chromedriver-win64\\\\\\\\\\\\\\\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEmptyFields() {
        driver.navigate().to("D:\\\\\\\\\\\\\\\\Java Projects\\\\\\\\\\\\\\\\pages\\\\\\\\\\\\\\\\login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        assertFalse(title.equalsIgnoreCase("success"));
    }

    @Test
    public void testInvalidCredentials() {
        driver.navigate().to("D:\\\\\\\\\\\\\\\\Java Projects\\\\\\\\\\\\\\\\pages\\\\\\\\\\\\\\\\login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("random_user");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("random_pass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("1990-01-01");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        assertFalse(title.equalsIgnoreCase("success"));
    }
}
