package bootcampdoubts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;

public class Doubt3 {
	static ChromeDriver driver;
	static int counter =0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		
	driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/");
		
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		
		driver.findElementById("password").sendKeys("Bootcamp@123");
		
		driver.findElementById("Login").click();
		
		Thread.sleep(15000);
		
		driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']").click();
		
		//driver.findElementByXPath("//button[text()='View All']").click();
		
		driver.findElementByXPath("//*[text()='New Task']").click();
		
		driver.executeScript("arguments[0].click()",driver.findElementByXPath("//*[text()='Maximize']") );
		
		//driver.findElementByXPath("//*[text()='Maximize']").click();
		
		
	
		
		
				
		//driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']").click();
		
		}
	
	
	

}
