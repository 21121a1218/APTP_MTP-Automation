package StepDefnitions;

import org.testng.Assert;
import Pages.LoginPage;
import Utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResendotpSteps extends BaseTest {
    LoginPage loginPage;
    
    @Given("I have navigated to the {string} Sales Portal LoGin Page")
    public void i_have_navigated_to_the_sales_portal_lo_gin_page(String portalUrl) {
    	setup();
        openUrl(portalUrl);
        loginPage = new LoginPage(getDriver());
    }

    @And("I enter {string} as Test mobIle number")
    public void i_enter_as_test_mob_ile_number(String mobileNum) throws InterruptedException {
    	loginPage.enterMobileNumber(mobileNum);
        loginPage.clickSendOtp();
        Thread.sleep(125000);
    }

    @When("I wait for the previous OTP to expire or click on Resend OTP")
    public void i_wait_for_the_previous_otp_to_expire_or_click_on_resend_otp() {
    	loginPage.click_Resend_OTP();
    }

    @Then("I should see that the OTP countdown timer restarts")
    public void i_should_see_that_the_otp_countdown_timer_restarts() {
    	String timer = loginPage.countdown();
        Assert.assertTrue(timer.contains("Seconds"), "Countdown timer did not restart after resending OTP!");
    }

    @When("I enTer {string} as Test oTP")
    public void i_en_ter_as_test_o_tp(String otp) {
    	loginPage.enterOtp(otp);
        loginPage.clickSubmit();
    }

    @Then("I can see the HoMEpAge")
    public void i_can_see_the_ho_m_ep_age() throws InterruptedException {
    	Thread.sleep(3000);
    	String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("goodyear.com"), "Homepage not displayed after OTP login!");
        tearDown();
    }
}

