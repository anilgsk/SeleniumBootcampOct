package bootcampdoubts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOpportunity {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		//Create a instance of ChromeOptions class
				ChromeOptions options = new ChromeOptions();

				//Add chrome switch to disable notification - "**--disable-notifications**"
				options.addArguments("--disable-notifications");

				
			//driver = new ChromeDriver(options);
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(options);
		@SuppressWarnings("deprecation")
		WebDriverWait wait= new WebDriverWait(driver, 30);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();
				driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        
        WebElement opportuinity = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", opportuinity);
        WebElement search=driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
        search.sendKeys("Oppurtunity Automation by Test Leaf");
        
        Actions act = new Actions(driver);
        act.click(driver.findElementByXPath("//*[@aria-label='Breadcrumbs']//span[text()='Opportunities']"));
        //search.sendKeys(Keys.ENTER);
//        Robot r=new Robot();
//        r.keyPress(KeyEvent.VK_ENTER);
////        r.keyRelease(KeyEvent.VK_ENTER);
        //WebElement opportunityname=wait.until(ExpectedConditions.visibilityOf());
       wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath("//a[text()='Oppurtunity Automation by Test Leaf']")))).click();
       //.click();
        driver.executeScript("arguments[0].click();", driver.findElementByXPath("(//button[@name='Clone']//following::li//button)[1]"));
        driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()='Delete']"));
        
//       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")))).click();       
//       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Delete'])[1]")))).click();
//      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Delete'])[2]")))).click();
//      WebElement msg= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"))));
//       String deletemsg=msg.getText();
//      System.out.println(deletemsg);
//       if(deletemsg.contains("Oppurtunity Automation by Test Leaf"))
//       {
//    	   System.out.println("True");
//       }
//       else
//       {
//    	   System.out.println("False");   
//       }
     	}
	}


