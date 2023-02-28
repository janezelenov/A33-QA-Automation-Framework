import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        String urlHome = "https://bbb.testpro.io/#!/home";
        driver.get(url);


        WebElement loginField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[placeholder='Password']"));
        WebElement submitLogin = driver.findElement(By.cssSelector("[type='submit']"));



        loginField.sendKeys("janezelenova@gmail.com");
        passwordField.click();
        passwordField.sendKeys("Floridaliving2023$");
        submitLogin.click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), urlHome);
        Assert.assertNotEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
