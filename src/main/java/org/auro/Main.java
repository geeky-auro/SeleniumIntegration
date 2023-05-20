package org.auro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        //        System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //        Hit URL and Open the Browser
        driver.get("https://countmycrunch.netlify.app/");
        //        driver.quit();
        //        Check the title of the Page..!
        String st=driver.getTitle();
        System.out.println("Title of the Page:"+st);

        /**
         *
         * Check whether on hitting you are been sent to the same page or have been redirected to anyother page
         * */

        System.out.print("URL of the Web Page"+driver.getCurrentUrl());


        // After test Close the browser (Closes the Current Site / Hovered Page ;))
        driver.close();
        // Closes all associated windows
        driver.quit();


    }

}