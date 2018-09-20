import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 17.09.2018<br>
 * Time: 17:24<br>
 * todo javadoc
 */
public class NewInsuranceTest extends BaseTest {


    @org.junit.Test
    public void testInsurance()  {
        //System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        driver.findElement(By.xpath("//li[@class = \"dropdown adv-analytics-navigation-line1-link current\"]/a[contains (text(), \"Страхование\")]")).click();
        driver.findElement(By.xpath("//*[@class =\"adv-analytics-navigation-line3-link\"]/a[contains(text(), \"ДМС\")]")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        WebElement sendButton = driver.findElement(By.xpath("//a[contains(text(), \"Отправить заявку\")]"));

        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();
        //driver.findElement(By.xpath("//a[contains(text(), \"Отправить заявку\")]")).click();
        WebElement title = driver.findElement(By.xpath("//*[contains(text(), \"Заявка\")]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Заявка на добровольное медицинское страхование",title.getText());

        fillField(By.name("LastName"), "Криницын");
        fillField(By.name("FirstName"), "Иван");
        fillField(By.name("MiddleName"), "Андреевич");

        new Select(driver.findElement(By.name("Region"))).selectByVisibleText("Москва");

        fillField(By.name("Comment"), "autotest");
        fillField(By.name("Email"), "123456");
        driver.findElement(By.xpath("//input[@class = \"checkbox\"]")).click();
        driver.findElement(By.xpath("//button[@id = \"button-m\"]")).click();

        Assert.assertEquals("Введите адрес электронной почты", driver.findElement(By.xpath("//span[contains(text(), \"Введите адрес электронной почты\")]")).getText());
        Assert.assertEquals("Криницын", driver.findElement(By.name("LastName")).getAttribute("value"));






        }




}
