package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators_techniques {
    public static void main(String[] args) {
        System.out.println("Hello WOrld Welcome to Locators and Techniques ;)");
        //Locators used by Selenium
        /**
         * ID
         * Xpath
         * CSS Selector
         * name
         * Class Name
         * Tag Name
         * Link Text
         * Partial Link Text
         *
         *
         *
         * */

        // <input type="text" placeholder="Username" id="inputUsername" value="contact@rahulshettyacademy.com">
        // Here the ID can be used as a locator by the selenium ;0

        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // <input type="text" placeholder="Username" id="inputUsername" value="">

        driver.findElement(By.id("inputUsername")).sendKeys("contact@rahulshettyacademy.com");

        // <input type="password" placeholder="Password" name="inputPassword" value="">
        // Here we have name as the locator ;)

        driver.findElement(By.name("inputPassword")).sendKeys("AnythingRandom");
        // Now Sign in
        // <button class="submit signInBtn" type="submit">Sign In</button>
        // Here we can use class as locator but observe that class submit and signInBtn are separate word not a single word
        // so here we need to choose which one we need to use ;)

        driver.findElement(By.className("signInBtn")).click();

        // Now we can display the message <p class="error">* Incorrect username or password </p>
        // Here we can use className but will be using something different this time ;)
        // CSS Selector
        /**
         * If we have a class name and derive CSS out of it ;)
         * we can use the following ;_
         * Class Name-> tagname.classname
         * Ex: <button class="submit signInBtn" type="submit">Sign In</button>
         * button.signInBtn
         * Id-> tagname#id
         * Ex: <input type="text" placeholder="Username" id="inputUsername" value="">
         *     input#inputUsername
         *
         *     But if we neither have ID nor Username then we can still use Xpath or CSS (becoz they are universal ;-)
         *     "A Generic Way to use ;)"
         *
         *     tagname[attribute='value']
         *     Ex: <input type="text" placeholder="Username">
         *         input[placeholder="Username"]
         *
         *         Suppose in out task we use <p class="error">* Incorrect username or password </p>
         *         and for CSS selector we use { p.error }
         *         if there exist multiple tags with same class name then it would be an problem
         *         hence to check whether we have uniquely selected or not we use SelectorHub or CroPath ;)
         *         if SelectorHub shows 1 element matching then its unique l)
         *         Other way doing around is use $('p.error') in the browser console via inspect elements ;)
         *         if 0 matching then wrong or invalid CSS selector ;)
         * */

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        // The above shows error because Selenium executes immediately but the text loads after 2 sec soo for that we can use
        // Thread.sleep ;0 (implicit wait)

        //<a href="#">Forgot your password?</a>
        // Use Link text Locator to handle links as above
        // Make sure the tag should be anchor tag ;_
        driver.findElement(By.linkText("Forgot your password?")).click();

        /**
         * To use Xpath :-
         * //TagName[@attribute='value']
         * //input@placeholder='Username
         * */

        //<input type="text" placeholder="Name">
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        // For validation in console use $x('//input[@placeholder="Name"]')

        //<input type="text" placeholder="Email">
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@sa.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();

        //<input type="text" placeholder="Name">
        //<input type="text" placeholder="Email">
        //<input type="text" placeholder="Phone Number">
        //When we have multiple same tags then a unique way to select by xPath is ;-
        //  for selecting "Email" -> //input[@type='text'][2]

        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@sa.com");
        driver.findElement(By.xpath("//input[@type='text][2]")).clear();

        //When we have multiple same tags then a unique way to select by cssSelector is ;-
        //  for selecting "Email" -> input[type='text']:nth-child(2) ...<Most Appropriate>

        driver.findElement(By.xpath("input[type='text']:nth-child(2)")).sendKeys("johnsa@gmail.com");







    }
}
