package bootcampdoubts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S20_61_NewOpertunity {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();
				driver.findElement(By.className("slds-icon-waffle")).click();
		
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
      
      //driver.switchTo().alert().accept();

        //driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]")).click();
        
        WebElement opportuinity = driver.findElement(By.xpath("//a[@title='Opportunities']/span"));
        
        driver.executeScript("arguments[0].click();", opportuinity);
        
        Thread.sleep(10000);
        
        driver.executeScript("arguments[0].click();", driver.findElementByXPath("(//a[text()='Bootcamp'])[1]"));
        
        driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a[text()='Details']"));
        
        driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()='Stage']//following::span[text()='Edit Stage']"));
        
        Thread.sleep(10000);
        
        Actions act = new Actions(driver);
        
        act.click(driver.findElementByXPath("//label[text()='Stage']/following-sibling::div"));
        
        //driver.executeScript("arguments[0].click();", driver.findElementByXPath("//label[text()='Stage']/following-sibling::div"));
        
        Thread.sleep(10000);
        
//        driver.executeScript("arguments[0].click();", driver.findElementByXPath("//label[text()='Stage']//following::span[text()='Needs Analysis']"));
//        Thread.sleep(10000);
        driver.executeScript("arguments[0].click();", driver.findElementByXPath("//button[@name='SaveEdit']"));
	}

}
