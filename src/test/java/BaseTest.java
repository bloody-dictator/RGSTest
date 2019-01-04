import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.*;
import java.util.concurrent.*;


public class BaseTest {
    public static TestProperties testProperties = new TestProperties();
    public  static Properties properties = testProperties.properties;
    public static String baseURL;
    public static String wbdriver;
    public static String browser;
    public String pathDriver;
    public static WebDriver driver;





    @BeforeClass
    public static void setUp(){
        String wbdriver = properties.getProperty("wbdriver");
        String pathDriver = properties.getProperty("webdriver.chrome.driver");
        System.setProperty(wbdriver, pathDriver);
        String browser = properties.getProperty("browser");
        driver = new ChromeDriver();
        baseURL = properties.getProperty("app.url");
        driver. manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);


    }




    @AfterClass
    public static void afterTest(){
        driver.quit();
    }


    public void fillField (By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator). sendKeys(value);



    }

}
