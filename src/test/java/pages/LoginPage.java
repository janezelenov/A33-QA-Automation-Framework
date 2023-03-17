package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BasePage {


    WebDriver driver;
    WebDriverWait wait;

    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");


    //@FindBy(css = "[type='submit']")
    //static
    //WebElement submitButton;

    //@FindBy(css="[type='email']")
    //static
    //WebElement emailField;

    //@FindBy(css="[type='password']")
    //static
    //WebElement passwordField;

    public LoginPage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }

    public void clickSubmitBtn() {
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        driver.findElement(submitButtonLocator).click();

    }


    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);

    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);

    }

    @Test

    public void LoginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("janezelenova@gmail.com");
        loginPage.providePassword("Floridaliving2023$");
        loginPage.clickSubmitBtn();

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon.isDisplayed());


    }
}




