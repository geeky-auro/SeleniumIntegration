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
        // CHeck whether Checkbox is Selected or not
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        // Count the no. of Checkboxes use the type attribute
//        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
//        If the below line fails then there is some problem that it false is passed  ;)
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
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
