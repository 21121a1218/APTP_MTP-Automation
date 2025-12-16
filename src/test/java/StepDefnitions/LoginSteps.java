package StepDefnitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import Pages.LoginPage;
import Utils.BaseTest;

public class LoginSteps extends BaseTest {
    LoginPage loginPage;

    @Given("I have navigated to the {string} Sales Portal login Page")
    public void i_have_navigated_to_the_sales_portal_login_page(String portalUrl) {
        setup();
        openUrl(portalUrl);
        loginPage = new LoginPage(getDriver());
    }

    @When("I enter {string} as test mobile number")
    public void i_enter_mobile_number(String mobileNum) {
        loginPage.enterMobileNumber(mobileNum);
        loginPage.clickSendOtp();
    }

    @And("I enter {string} as test OTP")
    public void i_enter_otp(String otp) {
        loginPage.enterOtp(otp);
        loginPage.clickSubmit();
    }

    @Then("I can see the homepage")
    public void i_can_see_the_homepage() {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("goodyear.com"), "Homepage not displayed!");
        tearDown();
    }
}
