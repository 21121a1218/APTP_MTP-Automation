package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersPage {
	 WebDriver driver;
	    WebDriverWait wait;
	  

     @FindBy(xpath="//a[normalize-space()='Orders']") WebElement orders;
     
     @FindBy(xpath="//cdk-accordion-item[@id='accordion-header-0']//button[@class='accordion-header']") WebElement byOrderNumber;
  
     @FindBy(xpath="//input[@id='mat-input-2']") WebElement searchbyOrdernumber;
     
     @FindBy(xpath="/html/body/cx-root/cx-storefront/main/cx-page-layout/cx-page-slot/cx-order-history/section/div/div[1]/cx-order-history-search/form/div/button[1]") WebElement apply;
     
     @FindBy(xpath="//div[@class='row quantity-box col-lg-6 order-detail-link']") WebElement orderdetails;
     
     @FindBy(xpath="//div[@class='col-6 col-lg-9 order-content'][1]") WebElement ordernumber;
     
     @FindBy(xpath="//div[@class='col-6 col-lg-3 status-content']") WebElement orderstatus;
     
     @FindBy(xpath="//div[@class='col-12 col-lg-9 row order-reference']") WebElement orderrefnum;
     
     @FindBy(xpath="//div[@class='row date-time']") WebElement orderdate;
     
     @FindBy(xpath="//div[@class='row sold-to-content']") WebElement ordersoldto;
     
     @FindBy(xpath="//div[@class='row ship-to-content']") WebElement ordershipto;
     
     @FindBy(xpath="//div[@class='total-tyres-orderd col-custom'][1]") WebElement totalorderded;
     
     @FindBy(xpath="//div[@class='total-tyres-orderd col-custom'][2]") WebElement totalconfrimed;
     
     @FindBy(xpath="//div[@class='total-tyres-shipped col-custom']") WebElement totalshipped;
     
     @FindBy(xpath="//div[@class='total-tyres-balance col-custom']") WebElement backorder;
     
     @FindBy(xpath="//div[@class='total-tyres-cancelled col-custom']") WebElement totalcancelled;
     
     @FindBy(xpath="//div[@class='row material-code ng-star-inserted']") WebElement materialcode;
     
     @FindBy(xpath="//div[@class='row descripation-code ng-star-inserted']") WebElement desc;
     
     @FindBy(xpath="//div[@class='row creation-code ng-star-inserted']") WebElement creationdate;
     
     @FindBy(xpath="//div[@class='col-3 orderd-qty']") WebElement Orderedqty;
     
     @FindBy(xpath="//div[@class='col-3 shipped-qty']") WebElement shippededqty;
     
     @FindBy(xpath="//div[@class='col-3 balance-qty'][1]") WebElement balanceqty;
     
     @FindBy(xpath="//div[@class='rddAlign']") WebElement Rdd;
     
     @FindBy(xpath="//div[@class='accordion-content']//div[@class='ng-star-inserted']") WebElement byordernodetails;
     
     @FindBy(xpath="//cdk-accordion-item[@id='accordion-header-1']//button[@class='accordion-header']") WebElement byproduct;
     
     @FindBy(xpath="//div[@class='accordion-content']//div[@class='ng-star-inserted']") WebElement byproductdetails;
     
     @FindBy(xpath="//cdk-accordion-item[@id='accordion-header-2']//button[@class='accordion-header']") WebElement bybackorder;
     
     @FindBy(xpath="//div[@class='accordion-content']//div[@class='col-3 result-found']") WebElement bybackorderdetails;
     
     @FindBy(xpath="//button[@class='accordion-header collapsed']") WebElement collapse;
     
   
     
     
     public OrdersPage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         PageFactory.initElements(driver, this);
     }
     
     public void orders() throws InterruptedException
     {
    	wait.until(ExpectedConditions.elementToBeClickable(orders)).click();
     }
     
     public void byorder()
     {
    	 wait.until(ExpectedConditions.elementToBeClickable(byOrderNumber)).click();
     }
     
    /* public void clickonorder() {
    	    List<WebElement> orderlist = wait.until(ExpectedConditions.visibilityOfAllElements(Orderdetails));
    	    if (!orderlist.isEmpty()) {
    	        WebElement firstOrder = wait.until(ExpectedConditions.elementToBeClickable(orderlist.get(0)));
    	        firstOrder.click();
    	    } else {
    	        throw new RuntimeException("No orders found in the list!");
    	    }
    	}*/
     public void clickonorder()
     {
    	wait.until(ExpectedConditions.visibilityOf(orderdetails)).click();
     }

     public boolean verifybyorder(String orderno)
     {
    	 WebElement det=wait.until(ExpectedConditions.visibilityOf(byordernodetails));
    	 String details=det.getText();
    	 if(!details.contains(orderno) && det.isDisplayed())
    	 {
    		 return false;
    	 }
    	 return true;
     }
     public void closebyorderno() throws InterruptedException
     {
    	 Thread.sleep(3000);
    	 wait.until(ExpectedConditions.visibilityOf(collapse)).click();
     }
     public void closebyproduct() throws InterruptedException
     {
    	 Thread.sleep(3000);
    	 wait.until(ExpectedConditions.visibilityOf(collapse)).click();
     }
     public void closebybackorder() throws InterruptedException
     {
    	 Thread.sleep(3000);
    	 wait.until(ExpectedConditions.visibilityOf(bybackorder)).click();
     }
     public boolean ordernumber()
     {
    	 WebElement ordnum=wait.until(ExpectedConditions.visibilityOf(ordernumber));
    	 String number=ordnum.getText();
    	 System.out.println(number);
    	 return ordnum.isDisplayed();  	 
     }
     public boolean orderstatus()
     {
    	 WebElement ordsts=wait.until(ExpectedConditions.visibilityOf(orderstatus));
    	 String otp1=ordsts.getText();
    	 System.out.println(otp1);
    	 return ordsts.isDisplayed();  	 
     }
     public boolean orderrefnum()
     {
    	 WebElement ordrefnum=wait.until(ExpectedConditions.visibilityOf(orderrefnum));
    	 String otp2=ordrefnum.getText();
    	 System.out.println(otp2);
    	 return ordrefnum.isDisplayed();  	 
     }
     public boolean orderdate()
     {
    	 WebElement orddate=wait.until(ExpectedConditions.visibilityOf(orderdate));
    	 String otp3=orddate.getText();
    	 System.out.println(otp3);
    	 return orddate.isDisplayed();  	 
     }
     public boolean ordersoldto()
     {
    	 WebElement ordsoldto=wait.until(ExpectedConditions.visibilityOf(ordersoldto));
    	 String otp4=ordsoldto.getText();
    	 System.out.println(otp4);
    	 return ordsoldto.isDisplayed();  	 
     }
     public boolean ordershipto()
     {
    	 WebElement ordshipto=wait.until(ExpectedConditions.visibilityOf(ordershipto));
    	 String otp5=ordshipto.getText();
    	 System.out.println(otp5);
    	 return ordshipto.isDisplayed();  	 
     }
     public boolean totalorderded()
     {
    	 WebElement totalord=wait.until(ExpectedConditions.visibilityOf(totalorderded));
    	 String otp6=totalord.getText();
    	 System.out.println(otp6);
    	 return totalord.isDisplayed();  	 
     }
     public boolean totalshipped()
     {
    	 WebElement totalship=wait.until(ExpectedConditions.visibilityOf(totalshipped));
    	 String otp8=totalship.getText();
    	 System.out.println(otp8);
    	 return totalship.isDisplayed();  	 
     }
     public boolean totalconfrimed()
     {
    	 WebElement totalconf=wait.until(ExpectedConditions.visibilityOf(totalconfrimed));
    	 String otp7=totalconf.getText();
    	 System.out.println(otp7);
    	 return totalconf.isDisplayed();  	 
     }
     public boolean backorder()
     {
    	 WebElement backord=wait.until(ExpectedConditions.visibilityOf(backorder));
    	 String otp9=backord.getText();
    	 System.out.println(otp9);
    	 return backord.isDisplayed();  	 
     }
     public boolean totalcancelled()
     {
    	 WebElement totalcanc=wait.until(ExpectedConditions.visibilityOf(totalcancelled));
    	 String otp10=totalcanc.getText();
    	 System.out.println(otp10);
    	 return totalcanc.isDisplayed();  	 
     }
     public boolean materialcode()
     {
    	 WebElement matcode=wait.until(ExpectedConditions.visibilityOf(materialcode));
    	 String otp11=matcode.getText();
    	 System.out.println(otp11);
    	 return matcode.isDisplayed();  	 
     }
     public boolean description()
     {
    	 WebElement descript=wait.until(ExpectedConditions.visibilityOf(desc));
    	 String otp12=descript.getText();
    	 System.out.println(otp12);
    	 return descript.isDisplayed();  	 
     }
     public boolean shippededqty()
     {
    	 WebElement shippdqty=wait.until(ExpectedConditions.visibilityOf(shippededqty));
    	 String otp13=shippdqty.getText();
    	 System.out.println(otp13);
    	 return shippdqty.isDisplayed();  	 
     }
     public boolean creationdate()
     {
    	 WebElement creationdt=wait.until(ExpectedConditions.visibilityOf(creationdate));
    	 String otp14=creationdt.getText();
    	 System.out.println(otp14);
    	 return creationdt.isDisplayed();  	 
     }
     public boolean Orderedqty()
     {
    	 WebElement Orderqty=wait.until(ExpectedConditions.visibilityOf(Orderedqty));
    	 String otp15=Orderqty.getText();
    	 System.out.println(otp15);
    	 return Orderqty.isDisplayed();  	 
     }
     public boolean balanceqty()
     {
    	 WebElement blceqty=wait.until(ExpectedConditions.visibilityOf(balanceqty));
    	 String otp16=blceqty.getText();
    	 System.out.println(otp16);
    	 return blceqty.isDisplayed();  	 
     }
     public boolean Rdd() {
    	    try {
    	        WebElement rdd = wait.until(ExpectedConditions.visibilityOf(Rdd));
    	        String text = rdd.getText();
    	        System.out.println("RDD Found: " + text);
    	        return true;
    	    } catch (Exception e) {
    	        System.out.println("RDD not found on this portal.");
    	        return false;
    	    }
    	}
     public void byproduct()
     {
    	 wait.until(ExpectedConditions.visibilityOf(byproduct)).click();;
     }
     
     public void bybackorder()
     {
    	 wait.until(ExpectedConditions.elementToBeClickable(bybackorder)).click();
     }
     public boolean verifybyproduct(String orderno) throws InterruptedException
     {
    	 WebElement det=wait.until(ExpectedConditions.visibilityOf(byproductdetails));
    	 String details=det.getText();
    	 if(!details.contains(orderno) && det.isDisplayed())
    	 {
    		 return false;
    	 }
    	 return true;
     }
     public boolean verifybybackorder() throws InterruptedException
     {
    	 WebElement det=wait.until(ExpectedConditions.visibilityOf(bybackorderdetails));
    	 return det.isDisplayed();
     }
     public void searchbyorderno() throws InterruptedException
     {
    	 WebElement fil1=wait.until(ExpectedConditions.visibilityOf(searchbyOrdernumber));
    	 fil1.sendKeys("1032230948");
    	 Thread.sleep(2000);
    	 WebElement fil2=wait.until(ExpectedConditions.visibilityOf(apply));
    	 Actions clik=new Actions(driver);
    	 clik.moveToElement(fil2).click(fil2).perform();
     }
}
