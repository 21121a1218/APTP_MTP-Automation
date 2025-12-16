package Pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class favoritespage {
	WebDriver driver;
    WebDriverWait wait;
    public favoritespage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }
    
    @FindBy(xpath="(//button[@class='link cx-action-link add-to-wishlist-icon ng-star-inserted'])[1]") WebElement favicon1;
    @FindBy(xpath="//body[1]/cx-root[1]/cx-storefront[1]/main[1]/cx-page-layout[1]/cx-page-slot[2]/cx-product-list[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/cx-product-scroll[1]/div[1]/cx-product-list-item[1]/div[1]/div[2]/div[1]/cx-add-to-wishlist[1]/div[1]/button[1]") WebElement favicon2;
    @FindBy(xpath="//button[@class='link cx-action-link wishlist-icon header-wishlist']") WebElement favaritespage;
    @FindBy(xpath="//a[@class='cx-product-name']//h2") List <WebElement> tirenames;
    
    public void faviconclick1()
    {
    	wait.until(ExpectedConditions.visibilityOf(favicon1)).click();
    }
    public boolean faviconclick2()
    {
    	return wait.until(ExpectedConditions.visibilityOf(favicon2)).isDisplayed();
    	
    }
    public void redirectfavorites()
    {
    	wait.until(ExpectedConditions.visibilityOf(favaritespage)).click();
    }
    public boolean verify(String tireName) {
    	List <WebElement> tirename=wait.until(ExpectedConditions.visibilityOfAllElements(tirenames));
        for (WebElement tire : tirenames) {
            if (!tire.getText().contains(tireName)) {
                return false;
            }
        }
        return true;
    }
 
}
