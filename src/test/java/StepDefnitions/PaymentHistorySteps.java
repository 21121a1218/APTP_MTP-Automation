package StepDefnitions;

import org.testng.Assert;

import Pages.LoginPage;
import Pages.Myaccount;
import Pages.PaymentHistory;
import Utils.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentHistorySteps extends BaseTest{
	
	private static boolean paymentfeatureInitialized = false;

    private LoginPage loginPage;
    private Myaccount myaccount;
    private PaymentHistory payment;
    

    @Before("@payment")
    public void beforeScenario() {
        
        // Run only once per feature file
        if (!paymentfeatureInitialized) {

            setup();  // open browser ONCE
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            myaccount  = new Myaccount(getDriver());
            payment  = new PaymentHistory(getDriver());

            // Login once per feature
            loginPage.enterMobileNumber("9611060027");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            paymentfeatureInitialized = true;
            System.out.println("Login done once for this feature.");
        }
        else {
            // Already logged in and browser exists
            loginPage = new LoginPage(getDriver());
            myaccount  = new Myaccount(getDriver());
            payment  = new PaymentHistory(getDriver());
            System.out.println("Reusing existing browser session.");
        }
    }
    

    @Given("I hAve login tO the system")
    public void i_have_login_to_th_e_system() {
        System.out.println("Already logged in.");
    }

@When("click payment history page link")
public void click_payment_history_page_link() {
	payment.paymenthistory();
}

@Then("I should be directed to the payment history page")
public void i_should_be_directed_to_the_payment_history_page() throws InterruptedException {
	Thread.sleep(2000);
    String url=getDriver().getCurrentUrl();
    Assert.assertTrue(url.contains("my-account/paymenthistory"), "Wrong redirection");
    tearDown();
}  
}
