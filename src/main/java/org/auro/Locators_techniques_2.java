package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators_techniques_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        // We use Implicitwait becoz we need something to show while an even has occoured such as button click
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // <input type="text" placeholder="Username" id="inputUsername" value="">
        String name="Sam";
        driver.findElement(By.id("inputUsername")).sendKeys(name);

        // <input type="password" placeholder="Password" name="inputPassword" value="">
        // Here we have name as the locator ;)

        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(3500);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        // SCan whether the Text matches or not without looking into Console if no error  then test passed successfully
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
//        System.out.println("DoneL");
//        driver.findElement(By.cssSelector(".logout-btn")).click();
        // In Xpath we can identify button based on its text ;)
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();








    }
}
