package com.automationexercise.pruebas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticaM4_TablaWebTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    String urlTest ="https://www.automationexercise.com/products";


    @BeforeClass
    public void setUp() {
        // Configuración del entorno de prueba, como inicializar el WebDriver y abrir el navegador
        ChromeOptions options = new ChromeOptions();

        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        js=(JavascriptExecutor) driver;
        driver.get(urlTest);

    }

    @Test 
    public void testTablaWeb() {

        // 1. Agregar un producto al carrito de compras

        WebElement btnAgregar=driver.findElement(By.cssSelector(".btn.btn-default.add-to-cart"));
        btnAgregar.click();

        // 2.Ir al carrito de compras y verificar que el producto se haya agregado correctamente

        WebElement btnVerCarrito= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cartModal']//u[text()='View Cart']")));
        js.executeScript("arguments[0].click();", btnVerCarrito);

        // 3. Leer el precio de la fila 1(relativo a la fila 1 de la tabla) y guardarlo en una variable
        WebElement precioFila1=driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/p[text()='Rs. 500']"));
        String precio1=precioFila1.getText();
        System.out.println("Precio de la fila 1: " + precio1);

        Assert.assertEquals(precio1, "Rs. 500", "El precio de la fila 1 no coincide con el valor esperado.");
    }

    @AfterClass 
    public void tearDown(){

        driver.quit();

    }
}
