package StepDefnitions;

import org.testng.Assert;

import Pages.Invoices;
import Pages.LoginPage;
import Utils.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invoicesSteps extends BaseTest{

	private static boolean invoicesfeatureInitialized = false;

    private LoginPage loginPage;
    private  Invoices invoicesPage;
    

    @Before("@invoice")
    public void beforeScenario() {
        
        // Run only once per feature file
        if (!invoicesfeatureInitialized) {

            setup();  // open browser ONCE
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            invoicesPage  = new Invoices(getDriver());

            // Login once per feature
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            invoicesfeatureInitialized = true;
            System.out.println("Login done once for this feature.");
        }
        else {
            // Already logged in and browser exists
            loginPage = new LoginPage(getDriver());
            
            invoicesPage  = new Invoices(getDriver());
            System.out.println("Reusing existing browser session.");
        }
    }
    

    @Given("I have lOgin to The systeM")
    public void i_have_login_to_th_e_system() {
        System.out.println("Already logged in.");
    }

   @When("click invoices page link")
   public void click_invoices_page_link() {
	   invoicesPage.inovices();
}

   @Then("I should be directed to the invoices page")
   public void i_should_be_directed_to_the_invoices_page() throws InterruptedException {
	   Thread.sleep(3000);
	   String url=getDriver().getCurrentUrl();
	   Assert.assertTrue(url.contains("my-account/invoice"), "wrong redirection");
}

@When("I click Past Due to check")
public void i_click_past_due_to_check() {
	invoicesPage.clickpast();
}
@Then("I should view them past data any error occur")
public void i_should_vIew_them_without_any_error_occur() throws InterruptedException {
    Assert.assertTrue(invoicesPage.pastdata(), "No data");
    Thread.sleep(3000);
    invoicesPage.colsepast();
}
@When("I click Rugular Due to check")
public void i_click_rugular_due_to_check() {
	invoicesPage.clickregular();
}

@Then("I should view them regular data any error occur")
public void i_should_view_them_without_any_error_occur() throws InterruptedException {
	Assert.assertTrue(invoicesPage.regulradata(), "No Data");
	Thread.sleep(3000);
    invoicesPage.colseregular();
}

@When("I click Completed invoices button")
public void i_click_completed_invoices_button() {
	invoicesPage.clickcompleted();
}

@When("I click calender button to choose start date")
public void i_click_calender_button_to_choose_start_date() {
	invoicesPage.date1();
}

@When("Choose date1 as start date")
public void choose_date1_as_start_date() {
	
	invoicesPage.selectdate1();
}
@When("I click calender button to choose end date")
public void i_click_calender_button_to_choose_end_date() {
	invoicesPage.date2();
}

@When("Choose date2 as end date")
public void choose_date2_as_end_date() {
	invoicesPage.selectdate2();
}

@When("Click APPLY button")
public void click_apply_button() {
	invoicesPage.Apply();
}

@Then("I should view completed invoices in details")
public void i_should_view_completed_invoices_in_details() {
	Assert.assertTrue(invoicesPage.CompletdData(), "No Data");
	tearDown();
}

}
