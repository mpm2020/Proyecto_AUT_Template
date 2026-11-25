package com.automationexercise.paginas;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaLogin {

    private WebDriver driver;

    //Locators
    private By txtEmailLogin=By.cssSelector("input[data-qa='login-email']");
    private By txtPasswordLogin=By.cssSelector("input[data-qa='login-password']");
    private By btnLogin=By.cssSelector("button[data-qa='login-button']");
    private By lblTituloLogin=By.cssSelector("div.login-form h2");
    
    //Constructor
    public PaginaLogin(WebDriver driver){
        this.driver=driver;
    }

    public void completarUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmailLogin)).sendKeys(username);
    }

    public void completarPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPasswordLogin)).sendKeys(password);
    }

    public void hacerClickEnLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

    public String obtenerTituloLogin(){ 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblTituloLogin)).getText();
    }

}
