package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        // Selecting 5 Adults from the dropdown ;)
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();
    }
}
