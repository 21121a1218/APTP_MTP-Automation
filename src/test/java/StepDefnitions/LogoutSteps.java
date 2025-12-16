package StepDefnitions;

import org.testng.Assert;

import Pages.LoginPage;
import Utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps  extends BaseTest {
    LoginPage loginPage;

    @Given("I HaVe navigAted to the {string} Sales Portal login Page")
    public void i_have_navigated_to_the_sales_portal_login_page(String portalUrl) {
        setup();
        openUrl(portalUrl);
        loginPage = new LoginPage(getDriver());
    }

    @When("I entEr {string} as test mobile number")
    public void i_enter_mobile_number(String mobileNum) {
        loginPage.enterMobileNumber(mobileNum);
        loginPage.clickSendOtp();
    }

    @And("I enter {string} as tESt OTP")
    public void i_enter_otp(String otp) {
        loginPage.enterOtp(otp);
        loginPage.clickSubmit();
    }

    @Then("I can see the hOmepage")
    public void i_can_see_the_homepage() {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("goodyear.com"), "Homepage not displayed!");
    }

    @When("I Click logout")
    public void i_click_logout() {
        loginPage.click_logout();
    }

    @Then("I can see the signin page")
    public void i_can_see_the_signin_page() throws InterruptedException {
    	Thread.sleep(3000);
    	Assert.assertTrue(loginPage.verify_logout(), "logout failed");
       tearDown();
}
}
