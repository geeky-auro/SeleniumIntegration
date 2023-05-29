package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PoPupNotification {
    public static void main(String[] args) {
        String text="Auro";
        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        // Now pop up appears but we cant spy/inspect becoz it is not html code .. it is JS COde
        /*Now Task: Grab the text in Alert ;) */
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        // After switching context from Website to alert selenium gets the knowledge of where to place the code
        // .accept means clicking ok ;0
        // .accept() positive side ;)

        // Another type of alert button is ;)
        // Ok option and cancel option ;)
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        // .dismiss finds for negative scope which means Cancel or No button on alerts



    }
}
