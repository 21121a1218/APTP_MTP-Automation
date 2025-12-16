package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentHistory {

	WebDriver driver;
    WebDriverWait wait;
    public PaymentHistory(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }

    @FindBy(xpath="//span[normalize-space()='My Account']") WebElement myacnt;
    @FindBy(xpath="//a[normalize-space()='Payment History']") WebElement paymenthistory;
    
    public void paymenthistory()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(myacnt)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(paymenthistory)).click();
    }
    
}
