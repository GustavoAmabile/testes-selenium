package com.aula.Selenium.AliExpress;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrimeirosTestes {

    private WebDriver driver;

    @Test
    public void selletiumTest() {

        System.getProperty("webdriver.chrome.driver",
                "C:\\Users\\gusta.GUSTAVO\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://pt.aliexpress.com/?spm=a2g0o.home.1000002.1.5ebd1c91SKSEU9&gatewayAdapt=glo2bra");
        driver.quit();

    }

    @Test
    public void testarTitulo() {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opt);
        driver.get("https://pt.aliexpress.com/?spm=a2g0o.home.1000002.1.5ebd1c91SKSEU9&gatewayAdapt=glo2bra");
        assertEquals("AliExpress - Comprar eletrônicos, " +
                        "produtos de moda, produtos para casa & jardim e automotivos vindos diretamente da China - AliExpress.com",
                driver.getTitle());

    }

    @Test
    public void testarBotaoLogIn(){

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://pt.aliexpress.com/?spm=a2g0o.home.1000002.1.5ebd1c91SKSEU9&gatewayAdapt=glo2bra");
        driver.findElement(By.className("ng-account-icon")).click();
        driver.findElement(By.className("sign-btn")).click();
        driver.findElement(By.id("fm-login-id")).sendKeys("usardecaixadeentrada@gmail.com");
        driver.findElement(By.id("fm-login-password")).sendKeys("WEas31234");
        driver.findElement(By.className("login-submit")).click();

        assertTrue(driver.findElement(By.className("ng-account-icon")).isDisplayed());
        assertTrue(driver.findElement(By.className("ng-account-icon")).isEnabled());
        assertFalse(driver.findElement(By.className("ng-account-icon")).isSelected());
        assertNotNull(driver.findElement(By.className("ng-account-icon")));





    }

    @Test
    public void testarBusca() {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://pt.aliexpress.com/?spm=a2g0o.home.1000002.1.5ebd1c91SKSEU9&gatewayAdapt=glo2bra");
        driver.findElement(By.id("search-key")).sendKeys("camiseta");
        driver.findElement(By.className("search-button")).click();

        assertTrue(driver.findElement(By.className("search-key")).isDisplayed());
        assertTrue(driver.findElement(By.className("search-key")).isEnabled());
        assertFalse(driver.findElement(By.className("search-key")).isSelected());
        assertNotNull(driver.findElement(By.className("search-key")));
        assertNotSame(driver.findElement(By.className("search-key")), driver.findElement(By.className("search-key")));


    }

    @Test
    public void testarBuscaAvancada() {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://pt.aliexpress.com/?spm=a2g0o.home.1000002.1.5ebd1c91SKSEU9&gatewayAdapt=glo2bra");
        driver.findElement(By.id("search-key")).sendKeys("camiseta");
        driver.findElement(By.className("search-button")).click();
        List<WebElement> allDivs = driver.findElements(By.className("comet-input"));
        if (allDivs.size() >= 0){
            allDivs.get(0).sendKeys("10");
            allDivs.get(1).sendKeys("50");
        }
        driver.findElement(By.className("priceInput--ok--2apR64x")).click();

        assertTrue(driver.findElement(By.className("search-key")).isDisplayed());
        assertTrue(driver.findElement(By.className("search-key")).isEnabled());
        assertFalse(driver.findElement(By.className("search-key")).isSelected());
        assertNotNull(driver.findElement(By.className("search-key")));
        assertNotSame(driver.findElement(By.className("search-key")), driver.findElement(By.className("search-key")));



    }
}
