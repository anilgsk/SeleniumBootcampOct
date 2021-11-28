package bootcampdoubts;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;

public class Doubt1 {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/");
		
		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		
		driver.findElementById("password").sendKeys("Bootcamp@123");
		
		driver.findElementById("Login").click();
		
	
		
		//Thread.sleep(15000);
				
		//driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']").click();
		
		}
	
	public void test() throws IOException {
		ReadExcel1.readdata();
	}
	

}
