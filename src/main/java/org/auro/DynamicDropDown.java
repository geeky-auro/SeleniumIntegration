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
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        // Another way to handle the above problem "by not using indexes is " -> parentXpath childXpath
        // //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

        /**
         *
         * CSSSelector Locator for Calendar currentDate ;_
         * .ui-state-default.ui-state-highlight
         *
         * */

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
    }
}
