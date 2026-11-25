package com.automationexercise;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PracticaM1 {
    @Test
    public void holamundo(){
        System.out.println("Hola mundo de automatización!");
    
    }

    @Test
    public void lab1_E2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.quit();

    }
   
    @Test
    public void lab1_E3(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.automationexercise.com/");
        driver.quit();

    }
    @Test
    public void lab1_E4(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/products");
        WebElement txtBuscar= driver.findElement(By.id("search_product"));
        txtBuscar.sendKeys("Tshirt");
        WebElement btnBuscar= driver.findElement(By.id("submit_search"));
        btnBuscar.click();
        driver.quit();

    }
    
}
