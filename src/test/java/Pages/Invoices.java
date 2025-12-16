package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Invoices {
	WebDriver driver;
    WebDriverWait wait;
    public Invoices(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }
    @FindBy(xpath="//a[normalize-space()='Invoices']") WebElement invoices;
    @FindBy(xpath="//cdk-accordion-item[@id='accordion-header-0']//button[@class='accordion-header']") WebElement past;
    @FindBy(xpath="//mat-tab-body/div[@class='mat-tab-body-content ng-tns-c297-6 ng-trigger ng-trigger-translateTab']/div[@class='tab-body mt-4 ng-star-inserted']/cdk-accordion[@class='accordion']/cdk-accordion-item[@id='accordion-header-0']/div[@class='accordion-content']/div[@class='feature-content ng-star-inserted']/cx-due-invoices/div[2]") WebElement pastinvoice;
    @FindBy(xpath="//button[@class='accordion-header collapsed']") WebElement pastclose;
    @FindBy(xpath="//cdk-accordion-item[@id='accordion-header-1']//button[@class='accordion-header']") WebElement regular;
    @FindBy(xpath="//p[normalize-space()='No due invoices found!']") WebElement regulardata;
    @FindBy(xpath="//button[@class='accordion-header collapsed']") WebElement closeregular;
    @FindBy(xpath="//*[@id=\"mat-tab-label-0-1\"]") WebElement completed;
    @FindBy(xpath="//*[@id=\"mat-input-0\"]") WebElement calender1;
    @FindBy(xpath="//*[@id=\"mat-input-1\"]") WebElement calender2;
    @FindBy(xpath="//button[@aria-label='Previous month']") WebElement goback;
    @FindBy(xpath="//div[normalize-space()='1']") WebElement date;
    @FindBy(xpath="//button[normalize-space()='APPLY']") WebElement apply;
    @FindBy(xpath="(//div[@class='completed-invoice-detail row ng-star-inserted'])[1]") WebElement completdData;
   public void inovices()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(invoices)).click();
   }
   public void clickpast()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(past)).click();
   }
   public boolean pastdata()
   {
	   return wait.until(ExpectedConditions.elementToBeClickable(pastinvoice)).isDisplayed();
   }
   public void colsepast()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(pastclose)).click();
   }
   public void clickregular()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(regular)).click();
   }
   public boolean regulradata()
   {
	   return wait.until(ExpectedConditions.elementToBeClickable(regulardata)).isDisplayed();
   }
   public void colseregular()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(closeregular)).click();
   }
   public void clickcompleted()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(completed)).click();
   }
   public void date1()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(calender1)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(goback)).click();
   }
   public void selectdate1()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(date)).click();
   }
   public void date2()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(calender2)).click();
   }
   public void selectdate2()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(date)).click();
   }
   public void Apply()
   {
	    wait.until(ExpectedConditions.elementToBeClickable(apply)).click();
   }
   public boolean CompletdData()
   {
	    return wait.until(ExpectedConditions.elementToBeClickable(completdData)).isDisplayed();
   }
}

