package StepDefnitions;

import org.testng.Assert;
import Pages.LoginPage;
import Pages.Myaccount;
import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Accountsummary_Steps extends BaseTest {

    private static boolean accountfeatureInitialized = false;

    private Myaccount myaccountpage;
    private LoginPage loginPage;

    @Before("@account")
    public void beforeScenario() {
        
        // Run only once per feature file
        if (!accountfeatureInitialized) {

            setup();  // open browser ONCE
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            myaccountpage = new Myaccount(getDriver());

            // Login once per feature
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            accountfeatureInitialized = true;
            System.out.println("Login done once for this feature.");
        }
        else {
            // Already logged in and browser exists
            loginPage = new LoginPage(getDriver());
            myaccountpage = new Myaccount(getDriver());
            System.out.println("Reusing existing browser session.");
        }
    }

    // ------------------ STEPS ----------------------

    @Given("I Have login to thE system")
    public void i_have_login_to_th_e_system() {
        System.out.println("Already logged in.");
    }

    @When("click account summary link")
    public void click_account_summary_link() {
        myaccountpage.accountsummaryredirection();
    }

    @Then("I should be directed to the account summary page")
    public void i_should_be_directed_to_the_account_summary_page() throws InterruptedException {
        Thread.sleep(3000);
        String url = getDriver().getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("account-summary"), "redirection failed");
    }

    @Then("I should see account summary information in details")
    public void i_should_see_account_summary_information_in_details() {
        Assert.assertTrue(myaccountpage.validateaccountsummary());
    }

    @When("I click account statement tab")
    public void i_click_account_statement_tab() throws InterruptedException {
        myaccountpage.switchactsmt();
        Thread.sleep(2000);
    }

    @Then("I should see the Filter by Posting period section")
    public void i_should_see_the_filter_by_posting_period_section() {
        Assert.assertTrue(myaccountpage.actsmtvalidation());
        tearDown();
    }
}
