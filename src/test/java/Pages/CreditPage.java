package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseTest;

public class CreditPage extends BaseTest{
	WebDriver driver;
    WebDriverWait wait;
    public CreditPage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }
  
  //span[normalize-space()='My Account']
  //input[@id='addFundsInputRef']
  //input[@id='mat-input-1']
  //button[normalize-space()='Add Funds']
    @FindBy(xpath="//span[normalize-space()='My Account']") WebElement myaccounts;
    @FindBy(xpath="//a[normalize-space()='My Credits']") WebElement creditpage;
    @FindBy(xpath="//input[@id='addFundsInputRef']") WebElement paymentamt;
    @FindBy(xpath="//input[@id='mat-input-1']") WebElement TDSamt;
    @FindBy(xpath="//button[normalize-space()='Add Funds']") WebElement addfunds;
    @FindBy(xpath="//h4[normalize-space()='Add Funds']") WebElement simpleclick;
    
    public void creditpage()
    {
    	WebElement account=wait.until(ExpectedConditions.visibilityOf(myaccounts));
    	account.click();
    	WebElement creditPage=wait.until(ExpectedConditions.visibilityOf(creditpage));
    	creditPage.click();
    }
    public void addfund(String amt)
    {
    	WebElement amount=wait.until(ExpectedConditions.visibilityOf(paymentamt));
    	amount.sendKeys(amt);
    }
    public void addtds(String amt) throws InterruptedException
    {
    	WebElement amount=wait.until(ExpectedConditions.visibilityOf(TDSamt));
    	amount.sendKeys(amt);
    	WebElement Click=wait.until(ExpectedConditions.visibilityOf(simpleclick));
    	Click.click();
    	Click.click();
    	Thread.sleep(3000);
    }
    public void addfunds()
    {
    	WebElement btn=wait.until(ExpectedConditions.visibilityOf(addfunds));
    	btn.click();
    }
    
}
