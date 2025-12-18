package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    

    @FindBy(xpath = "//input[@placeholder='0000000000']") WebElement mobileNumberInput;

    @FindBy(xpath = "//button[contains(text(),'Send OTP') or @type='submit']") WebElement sendOtpButton;

    @FindBy(xpath = "//input[@placeholder='000000']") WebElement otpInput;

    @FindBy(xpath = "//button[normalize-space()='SUBMIT']") WebElement submitButton;

    @FindBy(xpath = "/html/body/cx-root/cx-storefront/header/cx-page-layout[1]/cx-page-slot[3]/cx-login/cx-page-slot/cx-banner[2]/cx-generic-link/a/cx-media/img") WebElement logout;
    
    @FindBy(xpath = " //p[@class='resendOTP']") WebElement resendOTP;
    
    @FindBy(xpath="//p[@class='text-light remainingTime']") WebElement countdown;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void enterMobileNumber(String number) {
        WebElement input = wait.until(ExpectedConditions.visibilityOf(mobileNumberInput));
        input.clear();
        input.sendKeys(number);
    }

    public void clickSendOtp() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(sendOtpButton));
        Actions hove=new Actions(driver);
        hove.moveToElement(button).click().perform();
    }

    public void enterOtp(String otp) {
        WebElement otpBox = wait.until(ExpectedConditions.visibilityOf(otpInput));
        otpBox.sendKeys(otp);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.click();
    }
    public void click_logout()
    {
    	 WebElement Logout = wait.until(ExpectedConditions.elementToBeClickable(logout));
    	 Logout.click();
    }
    public void click_Resend_OTP()
    {
    	 WebElement resend_otp = wait.until(ExpectedConditions.elementToBeClickable(resendOTP));
    	 resend_otp.click();
    }
    public String countdown()
    {
    	WebElement timer = wait.until(ExpectedConditions.visibilityOf(countdown));
    	String Timer=timer.getText();
    	return Timer;
    }
    public boolean verify_logout()
    {
    	WebElement input = wait.until(ExpectedConditions.visibilityOf(mobileNumberInput));
    	return input.isDisplayed();
    	
    }
}
