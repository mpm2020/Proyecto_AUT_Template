package com.automationexercise.pruebas;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.utils.ExcelReader;

import org.testng.annotations.DataProvider;
import com.automationexercise.paginas.PaginaLogin;

public class PracticaM3_DataProvider {

    String urlTest ="https://www.automationexercise.com/login";
    WebDriver driver;
    
    @BeforeSuite
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.75");
        options.addArguments("incognito");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeMethod 
    public void  irALogin(){
        driver.get(urlTest);
    }
    @Test(dataProvider = "credenciales")
    public void loginUsuario(String username,String password){
        PaginaLogin paginaLogin=new PaginaLogin(driver);
        paginaLogin.completarUsername(username);
        paginaLogin.completarPassword(password);
        paginaLogin.hacerClickEnLogin();

        //Con credenciales incorrectas se debe seguir en la página de login
        Assert.assertEquals(paginaLogin.obtenerTituloLogin(), "Login to your account");
        
    }
        
       
    @DataProvider(name = "credenciales")
    public Object[][] leerCredenciales() throws IOException {
        String rutaExcel="../Datos/credenciales.xlsx";
        return ExcelReader.leerExcel(rutaExcel, "Login");
    }
     
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


    

    
}
