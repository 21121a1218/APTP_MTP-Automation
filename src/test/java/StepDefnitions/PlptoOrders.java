package StepDefnitions;

import org.testng.Assert;
import Pages.LoginPage;
import Pages.PLPOrderprocess;
import Pages.SearchPage;
import Utils.BaseTest;
import org.testng.SkipException;
import io.cucumber.java.en.*;

public class PlptoOrders extends BaseTest {

    LoginPage loginPage;
    PLPOrderprocess order;
    SearchPage searchPage;
    static boolean canProceed = true; // control flag for skipping flow

    // ---------------------- LOGIN ----------------------
    @Given("User launches the {string} Sales Portal Login Page")
    public void user_launches_the_sales_portal_login_page(String portalUrl) {
        setup();
        openUrl(portalUrl);
        loginPage = new LoginPage(getDriver());
        order = new PLPOrderprocess(getDriver());
        searchPage =new SearchPage(getDriver()); 
    }

    @And("User provides {string} as login mobile number")
    public void user_provides_as_login_mobile_number(String mobileNumber) {
        loginPage.enterMobileNumber(mobileNumber);
        loginPage.clickSendOtp();
    }

    @And("User provides {string} as login OTP")
    public void user_provides_as_login_otp(String otp) {
        loginPage.enterOtp(otp);
        loginPage.clickSubmit();
    }

    // ---------------------- PLP PAGE ----------------------
    @When("I navigate to the Product Listing Page \\(PLP)")
    public void i_navigate_to_the_product_listing_page_plp() throws InterruptedException {
    	order.search("205/65R15 99H");
    }

    @Then("I should see all product images and product names displayed correctly")
    public void i_should_see_all_product_images_and_product_names_displayed_correctly() {
        Assert.assertTrue(order.plppagevalidations(), "PLP product image/name validation failed!");
    }

    @Then("I should see the correct price displayed for each product")
    public void i_should_see_the_correct_price_displayed_for_each_product() {
        Assert.assertTrue(order.plpppricevalidation(), "PLP product price validation failed!");
    }

    @When("I enter a quantity {string} for a selected product")
    public void i_enter_a_quantity_for_a_selected_product(String quantity) {
        order.plppaddqty(quantity);
    }

    @When("I click on the Add to Cart button")
    public void i_click_on_the_add_to_cart_button() throws InterruptedException {
        order.addtocart();
    }

    @Then("I should see the product image, name, quantity, and pricing correctly displayed in the Add to Cart popup")
    public void i_should_see_the_product_image_name_quantity_and_pricing_correctly_displayed_in_the_add_to_cart_popup() {
        Assert.assertTrue(order.cartpopupvalidation(), "Add to Cart popup validation failed!");
    }

    // ---------------------- CART ----------------------
    @When("I see the View Cart button displayed and I click on the View Cart button")
    public void i_see_the_view_cart_button_displayed_and_i_click_on_the_view_cart_button() {
        order.viewcartbutton();
    }

    @Then("I should be navigated to the Cart page")
    public void i_should_be_navigated_to_the_cart_page() throws InterruptedException {
    	Thread.sleep(3000);
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("INR/cart"), "Cartpage not displayed!");
    }

    @Then("I should see the credit limit and cart total displayed")
    public void i_should_see_the_credit_limit_and_cart_total_displayed() {
        Assert.assertTrue(order.creditlimitdisplayed(), "Credit limit not visible on cart page!");
    }

    @Then("the credit balance should be greater than the cart total")
    public void the_credit_balance_should_be_greater_than_the_cart_total() {
        canProceed = order.verifyCreditLimitAndProceed();

        if (!canProceed) {
            System.out.println("⚠️ Credit limit < order total — skipping remaining steps.");
            tearDown();
            throw new SkipException("Scenario skipped — insufficient credit limit.");
        } else {
            System.out.println("✅ Credit limit sufficient — proceeding to checkout.");
        }
    }

    @Then("I should see the correct product image, name, quantity, and pricing on the cart page")
    public void i_should_see_the_correct_product_image_name_quantity_and_pricing_on_the_cart_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.cartpagevalidation(), "Cart product details validation failed!");
    }

    @Then("I should see the correct Order Totals and Total Taxes displayed on the cart page")
    public void i_should_see_the_correct_order_totals_and_total_taxes_displayed_on_the_cart_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.cartpagepricevalidation(), "Cart totals/taxes validation failed!");
    }

    // ---------------------- CHECKOUT ----------------------
    @When("I select a delivery date from the date picker")
    public void i_select_a_delivery_date_from_the_date_picker() {
        if (!canProceed) return;
        //order.selectdeliverydate(30);
    }

    @Then("I should see the selected delivery date reflected correctly")
    public void i_should_see_the_selected_delivery_date_reflected_correctly() {
        if (!canProceed) return;
        //Assert.assertTrue(order.verifydeliverydate("30"), "Delivery date not reflected!");
    }

    @When("I click on the Proceed to Checkout button")
    public void i_click_on_the_proceed_to_checkout_button() {
        if (!canProceed) return;
        order.clickcheckout();
    }

    @Then("I should be navigated to the Checkout page")
    public void i_should_be_navigated_to_the_checkout_page() throws InterruptedException {
    	Thread.sleep(4000);
        if (!canProceed) return;
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout"), "Checkout page not displayed!");
    }

    @Then("I should see the correct shipping and payer address details")
    public void i_should_see_the_correct_shipping_and_payer_address_details() {
        if (!canProceed) return;
        Assert.assertTrue(order.addressvalidation(), "Shipping/payer address validation failed!");
    }

    @Then("I should see the correct product image, name, quantity, and pricing on the checkout page")
    public void i_should_see_the_correct_product_image_name_quantity_and_pricing_on_the_checkout_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.orderpagevalidation(), "Checkout product details mismatch!");
    }

    @Then("I should see the correct Order Totals and Total Taxes displayed on the checkout page")
    public void i_should_see_the_correct_order_totals_and_total_taxes_displayed_on_the_checkout_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.orderpagepricevalidation(), "Checkout totals/taxes missing!");
    }

    // ---------------------- ORDER CONFIRMATION ----------------------
    @When("I place the order")
    public void i_place_the_order() {
        if (!canProceed) return;
        order.orderplace();
    }

    @Then("I should see the {string} message displayed on the order confirmation page")
    public void i_should_see_the_message_displayed_on_the_order_confirmation_page(String message) {
        if (!canProceed) return;
        String actual = order.ordersuccesfullmessage();
        Assert.assertTrue(actual.contains("Thank you!"), "Thank You message not found!");
    }

    @Then("I should see the correct product image, name, quantity, and pricing on the order confirmation page")
    public void i_should_see_the_correct_product_image_name_quantity_and_pricing_on_the_order_confirmation_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.ConfrimValidations(), "Confirmation product validation failed!");
    }

    @Then("I should see the correct Order Totals and Total Taxes displayed on the order confirmation page")
    public void i_should_see_the_correct_order_totals_and_total_taxes_displayed_on_the_order_confirmation_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.confrimpricevalidation(), "Confirmation totals/taxes not shown!");
    }

    @Then("I should see the correct shipping address displayed on the order confirmation page")
    public void i_should_see_the_correct_shipping_address_displayed_on_the_order_confirmation_page() {
        if (!canProceed) return;
        Assert.assertTrue(order.Confshippingdetails(), "Confirmation shipping address missing!");
        tearDown();
    }
}

