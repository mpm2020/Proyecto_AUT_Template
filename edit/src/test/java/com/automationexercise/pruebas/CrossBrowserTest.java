package com.automationexercise.pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

     WebDriver driver;


    @BeforeTest
    @Parameters("navegador")
    public void setUp(String navegador) {
        if (navegador.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        } else if (navegador.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
           
        }  
       driver.get("https://www.automationexercise.com/products");
       driver.manage().window().maximize();

    }
   

    @Test
    public void buscarProducto(){
        WebElement txtBuscar= driver.findElement(By.id("search_product"));
        txtBuscar.sendKeys("Tshirt");
        WebElement btnBuscar= driver.findElement(By.id("submit_search"));
        btnBuscar.click();
 

    }

    @AfterTest
    public void tearDown(){

        driver.quit();

    }
}