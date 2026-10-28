package com.khangsinh2853e.e2e;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class HerokuForgotPasswordTest {
    public static WebDriver myBrowser;

    @BeforeAll
    static void beforeAll() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=true");

        myBrowser = new ChromeDriver(chromeOptions);
        myBrowser.manage().window().maximize();

    }

    @AfterAll
    static void afterAll() throws InterruptedException {
        Thread.sleep(5000);
        myBrowser.quit();
    }

    @Test
    public void testHerokuForgotPassword(){
        myBrowser.get("https://the-internet.herokuapp.com/forgot_password");
        WebDriverWait wait = new WebDriverWait(myBrowser, Duration.ofSeconds(10));
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));

        email.sendKeys("EmailUseToTest@gmail.com");

        WebElement retrievePasswordButton = myBrowser.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement flashMessageTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        String flashMessage = flashMessageTag.getText();

        assertEquals("Your e-mail's been sent!", flashMessage);
        System.out.println("Success!");
    }

}