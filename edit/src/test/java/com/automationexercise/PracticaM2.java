package com.automationexercise;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PracticaM2 {
    String urlTest ="https://www.automationexercise.com/";
   
    @Test
    public void lab2_E2() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(urlTest);
        driver.manage().window().maximize();

        //-->Paso 1: Localizar el elemento por el texto del enlace(Signup / Login)

        WebElement lnkSingUpLogin= driver.findElement(By.partialLinkText("Signup / Log"));
        lnkSingUpLogin.click();

        //-->Paso 2: Ingresar Name y Email para registrarse en la página de Automation Exercise

        WebElement txtName= driver.findElement(By.name("name"));
        txtName.sendKeys("John Doe");

        //WebElement txtEmail= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        WebElement txtEmail= driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        txtEmail.sendKeys("john.doe"+ UUID.randomUUID()+"@example.com");

        WebElement btnSingUp= driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        btnSingUp.click();

        //-->Paso 3: Completar el formulario de registro
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        WebElement rdoMr=driver.findElement(By.id("id_gender1"));
        rdoMr.click();

        WebElement txtPassword= driver.findElement(By.cssSelector("input[data-qa='password']"));
        txtPassword.sendKeys("123456");

        Select selectDay= new Select(driver.findElement(By.id("days")));
        selectDay.selectByValue("15");

        Select selectMonth= new Select(driver.findElement(By.id("months")));
        selectMonth.selectByValue("11");
        
        Select selectYear= new Select(driver.findElement(By.id("years")));
        selectYear.selectByValue("1998");


        WebElement txtFirstName = driver.findElement(By.name("first_name"));
        txtFirstName.sendKeys("John");

        WebElement txtLastName = driver.findElement(By.name("last_name"));
        txtLastName.sendKeys("Doe");

        WebElement txtAddress = driver.findElement(By.cssSelector("input[data-qa='address']"));
        txtAddress.sendKeys("Calle Falsa 123");

        Select selectCountry= new Select(driver.findElement(By.id("country")));

        selectCountry.selectByVisibleText("Canada");
        
        WebElement txtState = driver.findElement(By.id("state"));
        txtState.sendKeys("Ontario");
        
        WebElement txtCity = driver.findElement(By.id("city"));
        txtCity.sendKeys("Toronto");

        WebElement txtZipCode = driver.findElement(By.id("zipcode"));   
        txtZipCode.sendKeys("M5V 3L9");
        
        WebElement txtMobileNumber = driver.findElement(By.id("mobile_number"));
        txtMobileNumber.sendKeys("1234567890");

        WebElement btnCreateAccount= driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnCreateAccount);
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateAccount));
        btnCreateAccount.click();

        driver.quit();


    }
    
}
