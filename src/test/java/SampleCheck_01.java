import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class SampleCheck_01
{
   static WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
     driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
    @BeforeMethod
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
        Thread.sleep(2000);
    }
   @Test
    public void test1() throws IOException {
       TakesScreenshot ts =(TakesScreenshot) driver;
       File file=ts.getScreenshotAs(OutputType.FILE);
       File file1= new File("./src/Screenshot/test.png");
       FileUtils.copyFile(file,file1);

   }


   @AfterMethod
    public void logout()
   {
       driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
       driver.findElement(By.xpath("//a[text()='Logout']")).click();

   }
}
