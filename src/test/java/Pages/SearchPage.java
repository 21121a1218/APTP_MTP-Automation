package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
		 WebDriver driver;
		    WebDriverWait wait;
		    public SearchPage(WebDriver driver) {
		         this.driver = driver;
		         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		         PageFactory.initElements(driver, this);
		     }
		    @FindBy(xpath="//input[@placeholder='Search']") WebElement searchbar;
		    
		    @FindBy(xpath="//button[normalize-space()='Search']") WebElement searchbtn;
		    
		    @FindBy(xpath="//body//cx-root//cx-product-list-item[1]//div//div[2]//a") WebElement productname;
		    
		    @FindBy(xpath="//div[@class='change-view flex-fill']//a[2]") WebElement gridview;
		    
		    @FindBy(xpath="(//cx-media//img[@class='ng-star-inserted'])[9]") WebElement clickinimg;
		    
		    @FindBy(xpath="(//span[@class='info'][1])[1]") WebElement stockinfo;
		    
		    
		    
		    public void search(String tirename) throws InterruptedException
		    {
		    	Thread.sleep(4000);
		    	WebElement searchinput=wait.until(ExpectedConditions.visibilityOf(searchbar));
		    	searchinput.clear();
		    	searchinput.sendKeys(tirename);   	
		    }
		    public void clicksearch()
		    {
		    	wait.until(ExpectedConditions.visibilityOf(searchbtn)).click(); 
		    }
		    public String plpproductname() throws InterruptedException
		    {
		    	Thread.sleep(3000);
		    	WebElement plpname=wait.until(ExpectedConditions.visibilityOf(productname));
		    	String name=plpname.getText();	
		    	return name;
		    }
		    public void gridView()
		    {
		    	WebElement grid=wait.until(ExpectedConditions.visibilityOf(gridview));
		    	grid.click();
		    }
		    public boolean gridviewenabled()
		    {
		    	WebElement grid=wait.until(ExpectedConditions.visibilityOf(gridview));
		    	boolean result=grid.isEnabled();
		    	return result;
		    }
		    public boolean resultsExist()
		    {
		    	WebElement plpname=wait.until(ExpectedConditions.visibilityOf(productname));
		    	boolean result=plpname.isDisplayed();
		    	return result;
		    }
		    public void clickontire()
		    {
		    	
		    	WebElement img=wait.until(ExpectedConditions.visibilityOf(productname));
		    	img.click();
		    }
		    public boolean stockinfo() {
		        WebElement info = wait.until(ExpectedConditions.visibilityOf(stockinfo));
		        String text = info.getText();

		        return text.contains("No Stock")
		            || text.contains("Stock Available")
		            || text.contains("Low Stock");
		    }
}
