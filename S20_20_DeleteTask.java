package bootcampdoubts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S20_20_DeleteTask {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		//Load url and	 login	:
        driver.get("https://login.salesforce.com/");
        driver.findElementById("username").sendKeys("cypress@testleaf.com");
        driver.findElementById("password").sendKeys("Selbootcamp@123");
        driver.findElementById("Login").click();
        driver.findElement(By.className("slds-icon-waffle")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,80);
        
//        //Toggle menu  - //div[@class='slds-icon-waffle']
//         WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='slds-icon-waffle']")));
//         JavascriptExecutor executor = (JavascriptExecutor) driver;
//         executor.executeScript("arguments[0].click();", ele);
        
		//ViewAll - //button[text()='View All']
        // driver.switchTo().alert().dismiss();
         WebElement ele1=wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[text()='View All']")));
         ele1.click();
         //executor.executeScript("arguments[0].click();", ele1);
         
		//Click Sales - //p[text()='Sales'] or //p[contains(text(),'Manage your sales')]
         driver.findElementByXPath("//p[contains(text(),'Manage your sales')]").click();
         
		//Click tasks tab - //span[text()='Tasks']
         driver.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@title='Tasks']/span"));
         //driver.findElementByXPath("//span[text()='Tasks']").click();
         
		//Click on tasks dd and select recently viewed option - //a[@title='Select List View'], //span[text()='Recently Viewed']
         driver.findElementByXPath("//a[@title='Select List View']").click();
         driver.findElementByXPath("//ul//span[text()='Recently Viewed']").click();
         
		//first row dropdown selection - //a[@title="Show 4 more actions"]
         driver.findElementByXPath("//a[@title='Show 13 more actions']").click();
         
        //delete - //a[@title="Delete"]
         driver.findElementByXPath("//a[@title='Delete']").click();
         
		//delete pop-up yes - //button[@title="Delete"]
         driver.findElementByXPath("//button[@title='Delete']").click();
         
		//verify task deleted - //div[@data-aura-class='forceToastMessage'], //div[@class='toastContent slds-notify__content']
         WebElement deletemessage=wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@data-aura-class='forceToastMessage']")));
        
         deletemessage.click();
        String expectedtext="Email deleted";
        System.out.println(deletemessage.getText());
        
        if(deletemessage.getText().contains(expectedtext)) {
        	System.out.println("Test Pass");
        }else {
        	System.out.println("Test Fail");
        }
		//close window
        driver.close();
        
	}
}
