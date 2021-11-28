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

public class CreateFollowup {

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
        elePassword.sendKeys("Bootcamp@123");
        
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
         
         WebElement createFollowup = driver.findElementByXPath("//a[@title='Create Follow-Up Event']");
         driver.executeScript("arguments[0].click();", createFollowup);
         
         
         //driver.findElementByXPath("//label[text()='Subject']").click();
         
         WebElement selectSubject = driver.findElementByXPath("//label[text()='Subject']");
         driver.executeScript("arguments[0].click();", selectSubject);
         
         //sendKeys("meeting");
         WebElement selectMeeting = driver.findElementByXPath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left']/lightning-base-combobox-item[3]");
         driver.executeScript("arguments[0].click();", selectMeeting);
         
         
         //WebElement clickRelatedto = driver.findElementByXPath("//a[@aria-label='Related To—Current Selection: Accounts, Pick an object']");
         //driver.executeScript("arguments[0].click();", clickRelatedto);
         driver.findElementByXPath("//a[@aria-label='Related To—Current Selection: Accounts, Pick an object']").click();
         
         
         //To pick the value from long drop down
         
         //WebElement actual = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span/img[@title='Products']")))).click();
         //WebElement selectProduct = driver.findElementByXPath("//span/img[@title='Products']");
         //driver.executeScript("arguments[0].click();", actual);
         
         //wait(driver, 5).until(ExpectedConditions.visibility_of_element_located(By.XPATH,'//*[@title="Products"]')).click();
         
         //driver.findElementByXPath("//div[@class='autocompleteWrapper slds-grow']//input[@role='combobox'])[3]").click();
         //wait(driver,5).until(EC.visibility_of_element_located((By.XPATH, '//input[@title="Search Products"]'))).click();
         //driver.findElementByXPath("//input[@title='Search Products']").click();
         
         
         //driver.findElementByXPath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']").click();
 		//JavascriptExecutor js=(JavascriptExecutor)driver;
 		//driver.findElementByXPath("(//a[@class='entityMenuTrigger slds-button slds-button--icon slds-shrink-none slds-m-vertical--xxx-small slds-grid slds-grid_align-center'])[3]").click();
 		//js.executeScript("javascript:window.scrollBy(0,1000)");
 		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']"))).click();
         
         
         WebElement selectCalendar = driver.findElementByXPath("//lightning-datepicker[1]");
          WebElement selectNext = driver.findElementByXPath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
         //selectNext.click();
         //driver.executeScript("arguments[0].click();", selectNext);
          selectCalendar.clear();
         selectCalendar.sendKeys("Mar 5, 2021");
         
//         driver.findElementByXPath("//legend[text()='End']").click();
//         WebElement selectsecNext = driver.findElementByXPath("//legend[text()='End']");
//         selectsecNext.click();
//        
//        selectCalendar.sendKeys("Mar 15, 2021");
         
        
 	}
         
           
	}