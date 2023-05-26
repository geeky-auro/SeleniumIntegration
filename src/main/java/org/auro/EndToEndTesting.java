package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndTesting {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
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
        // Select the Calendar ;)
        /**
         *
         * CSSSelector Locator for Calendar currentDate ;_
         * .ui-state-default.ui-state-highlight
         *
         * */

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        // Now select the Departure Date ;)
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        // Since its not round trip so We need a disabled return date ;)
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }



        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        // Selecting 5 Adults from the dropdown ;)
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
//        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        // ACtual vs expected ;)
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();

        WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //<select name="ctl00$mainContent$DropDownListCurrency" id="ctl00_mainContent_DropDownListCurrency">
        //	<option value="">Select</option>
        //	<option value="INR">INR</option>
        //	<option value="AED">AED</option>
        //	<option value="USD">USD</option>
        //</select>
        Select dropdown=new Select(staticDropdown);
        dropdown.selectByIndex(3);

        // Click the search button ;)
        // unique id --> ctl00_mainContent_btn_FindFlights
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
