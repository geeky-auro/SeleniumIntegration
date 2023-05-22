# SeleniumIntegration
Introduction to Selenium and Webdrivers. How to run test cases in Google.
Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language.
<br>
Practise Site : https://rahulshettyacademy.com/locatorspractice/


## Difference between Implicit Wait and Explicit Wait
In Selenium, both implicit wait and explicit wait are used to handle synchronization issues while interacting with web elements. However, they differ in how they are implemented and when they are applied.

1. Implicit Wait:
    - Implicit wait is a global setting applied to the WebDriver instance throughout the test execution.
    - It sets a default waiting time for the WebDriver to wait for an element to be present before throwing an exception.
    - Once set, the implicit wait is applied to all subsequent calls to find elements.
    - If an element is not immediately available, WebDriver will wait for the specified time before throwing a "NoSuchElementException" if the element is still not found.
    - It is defined once at the beginning of the test and remains in effect until it is changed or the WebDriver instance is closed.

   Example:
   ```
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   ```

2. Explicit Wait:
    - Explicit wait is used to wait for a specific condition to be met before proceeding with the execution.
    - It allows fine-grained control over waiting for elements and provides flexibility in defining the conditions.
    - Explicit wait waits until a certain condition is met or a timeout period is reached.
    - Conditions can be based on element visibility, presence, clickability, etc., and can be customized using Expected Conditions provided by Selenium.
    - Unlike implicit wait, explicit wait is applied only at specific points in the test where synchronization is required.

   Example:
   ```
   WebDriverWait wait = new WebDriverWait(driver, 10);
   WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
   ```

   In the above example, the explicit wait waits for a maximum of 10 seconds for the element with the specified ID to be visible. If the element becomes visible within that time, it is returned; otherwise, a "TimeoutException" is thrown.

In summary, implicit wait is a global setting applied throughout the test execution, while explicit wait allows more control over waiting for specific conditions at desired points in the test. Implicit wait has a default timeout for all elements, while explicit wait allows custom conditions and timeouts for individual elements. Both types of waits can be used together in a test, depending on the synchronization requirements.

## .quit() vs .close()
In the context of web browser automation using Selenium, both `driver.close()` and `driver.quit()` are methods used to close the browser window or terminate the WebDriver session. However, there is a difference in their behavior:

1. `driver.close()`: This method is used to close the current browser window or tab being controlled by the WebDriver. If there is only one window or tab open, calling `driver.close()` will effectively end the WebDriver session as well. If there are multiple windows or tabs open, calling `driver.close()` will close the current window/tab and switch the WebDriver's focus to the previously active window/tab.

2. `driver.quit()`: This method is used to completely terminate the WebDriver session and close all associated browser windows or tabs. It will shut down the WebDriver process and release all allocated resources, including the browser instance. Regardless of the number of windows or tabs open, calling `driver.quit()` will close all of them and end the WebDriver session.

In summary, if you have multiple windows or tabs open and want to close only the current one while keeping the WebDriver session active, you can use `driver.close()`. If you want to close all windows or tabs and terminate the WebDriver session, `driver.quit()` should be used.
