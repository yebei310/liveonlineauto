package testcases;


import net.sf.cglib.asm.$ClassReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Timetable {


        WebDriver driver;
        @BeforeMethod
        public void setUp () throws Exception {


//            System.setProperty("webdriver.chrome.driver", "D:\\auto\\driver\\chromedriver.exe");// chromedriver驱动存放地址
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");// chro
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            String url = "https://test-staff.puxinwangxiao.com/";
            driver.get(url);
            System.out.printf("打开页面");
            System.out.printf("打开页面");
        }
        @Test
        public void setLogin ()throws Exception {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[2]/form/div[1]/div[1]/div/div[1]/input")).sendKeys("13261462623");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[2]/form/div[2]/div[1]/div/div[1]/input")).sendKeys("abc123456");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div[2]/form/div[3]")).click();
            Thread.sleep(3000);
            System.out.printf("登录成功");
            String tssUrl = "https://test-tss.puxinwangxiao.com/myCourse/todoList";
            driver.get(tssUrl);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/div[2]/table/tbody/tr[1]/td[16]/div/button")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/section/div/div[4]/div/div/div[2]/div/div/a")).click();
            Thread.sleep(6000);
            Set<String> set = driver.getWindowHandles();
            driver.switchTo().window((String) set.toArray()[1]);
            driver.navigate().refresh();
            Thread.sleep(8000);
            driver.findElement(By.xpath("//*[@id=\"class-panel-container\"]/div[5]/div")).click();
            Thread.sleep(10000);
        }
        @AfterMethod
        public void tearDown() throws Exception {
            driver.quit();
        }

    }

