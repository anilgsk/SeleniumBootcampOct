package bootcampdoubts;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S20_18_CreateNewTask {
	static RemoteWebDriver driver;
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) throws InterruptedException {
		//Driver setup
		
		
	       WebDriverManager.chromedriver().setup();
		     driver = new ChromeDriver();         
		
		        
		        driver.manage().window().maximize();
		        WebDriverWait wait = new WebDriverWait(driver,30);
		        driver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);        
		        //Login into application
		        driver.get("https://login.salesforce.com/");
		        driver.findElementById("username").sendKeys("cypress@testleaf.com");
		        driver.findElementById("password").sendKeys("Selbootcamp@123");
		        driver.findElementById("Login").click();
		        Thread.sleep(30000);
		        
		        driver.findElementByXPath("//*[@class='slds-icon slds-icon_x-small']").click();
		        
		        WebElement GlobalAction = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@data-aura-class='oneGlobalCreate']")));
		        driver.executeScript("arguments[0].click();", GlobalAction);
		        driver.findElementByXPath("//span[text()='New Task']").click();
		        driver.findElementByXPath("//*[@title='Maximize']").click();
		        driver.findElementByXPath("//input[@id=\"input-81\"]").sendKeys("Bootcamp");
		        driver.findElementByXPath("//input[@title='Search Contacts']").click();
		        driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("Peter");
		        driver.findElementByXPath("//div[@title='peter lesley']").click();
		        driver.findElementByXPath("//*[text()='Not Started']").click();
		        driver.findElementByXPath("//a[text()='Waiting on someone else']").click();
		        driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		       
		        //Click Global Actions
		        driver.findElementByXPath("//div[@class='headerTrigger  tooltip-trigger uiTooltip']").click();
		        Thread.sleep(2000);
		        driver.findElementByXPath("//span[text()='New Task']").click();
		        Thread.sleep(15000);
		       
		        //Maximize new task window
		        driver.findElementByXPath("//*[@title='Maximize']").click();
		        Thread.sleep(1000);
		       
		        //Enter subject
		        driver.findElementByXPath("//input[@id=\"input-81\"]").sendKeys("Bootcamp");
		       
		        //Select contacts
		        driver.findElementByXPath("//input[@title='Search Contacts']").click();
		        Thread.sleep(2000);
		        driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("Peter");
		        Thread.sleep(2000);
		        driver.findElementByXPath("//div[@title='peter lesley']").click();
		        Thread.sleep(2000);
		       
		        //Select status
		        driver.findElementByXPath("//*[text()='Not Started']").click();
		        driver.findElementByXPath("//a[text()='Waiting on someone else']").click();
		        
		        //click save
		        driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		        
		        //verify the message
		        String text="Bootcamp";
		        Thread.sleep(2000);
		        WebElement actual = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-aura-class='forceActionsText']"))));
		        
		        if(actual.getText().contains(text)) {
		        	System.out.println("Test Pass");
		        	driver.close();
		        }else {
		        	System.out.println("Test Fail");
		        }
		}
		
        
	}


