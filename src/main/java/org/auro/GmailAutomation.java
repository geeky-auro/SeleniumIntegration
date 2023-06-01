package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/");
        driver.findElement(By.id("identifierId")).sendKeys("username");
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("pwd");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
    }
}
