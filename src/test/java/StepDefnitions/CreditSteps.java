package StepDefnitions;

import org.testng.Assert;

import Pages.CreditPage;
import Pages.LoginPage;
import Pages.Myaccount;
import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreditSteps extends BaseTest {

    // shared across all scenarios so the same browser/session is reused
	
    private static boolean featureInitialized = false;
    private LoginPage loginPage;
    private CreditPage creditpage;

    @Before("@credit")
    public void beforeScenario() {
        if (!featureInitialized) {
            setup(); // thread-local idempotent driver creation
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            creditpage = new CreditPage(getDriver());

            // perform login once
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            featureInitialized = true;
            System.out.println("SearchSteps: logged in for feature");
        } else {
            // reuse existing browser/session
            loginPage = new LoginPage(getDriver());
            creditpage = new CreditPage(getDriver());
            System.out.println("SearchSteps: reusing browser session");
        }

    }
// The Given step is kept for readability in the feature but does nothing because login is already done
    @Given("I Have login to THE system")
    public void i_have_login_to_th_E_system() {
        System.out.println("Already logged in for the test session.");
    }
    @When("click my credits page link")
    public void click_my_credits_page_link() {
        // navigate to My Credits from the current session
        creditpage.creditpage();
    }

    @Then("I should be directed to the credits page")
    public void i_should_be_directed_to_the_credits_page() {
        String url = getDriver().getCurrentUrl();
        System.out.println("Current URL (Credits page): " + url);
        // Optionally add an assertion (using your chosen assertion lib)
        // Assert.assertTrue(url.contains("credits") || url.contains("credit"), "Not on credits page");
    }

    @When("I am on the credits page and enter {string} to the payment amount input bar")
    public void i_am_on_the_credits_page_and_enter_to_the_payment_amount_input_bar(String amt) {
       creditpage.addfund(amt);
    }

    @When("I enter {string} to the TDS amount input bar")
    public void i_enter_to_the_tds_amount_input_bar(String tds) throws InterruptedException {
        creditpage.addtds(tds);
    }

    @When("I click ADD FUNDS button")
    public void i_click_add_funds_button() {
        creditpage.addfunds();
    }

    @Then("I should be directed to transaction page")
    public void i_should_be_directed_to_transaction_page() throws InterruptedException {

        Thread.sleep(4000);
        try {
            getDriver().switchTo().alert().accept();
            System.out.println("Alert was present and accepted");
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            System.out.println("No alert present, continuing...");
        }

        // Validate URL
        String url = getDriver().getCurrentUrl();
        System.out.println("Current URL (Transaction page): " + url);

        Assert.assertTrue(
            url.contains("transaction") || url.contains("Pay"),
            "Not on transaction page"
        );

        Thread.sleep(3000);
        tearDown();
    }

}
