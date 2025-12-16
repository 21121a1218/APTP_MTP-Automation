package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	 WebDriver driver;
	    WebDriverWait wait;
	    public CartPage(WebDriver driver) {
	         this.driver = driver;
	         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	         PageFactory.initElements(driver, this);
	     }
	
	@FindBy(xpath="(//div[@class='cx-product-info row']//div//a//h2)[2]") WebElement nameoncartpage;
	
	public String cartpageValidation() {
		WebElement oncartname=wait.until(ExpectedConditions.visibilityOf(nameoncartpage));
    	return oncartname.getText(); 
	}
		    
	}

