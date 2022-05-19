import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;
import java.util.concurrent.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class demo_blaze {

    public static void main(String[]args) throws InterruptedException {
        String uname1 = "nirab" + getRandom(1000, 1000000);
        String pass1 = "2135451";

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        contact(driver);
        register(driver, uname1, pass1);
        login(driver, uname1, pass1);
        cart(driver);
    }


    public static String getRandom(int min, int max){
        return Integer.toString(ThreadLocalRandom.current().nextInt(min, max+1));

    }

    public static void contact(ChromeDriver driver) throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
        driver.findElement(By.id("recipient-email")).sendKeys("alphos@gmail.com");
        driver.findElement(By.id("recipient-name")).sendKeys("al");
        driver.findElement(By.id("message-text")).sendKeys("demo done");
        driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(7000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")).click();
    }

    public static void register(ChromeDriver driver, String username, String password) throws InterruptedException {

        driver.findElement(By.id("signin2")).click();
        driver.findElement(By.id("sign-username")).sendKeys(username);
        driver.findElement(By.id("sign-password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(7000);
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
    }
    public static void login(ChromeDriver driver, String username, String password) throws InterruptedException{
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(5000);
    }
    public static void cart(ChromeDriver driver) throws InterruptedException{
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        Thread.sleep(7000);
        Alert alert3 = driver.switchTo().alert();
        alert3.accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("name")).sendKeys("demoName");
        driver.findElement(By.id("country")).sendKeys("demoCountry");
        driver.findElement(By.id("city")).sendKeys("democity");
        driver.findElement(By.id("card")).sendKeys("212313");
        driver.findElement(By.id("month")).sendKeys("feb");
        driver.findElement(By.id("year")).sendKeys("2021");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout2")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
