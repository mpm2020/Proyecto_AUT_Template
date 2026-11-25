package com.automationexercise.pruebas;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class PracticaM3_fallido {
    //-->Inicializar variables de WebDriver y WebDriverWait y la URL de la página de Automation Exercise
    WebDriver driver;
    WebDriverWait wait;
    String urlTest ="https://www.automationexercise.com/";
   
    //--> Configurar WebDriver y WebDriverWait antes de ejecutar los tests
    @BeforeSuite
    public void setUp(){
        driver= new ChromeDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //--> Ir a la URL de la página de Automation Exercise antes de ejecutar los tests
    @BeforeTest
    public void irURL(){
        driver.get(urlTest);
        
    }
    
    //--> Maximizar la ventana del navegador y eliminar cookies antes de ejecutar los tests
    @BeforeClass 
    public void maxVentana(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
 
   
    //--> Test para registrar un usuario en la página de Automation Exercise 
    @Test 
    public void registroUsuarioFallidoTest(){

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

        //--> Verificación con  asser: El registro  no debe completarse
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"),"La pagina no tiene el password");
    
    }
    //--> Captura de pantalla después de cada test
    @AfterMethod
    public void capturaPantalla() throws IOException {
        File screen= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fecha=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        FileUtils.copyFile(screen, new File("screenshots/screenshot_"+fecha+".png"));


    }
    //--> Finalizar la prueba, se ejecuta después de todos los tests de la clase
    @AfterClass
    public void finPrueba(){
        System.out.println("Fin de Prueba");
    }
    //--> Cerrar el navegador,se ejecuta después de todos los tests de la clase
    @AfterTest
    public void cerrarNavegador(){
        driver.quit();
    }
    //Finalizar la suite de pruebas, se ejecuta después de todos los tests
    @AfterSuite
    public void finSuite(){
        System.out.println("Fin de Suite");
    }
}
