package bootcampdoubts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateFollowupTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        
        //To pick the value from long drop down - create an object for wait
        //WebDriverWait wait = new WebDriverWait(driver, 200);
        
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        WebElement eleUserName = driver.findElementById("username");
        eleUserName.sendKeys("cypress@testleaf.com");

        WebElement elePassword = driver.findElementById("password");
        elePassword.sendKeys("Selbootcamp@123");
        
        driver.findElementById("Login").click();
        
        driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
        Thread.sleep(10000);
        
        driver.findElementByXPath("//button[text()='View All']").click();
               
        driver.findElementByXPath("//p[text ()='Content']").click();     
              
         driver.findElementByXPath("(//span[text ()='View All'])[2]").click();
         
         WebElement newSplitview = driver.findElementByXPath("//div[@title='Display as Split View']//following::span[text()='Display as Split View']");
         driver.executeScript("arguments[0].click();", newSplitview);
         
         WebElement clickTable = driver.findElementByXPath("//span[text()='Table']");
         driver.executeScript("arguments[0].click();", clickTable);
         
         WebElement firstResult = driver.findElementByXPath("//tbody/tr[1]/td[7]/span//div/a/lightning-icon");
         driver.executeScript("arguments[0].click();", firstResult);
         
         
                
         
         WebElement createFollowuptask = driver.findElementByXPath("//a[@title='Create Follow-Up Task']");
         driver.executeScript("arguments[0].click();", createFollowuptask);
         
         
         //driver.findElementByXPath("//label[text()='Subject']").click();
         
        
         
                 //WebElement selectCall = driver.findElementByXPath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left']/following::lightning-base-combobox-formatted-text[@title='Call']");
//         WebElement selectCall = driver.findElementByXPath("//span[@title='Call']");
//         driver.executeScript("arguments[0].click();", selectCall);
//         driver.findElementByXPath("//a[@aria-label='Related To—Current Selection: Accounts, Pick an object']").click();
         
                  
                  //driver.findElementByXPath("//a[@class='select'][1]").click();
                 // WebElement newPriority = driver.findElementByXPath("//div/following::span[text()='Priority']/following::a[text()='High'][1]");
                 // driver.executeScript("arguments[0].click();", newPriority);
                  driver.executeScript("arguments[0].click();", driver.findElementByXPath("(//span[text()='Priority'])[2]//following::div[@data-aura-class='uiPopupTrigger']/div/div"));
                  WebElement newPriority = driver.findElementByXPath("//a[text()='High']");
                  driver.executeScript("arguments[0].click();", newPriority);
                  
                  WebElement selectSubject = driver.findElementByXPath("//label[text()='Subject']");
                  driver.executeScript("arguments[0].click();", selectSubject);
                                    
                  //driver.findElementByXPath("//a[@class='select'][1]").click();
                  //WebElement newStatus = driver.findElementByXPath("//a[@title='In Progress']");
                 // driver.executeScript("arguments[0].click();", newStatus);
         
              
        
 	}
         
           
	}


