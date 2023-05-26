package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// TestNg <Assertion is used for automation ;)>

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // Handling checkboxes ;)
//        If the below line fails then there is some problem that it true is passed  ;)
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        // Check whether Checkbox is Selected or not
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        // Count the no. of Checkboxes use the type attribute
//        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
//        If the below line fails then there is some problem that it false is passed  ;)
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());





        // Enable the Radio Button
        // <input id="ctl00_mainContent_rbtnl_Trip_1" type="radio" name="ctl00$mainContent$rbtnl_Trip" value="RoundTrip" checked="checked">
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        /*
        * Validating if UI elements are enabled or disabled
        * Visits the website and see that Return Date is Disabled unless and until Round-trip Checkbox is enabled
        * But even if it looks disabled we can still click and make it enabled which makes selenium confused ;) as if its never disabled
        * Before Enabled
        * <input name="ctl00$mainContent$view_date1" type="text" readonly="readonly" id="ctl00_mainContent_view_date1" class="custom_date_pic required picker-first home-date-pick">
        <div id="Div1" class="picker-second" style="opacity: 1; display: block;"></div>
           After Enabled
           *  <input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick valid">
           <div id="Div1" class="picker-second" style="opacity: 0.5; display: block;"></div>
           Notice in the class attribute there's a change ;)
        * */

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
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

    }
}
