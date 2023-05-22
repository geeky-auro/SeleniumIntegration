package org.auro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators_techniques {
    public static void main(String[] args) throws InterruptedException{
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
         * */

        // <input type="text" placeholder="Username" id="inputUsername" value="contact@rahulshettyacademy.com">
        // Here the ID can be used as a locator by the selenium ;0

        System.setProperty("webdriver.chrome.driver","C:\\chrome_driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // We use Implicitwait becoz we need something to show while an even has occoured such as button click
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


        // To wait for the Slider to slide in the single Web Page Application we make the program wait..@! <Explicit Wait>
        Thread.sleep(2000);

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
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //When we have multiple same tags then a unique way to select by cssSelector is ;-
        //  for selecting "Email" -> input[type='text']:nth-child(2) ...<Most Appropriate>

        driver.findElement(By.cssSelector("input[type='text']:nth-of-type(2)")).sendKeys("johnsa@gmail.com");

        // Traversing from parent to child via only tags (not using tag attributes) with the help of Xpath ;)
        /**
         * Ex:-
         * <form action="#">
         *     <h2>Forgot password</h2>
         *     <input type="text" placeholder="Name">
         *     <input type="text" placeholder="Email">
         *     <input type="text" placeholder="Phone Number">
         *     <br>
         *         <div class="forgot-pwd-btn-conainer">
         *         <button class="go-to-login-btn">Go to Login</button>
         *         <button class="reset-pwd-btn">Reset Login</button>
         *         </div>
         *</form>
         *
         * Here Form is the parent and inputs are its child ..!
         * We can traverse it from parent to child via XPath ;)
         *  Syntax : //parentTagName/ChildTagName
         *  Ex: //form/h2 ------> To reach to h2
         *  Ex: //form/input[3] -------> To reach to input tag with attribute placeholder="Phone Number"
         *  The above method purely focuses on tag name not by any of the attribute
         * */
//        driver.findElement(By.xpath("input[type='text']:nth-child(3)")).sendKeys("8249696287");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8249696287");

        // <button class="reset-pwd-btn">Reset Login</button>
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // parentTagName childTagName
        /**
         *
         * Ex:
         *          * <form action="#">
         *          *     <h2>Forgot password</h2>
         *          *     <p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
         *          *     <input type="text" placeholder="Name">
         *          *     <input type="text" placeholder="Email">
         *          *     <input type="text" placeholder="Phone Number">
         *          *     <br>
         *          *         <div class="forgot-pwd-btn-conainer">
         *          *         <button class="go-to-login-btn">Go to Login</button>
         *          *         <button class="reset-pwd-btn">Reset Login</button>
         *          *         </div>
         *          *</form>
         *          *
         *
         *          To select p tag we can use the iterative method of Parent-to-Child type using CSS Selector
         *          Syntax: parentTagName childTagName
         * */

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        // Switching back to login page
        //<div class="forgot-pwd-btn-conainer">
            // <button class="go-to-login-btn">Go to Login</button>
            // <button class="reset-pwd-btn">Reset Login</button>
        // </div>

        // Customized X path for clickung Go to Login ---> //div[@class='forgot-pwd-btn-container']/button[1]
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        // Now it will change the Tilt view so apply wait ;0
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        // <input type="password" placeholder="Password" name="inputPassword" value="">
        // By using Regex ;) Ex input[type*='pass']
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        // Time to select the checkbox
        //<input type="checkbox" id="chkboxOne" name="chkboxOne" value="rmbrUsername">
        driver.findElement(By.id("chkboxOne")).click();

        // Selecting Regex using X Path {Clicking Sign in Button}
        //<button class="submit signInBtn" type="submit">Sign In</button>
        // Equivalent regex Xpath is : //button[contains(@class,'submit')]
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(2000);
        //<p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.</p>

        if(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText().equalsIgnoreCase("You are successfully logged in.")){
            System.out.println("Worked Successfully");
            // <button class="logout-btn" xpath="1">Log Out</button>
            // Time to log out
            driver.findElement(By.cssSelector(".logout-btn")).click();
        }else{
            System.out.println("Failed");
        }
        Thread.sleep(700);
        driver.close();

    }
}


