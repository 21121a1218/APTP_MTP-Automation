package Pages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Featuresandbenfitspage {
	WebDriver driver;
    WebDriverWait wait;
    public Featuresandbenfitspage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }
    
    @FindBy(xpath="//button[@class='accordion-header']") WebElement featuresbtn;
    @FindBy(xpath="//div[@class='headerDesc']//div") WebElement featuresverify;
    
    public void featureopen()
    {
    	WebElement cLick=wait.until(ExpectedConditions.elementToBeClickable(featuresbtn));
    	System.out.println(cLick.isDisplayed());
    	Actions actions = new Actions(driver);
    	actions.moveToElement(featuresbtn).click().perform();

    }
     public boolean verifyfeatures()
     {
    	 return wait.until(ExpectedConditions.visibilityOf(featuresverify)).isDisplayed();
     }

}
