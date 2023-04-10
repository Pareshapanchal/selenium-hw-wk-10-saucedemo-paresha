package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    //static variable declared and initialised
    static String baseUrl = "https://www.saucedemo.com/";
    static String browser = "Edge";
    static WebDriver driver;

    public static void main(String[] args) {
        //if condition open different browser
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser Name");
        }
        //Open URL
        driver.get(baseUrl);
        //Maximise the window
        driver.manage().window().maximize();
        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //print the page title
        System.out.println(driver.getTitle());
        //print the current URL
        System.out.println(driver.getCurrentUrl());
        //print the page source
        System.out.println(driver.getPageSource());
        //find username field and send the values to username field
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        //find password field and send the values to password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //closing the browser
        driver.close();
    }
}
