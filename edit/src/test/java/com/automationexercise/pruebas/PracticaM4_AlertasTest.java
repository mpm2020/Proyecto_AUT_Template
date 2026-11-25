package com.automationexercise.pruebas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticaM4_AlertasTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite 
    public void setUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://demoqa.com/alerts");

    }
   
    @Test 
    public void alertaConTexto(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
        WebElement cuartoBoton=driver.findElement(By.id("promtButton"));
        cuartoBoton.click();
        driver.switchTo().alert().sendKeys("EduIT");
        driver.switchTo().alert().accept();
        assert driver.findElement(By.id("promptResult")).getText().equals("You entered EduIT");

    }


    @AfterSuite 
    public void tearDown(){
        driver.quit();

    }
    
}
