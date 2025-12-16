package StepDefnitions;

import org.testng.Assert;

import Pages.LoginPage;
import Pages.OrdersPage;
import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistory extends BaseTest{
	private static boolean historyfeatureInitialized = false;

    private OrdersPage history;
    private LoginPage loginPage;

    @Before("@history")
    public void beforeScenario() {
        
        // Run only once per feature file
        if (!historyfeatureInitialized) {

            setup();  // open browser ONCE
            openUrl("https://test.mysalesportal.ap.goodyear.com/in/en/INR/");

            loginPage = new LoginPage(getDriver());
            history = new OrdersPage(getDriver());

            // Login once per feature
            loginPage.enterMobileNumber("9632119292");
            loginPage.clickSendOtp();
            loginPage.enterOtp("123456");
            loginPage.clickSubmit();

            historyfeatureInitialized = true;
            System.out.println("Login done once for this feature.");
        }
        else {
            // Already logged in and browser exists
            loginPage = new LoginPage(getDriver());
            history = new OrdersPage(getDriver());
            System.out.println("Reusing existing browser session.");
        }
    }
    
    // ------------------ STEPS ----------------------

    @Given("I HaVe logIn to the system")
    public void i_have_login_to_th_e_system() {
        System.out.println("Already logged in.");
    }
    
    @When("click order page link")
    public void click_order_page_link() throws InterruptedException {
    	history.orders();
    	   
    }

    @Then("I should be directed to the order page")
    public void i_should_be_directed_to_the_order_page() throws InterruptedException {
    	Thread.sleep(3000);
        String url = getDriver().getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("my-account/orders"), "redirection failed");
        history.searchbyorderno(); 
    }
    @When("I click By Order Number to check byorder number")
    public void i_click_by_order_number_to_check_byorder_number() throws InterruptedException {
    	Thread.sleep(4000);
        history.byorder();
    }

    @Then("I should view orderdeatils for by ordernumber {string}")
    public void i_should_view_orderdeatils_byorderno_for(String orderno) throws InterruptedException {
        Assert.assertTrue(history.verifybyorder(orderno), "wrong order details");
        history.closebyorderno();
    }

    @When("I click By Product to check byproduct number")
    public void i_click_by_product_to_check_byproduct_number() {
        history.byproduct();
    }
    
    @Then("I should view orderdeatils for  by prodct {string}")
    public void i_should_view_orderdeatils_byproduct_for(String orderNo) throws InterruptedException {
        Assert.assertTrue(history.verifybyproduct(orderNo), "wrong order details");
        history.closebyproduct();
    }

    @When("I click By Backorder to check")
    public void i_click_by_backorder_to_check() {
       history.bybackorder();
    }

    @Then("I should view orderdeatils under bybackorder number")
    public void i_should_view_orderdeatils_under_bybackorder_number() throws InterruptedException {
        history.verifybybackorder();
       Thread.sleep(2000);
       tearDown();
    }   
}

   
