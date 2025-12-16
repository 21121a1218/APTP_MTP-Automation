package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myaccount {
	WebDriver driver;
    WebDriverWait wait;
    public Myaccount(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }
    @FindBy(xpath="//span[normalize-space()='My Account']") WebElement myacnt;
    @FindBy(xpath="//a[normalize-space()='Account Summary']") WebElement actsummary;
    @FindBy(xpath="//div[@class='credit-limit-msg']") WebElement creditlimtmsg;
    @FindBy(xpath="(//mat-list[@role='list'])[1]") WebElement payerdeatils;
    @FindBy(xpath="(//mat-list[@role='list'])[2]") WebElement dueinfo;
    @FindBy(xpath="//div[contains(text(),'Account Statement')]") WebElement actstmt;
   // @FindBy(xpath="//input[@id='mat-input-9']") WebElement calender1;
    //@FindBy(xpath="//input[@id='mat-input-10']") WebElement calender2;
    @FindBy(xpath="//div[@class='filter-by']") WebElement filtertxt;
    @FindBy(xpath=" //button[normalize-space()='Download']") WebElement downloadbytn;
 
    
    public void accountsummaryredirection()
    {
    	WebElement act=wait.until(ExpectedConditions.elementToBeClickable(myacnt));
    	act.click();
    	WebElement actsmr=wait.until(ExpectedConditions.elementToBeClickable(actsummary));
    	actsmr.click();
    }
    public boolean validateaccountsummary()
    {
    	WebElement creditmsg=wait.until(ExpectedConditions.visibilityOf(creditlimtmsg));
    	WebElement payerdtls=wait.until(ExpectedConditions.visibilityOf(payerdeatils));
    	WebElement Dueinfo=wait.until(ExpectedConditions.visibilityOf(dueinfo));
    	if(!creditmsg.isDisplayed() && payerdtls.isDisplayed() && Dueinfo.isDisplayed() == true)
    	{
    		return false;
    	}
    	return true;
    }
	public void switchactsmt()
	{
		WebElement smt=wait.until(ExpectedConditions.elementToBeClickable(actstmt));
    	smt.click();
	}
	public boolean actsmtvalidation()
	{
		WebElement txt1=wait.until(ExpectedConditions.visibilityOf(filtertxt));
    	//WebElement txt2=wait.until(ExpectedConditions.visibilityOf(calender1));
    	//WebElement txt3=wait.until(ExpectedConditions.visibilityOf(calender2));
    	WebElement txt4=wait.until(ExpectedConditions.visibilityOf(downloadbytn));
    	if(!txt1.isDisplayed() &&  txt4.isDisplayed() == true)
    	{
    		return false;
    	}
    	return true;
	}
	
}
