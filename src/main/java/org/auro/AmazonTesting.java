package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Amazon miniTV']")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Sell']")).click();
        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.cssSelector(".nav-a[href='/gp/bestsellers/?ref_=nav_cs_bestsellers']")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.cssSelector(".nav-a[href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']")).click();
        driver.navigate().back();
        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.cssSelector(".nav-a[href='/deals?ref_=nav_cs_gb']")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.cssSelector(".nav-a[href='/deals?ref_=nav_cs_gb']")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.xpath("//a[@href='/deals?ref_=nav_cs_gb']")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.cssSelector(".nav-a[href='/deals?ref_=nav_cs_gb']")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[2]/div[2]/div[1]/a[6]")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[2]/div[2]/div[1]/a[7]")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Electronics')]")).click();
        driver.navigate().back();
//        driver.findElement(By.cssSelector("#nav-logo-sprites")).click();
        driver.findElement(By.xpath("//body[1]/div[1]/header[1]/div[1]/div[4]/div[2]/div[2]/div[1]/a[9]/span[1]")).click();
        driver.navigate().back();

        driver.findElement(By.xpath("//a[contains(text(),'Home & Kitchen')]")).click();
        driver.navigate().back();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[contains(text(),'Fashion')]")).click();
        Thread.sleep(500);
        driver.navigate().back();
        driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[2]/div[2]/div[1]/a[12]")).click();
        Thread.sleep(500);
        driver.quit();
    }
}
