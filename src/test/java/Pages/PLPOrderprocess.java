package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseTest;

public class PLPOrderprocess {
		 WebDriver driver;
		    WebDriverWait wait;
		    public PLPOrderprocess(WebDriver driver) {
		         this.driver = driver;
		         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		         PageFactory.initElements(driver, this);
		     }
		    @FindBy(xpath="//input[@placeholder='Search']") WebElement searchbar;
		    
		    @FindBy(xpath="//button[normalize-space()='Search']") WebElement searchbtn;
		    
		    @FindBy(xpath="(//cx-media[@format='product'])[1]") WebElement img1;
		    
		    @FindBy(xpath="//body//cx-root//cx-product-list-item[1]//div//div[2]//a") WebElement productname;
		    
		    @FindBy(xpath="(//div[@class='cx-product-price'])[1]") WebElement plpprice;
		    
		    @FindBy(xpath="(//input[@aria-label='Quantity'])[1]") WebElement qtycheck;
		    
		    @FindBy(xpath="(//span[contains(text(),'Add to cart')])[1]") WebElement addtocart;	
		    
		    @FindBy(xpath="//mat-select[@id='mat-select-0']") WebElement soldto;
		    
		    @FindBy(xpath="//mat-option[@id='mat-option-2']//span") WebElement soldtos;
		    
		    @FindBy(xpath="(//mat-form-field//div//div//div//mat-select)[2]") WebElement shippedto;
		    
		    @FindBy(xpath="//input[@type='radio' and @name='stpId'][1]") WebElement shipto;
		  
		    @FindBy(xpath="//span[@class='mat-button-wrapper']") WebElement conTinue; 
		    
		   // @FindBy(xpath="(//div[@role='listbox'])[2]") List <WebElement> shiptos;
		    
		    @FindBy(xpath="//div[@class='cx-dialog-title modal-title']") WebElement cartpopup;
		    
		    @FindBy(xpath="//div[@class='cx-compact row ng-star-inserted']//div//a//cx-media//img") WebElement imgpopup;
		    
		    @FindBy(xpath="//div[@class='cx-product-info']//div//a//h2") WebElement popname;
		    
		    @FindBy(xpath="//div[@class='cx-value ng-star-inserted']") WebElement popprice;
		    
		    @FindBy(xpath="//div[@class='cx-value']//input[@aria-label='Quantity']") WebElement popqty;
		    
		    @FindBy(xpath="//a[normalize-space()='view cart']") WebElement viewcartclick;
		    
		    @FindBy(xpath="//div[@class='credit-limit ng-star-inserted']//span") WebElement creditlimit;
		    
		    @FindBy(xpath="//div[@class='col-6 cx-summary-amount totalPrice price']") WebElement cartpagetltamount;
		    
		    @FindBy(xpath="(//div[@class='cx-product-info row']//div//a//h2)[2]") WebElement nameoncartpage;
		    
		    @FindBy(xpath="(//cx-cart-item//div[@class='cx-value ng-star-inserted'])[2]") WebElement priceoncartpage;
		    
		    @FindBy(xpath="(//div[@class='col-4 cx-image-container']//img)[2]") WebElement cartpageimg;
		    
		    @FindBy(xpath="(//input[@aria-label='Quantity'])[2]") WebElement qtyoncart;
		  
		    @FindBy(xpath="//div[@class='cx-summary-row deductions-label']") WebElement totaltaxes;
		  
		    @FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c226-14']//input[@id='mat-input-10']") WebElement calender;
		  
		    @FindBy(xpath="//div[@class='mat-calendar-body-cell-content mat-focus-indicator']") List <WebElement> dates;
		    
		    @FindBy(xpath="//div[@class='cx-summary-row deductions-label ng-star-inserted']") WebElement discount;

		    @FindBy(xpath="//button[normalize-space()='Proceed to Checkout']") WebElement checkoutbtn;
		    
		    @FindBy(xpath="(//div[@class='col-12 col-sm-6 col-md-6'])[1]") WebElement SHIPPINGADDRESS;
		    
		    @FindBy(xpath="(//div[@class='col-12 col-sm-6 col-md-6'])[2]") WebElement PAYERADDRESS;
		    
		    @FindBy(xpath="//div[@class='col-4 cx-image-container']//cx-media[@class='is-initialized']//img") WebElement orderpageimg;
		    
		    @FindBy(xpath="//div[@class='cx-name col-10 ng-star-inserted']//a") WebElement orderpagename;
		    
		    @FindBy(xpath="//div[@class='cx-value ng-star-inserted']") WebElement oderpageprice;
		    
		    @FindBy(xpath="//div[@class='cx-quantity col-md-9 col-lg-9 col-sm-12 col-12']") WebElement orderpageqty;
		    
		    @FindBy(xpath="//div[@class='cx-summary-row cx-summary-total']") WebElement oderpagetltprice;
		    
		    @FindBy(xpath="//div[@class='cx-summary-row deductions-label']") WebElement oderpagetlttaxes;
		    
		    @FindBy(xpath="//cx-place-order//button") WebElement placeorder;
		    
		    @FindBy(xpath="//div[@class='cx-dialog-title modal-title ng-star-inserted']") WebElement thankumsg;
		    
		    @FindBy(xpath="//cx-media[@format='cartIcon']//img") WebElement confimg;
		    
		    @FindBy(xpath="//div[@class='cx-name col-10 ng-star-inserted']//a//h2") WebElement confname;
		    
		    @FindBy(xpath="//div[@class='cx-quantity']") WebElement confqty;
		    
		    @FindBy(xpath="//div[@class='cx-value ng-star-inserted']") WebElement confprice;
		    
		    @FindBy(xpath="//div//cx-order-summary") WebElement conftltprice;
		    
		    @FindBy(xpath="//div[@class='shipping-details']") WebElement confshippingdetails;
		    
		    public void search(String tirename) throws InterruptedException
		    {
		    	Thread.sleep(3000);
		    	WebElement Soldto=wait.until(ExpectedConditions.visibilityOf(soldto));
		    	Soldto.click();
		    	/*List <WebElement> SolDto=wait.until(ExpectedConditions.visibilityOfAllElements(soldtos));
		    	for (int i=0;i<SolDto.size();i++)
		    	{
		    		SolDto.get(1).click();
		    	}*/
		    	//WebElement Shipto=wait.until(ExpectedConditions.visibilityOf(shipto));
		    	//Select shipedto=new Select(Shipto);
		    	//shipedto.selectByIndex(0);
		    	soldtos.click();
		    	shippedto.click();
		    	shipto.click();
		    	Thread.sleep(2000);
		    	WebElement conTInue=wait.until(ExpectedConditions.elementToBeClickable(conTinue));
		    	conTInue.click();
		    	WebElement searchinput=wait.until(ExpectedConditions.visibilityOf(searchbar));
		    	searchinput.clear();
		    	searchinput.sendKeys(tirename);
		    	wait.until(ExpectedConditions.visibilityOf(searchbtn)).click();
		    	
		    }
		    public boolean plppagevalidations()
		    {
		    	WebElement plpimg=wait.until(ExpectedConditions.visibilityOf(img1));
		    	WebElement plpname=wait.until(ExpectedConditions.visibilityOf(productname));
		    	if(!plpimg.isDisplayed() && plpname.isDisplayed()==true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public boolean plpppricevalidation()
		    {
		    	WebElement plPprice=wait.until(ExpectedConditions.visibilityOf(plpprice));
		    	if(!plPprice.isDisplayed()==true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public void plppaddqty(String count)
		    {
		    	WebElement plPqty=wait.until(ExpectedConditions.visibilityOf(qtycheck));
		    	plPqty.clear();
		    	plPqty.sendKeys(count);	    		    	
		    }
		    public void addtocart()
		    {
		    	WebElement addcart=wait.until(ExpectedConditions.visibilityOf(addtocart));
		    	addcart.click();
		    }
		    public boolean cartpopupvalidation()
		    {
		    	WebElement Imgpopup=wait.until(ExpectedConditions.visibilityOf(imgpopup));
		    	WebElement Popname=wait.until(ExpectedConditions.visibilityOf(popname));
		    	WebElement Popprice=wait.until(ExpectedConditions.visibilityOf(popprice));
		    	WebElement Popqty=wait.until(ExpectedConditions.visibilityOf(popqty));
		    	if(!Imgpopup.isDisplayed() && Popname.isDisplayed() && Popprice.isDisplayed() && Popqty.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public void viewcartbutton()
		    {
		    	WebElement Viewcartclick=wait.until(ExpectedConditions.visibilityOf(viewcartclick));	
		    	Viewcartclick.click();
		    }
		    public boolean creditlimitdisplayed()
		    {
		    	wait.until(ExpectedConditions.visibilityOf(creditlimit));	
		    	if(!creditlimit.isDisplayed())
		    	{
		    		return false;
		    	}
		    	return true;	    	
		    }
		    public boolean verifyCreditLimitAndProceed() 
		    {
		    	String creditText=wait.until(ExpectedConditions.visibilityOf(creditlimit)).getText();
		        String creditValue = creditText.replaceAll("[^\\d.]", ""); // Removes "Credit Limit Available: RM"
		        String toatlorderText=wait.until(ExpectedConditions.visibilityOf(cartpagetltamount)).getText();
		        String totalValue = toatlorderText.replaceAll("[^\\d.]", ""); // Removes "Credit Limit Available: RM"

		        double availableCredit = Double.parseDouble(creditValue);
		        double totalOrderPrice = Double.parseDouble(totalValue);
		        if (availableCredit < totalOrderPrice) {
		        	System.out.println("Insufficient credit! Available: " + availableCredit + ", Required: " + totalOrderPrice);
                  return false;
		        } 
		        return true;
		    }
		    public boolean cartpagevalidation()
		    {
		    	WebElement cartpageImg=wait.until(ExpectedConditions.visibilityOf(cartpageimg));
		    	WebElement oncartname=wait.until(ExpectedConditions.visibilityOf(nameoncartpage));
		    	WebElement oncartprice=wait.until(ExpectedConditions.visibilityOf(priceoncartpage));
		    	WebElement Qtyoncart=wait.until(ExpectedConditions.visibilityOf(qtyoncart));
		    	if(!cartpageImg.isDisplayed() && oncartname.isDisplayed() && oncartprice.isDisplayed() && Qtyoncart.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public boolean cartpagepricevalidation()
		    {
		    	WebElement cartpagetltAmt=wait.until(ExpectedConditions.visibilityOf(cartpagetltamount));
		    	WebElement Totaltaxes=wait.until(ExpectedConditions.visibilityOf(totaltaxes));
		    	if(!cartpagetltAmt.isDisplayed() && Totaltaxes.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public void selectdeliverydate(int j)
		    {
		    	WebElement calend=wait.until(ExpectedConditions.visibilityOf(calender));
		    	calend.click();
		    	 List <WebElement> Dates=wait.until(ExpectedConditions.visibilityOfAllElements(dates));
		    	 for(int i=0;i<Dates.size();i++)
		    	 {
		    		 Dates.get(j).click();
		    	 }	    	
		    }
		    public boolean verifydeliverydate(String j)
		    {
		    	WebElement calend=wait.until(ExpectedConditions.visibilityOf(calender));   	
		    	 String selecteddate=calend.getText();
		    	 if(selecteddate.contains("j"))
		    	 {
		    		 return false;
		    	 }
		       return true;
		    }
		    public void clickcheckout()
		    {
                   wait.until(ExpectedConditions.visibilityOf(checkoutbtn)).click(); 			    	
		    }
		    public boolean addressvalidation()
		    {
		    	WebElement shippingadrs=wait.until(ExpectedConditions.visibilityOf(SHIPPINGADDRESS));
		    	WebElement payeraddress=wait.until(ExpectedConditions.visibilityOf(PAYERADDRESS));
		    	if(!shippingadrs.isDisplayed() && payeraddress.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public boolean orderpagevalidation()
		    {
		    	WebElement orderpageImg=wait.until(ExpectedConditions.visibilityOf(orderpageimg));
		    	WebElement onordername=wait.until(ExpectedConditions.visibilityOf(orderpagename));
		    	WebElement onorderprice=wait.until(ExpectedConditions.visibilityOf(oderpageprice));
		    	WebElement Qtyonorder=wait.until(ExpectedConditions.visibilityOf(orderpageqty));
		    	if(!orderpageImg.isDisplayed() && onordername.isDisplayed() && onorderprice.isDisplayed() && Qtyonorder.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public boolean orderpagepricevalidation()
		    {
		    	WebElement oderpagetltPrice=wait.until(ExpectedConditions.visibilityOf(oderpagetltprice));
		    	WebElement oderpagetltTaxes=wait.until(ExpectedConditions.visibilityOf(oderpagetlttaxes));
		    	if(!oderpagetltPrice.isDisplayed() && oderpagetltTaxes.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public void orderplace() {
		        try {
		            WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOf(placeorder));
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", placeOrderButton);

		            wait.until(ExpectedConditions.invisibilityOfElementLocated(
		                By.cssSelector(".cx-spinner, .cdk-overlay-backdrop, .block-ui-overlay, .loading-mask")));

		            waitForAngularStable();

		            try {
		                wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
		            } catch (ElementClickInterceptedException e) {
		                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);
		            }
		        } catch (Exception e) {
		            throw new RuntimeException("Failed to click 'Place Order': " + e.getMessage(), e);
		        }
		    }

		    private void waitForAngularStable() {
		        try {
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            for (int i = 0; i < 10; i++) {
		                Boolean isStable = (Boolean) js.executeScript(
		                    "return (window.getAllAngularTestabilities && " +
		                    "window.getAllAngularTestabilities().every(x => x.isStable()));");
		                if (Boolean.TRUE.equals(isStable)) return;
		                Thread.sleep(300);
		            }
		        } catch (Exception ignored) {}
		    }

		    public String ordersuccesfullmessage()
		    {
		    	String msg=wait.until(ExpectedConditions.visibilityOf(thankumsg)).getText();	
		    	return msg;
		    }
		    public boolean ConfrimValidations()
		    {
		    	WebElement confImg=wait.until(ExpectedConditions.visibilityOf(confimg));
		    	WebElement confName=wait.until(ExpectedConditions.visibilityOf(confname));
		    	WebElement confPrice=wait.until(ExpectedConditions.visibilityOf(confprice));
		    	WebElement Qtyoconfr=wait.until(ExpectedConditions.visibilityOf(confqty));
		    	if(!confImg.isDisplayed() && confName.isDisplayed() && confPrice.isDisplayed() && Qtyoconfr.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public boolean confrimpricevalidation()
		    {
		    	WebElement Conftltprice=wait.until(ExpectedConditions.visibilityOf(conftltprice));
		    	if(!Conftltprice.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }
		    public boolean Confshippingdetails()
		    {
		    	WebElement confShippingdetails=wait.until(ExpectedConditions.visibilityOf(confshippingdetails));
		    	if(!confShippingdetails.isDisplayed() == true)
		    	{
		    		return false;
		    	}
		    	return true;		    	
		    }		    
	}


