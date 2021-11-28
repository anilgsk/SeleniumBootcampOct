package bootcampdoubts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;


public class CreateNewOpportunity {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
      
      //driver.switchTo().alert().accept();

        //driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]")).click();
      
        WebElement opportuinity = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.executeScript("arguments[0].click();", opportuinity);
        driver.findElement(By.xpath("//div[@title='New']")).click();
        String text = "Salesforce Automation by Manikandan.N";
        driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys(text);
        //driver.findElement(By.className("datePicker-openIcon display")).click();
        driver.findElement(By.xpath("(//input[@class=' input'])[1]")).click();
        //driver.findElement(By.className("today slds-button slds-align_absolute-center slds-text-link")).click();
        driver.findElement(By.xpath("//button[text()='Today']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='--None--']")).click();
        driver.findElement(By.xpath("//a[text()='Needs Analysis']")).click();
        driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
        
        WebElement actual = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-aura-class='forceActionsText']"))));
       
        if(actual.getText().contains(text)) {
        	System.out.println("Test Pass");
        }else {
        	System.out.println("Test Fail");
        }
        
	}

}
