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
        String password=getPassWord(driver);
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        // <input type="password" placeholder="Password" name="inputPassword" value="">
        // Here we have name as the locator ;)

        driver.findElement(By.name("inputPassword")).sendKeys(password);
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

    public static String getPassWord(WebDriver driver) throws InterruptedException{
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //<a href="#">Forgot your password?</a>
        // Use Link text Locator to handle links as above
        // Make sure the tag should be anchor tag ;_
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        // <button class="reset-pwd-btn">Reset Login</button>
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText=(driver.findElement(By.cssSelector("form p")).getText());
        //Please use temporary password 'rahulshettyacademy' to Login.
        String passwordArrau[]=passwordText.split("'");
        // 0th index -> Please use temporary password
        // 1st index -> rahulshettyacademy' to Login.
        String finalarray[]=passwordArrau[1].split("'");
        // 0th index -> rahulshettyacademy
        // 1st index ->  to Login.
        // There's no need to create a variable it can be done directly
        // passwordArrau[1].split("'")[0] -----> This will give the required dynamic pwd ;)
        String dynamicPwd=finalarray[0];
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        // Now it will change the Tilt view so apply wait ;0
        Thread.sleep(1000);
        return dynamicPwd;

    }


}
