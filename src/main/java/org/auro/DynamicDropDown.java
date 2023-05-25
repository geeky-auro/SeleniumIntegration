package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        // Problem : When from option is selected then to option is selected ..!
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        // To dynamically select 2nd option we used index since MAA appeared in source and destination
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    }
}
