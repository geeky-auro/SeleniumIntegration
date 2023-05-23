package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SauceDemo_InternTask  {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        // We use Implicitwait becoz we need something to show while an even has occoured such as button click
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");


        // Entering Username and Password ;)
        String allText=driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String childText=driver.findElement(By.cssSelector("div[class='login_password'] h4")).getText();
        String password=allText.replace(childText,"");
//        System.out.println(password+""+password.length());
        String userName="standard_user";
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password.trim());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

        Thread.sleep(2000);
        // Required Validation :- <Check whether all the items have been added in the cart or not ;)>
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        System.out.println("Total No. of items in the Cart : "+driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText());

    }

}
