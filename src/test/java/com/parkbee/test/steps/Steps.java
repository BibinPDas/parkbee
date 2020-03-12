package com.parkbee.test.steps;

import com.parkbee.test.HelperFunctions;
import com.parkbee.test.utilities.AssertionMethods;
import com.parkbee.test.utilities.TestCaseFailed;
import com.parkbee.test.utilities.URLProperties;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	private Scenario scenario;

	@Before
	public void beforeEach(Scenario scenario) {
		this.scenario = scenario;
	}

	private final HelperFunctions helper = new HelperFunctions();
	private final AssertionMethods assertionObj = new AssertionMethods();

	@Given("^I am on the parkbee home page$")
	public void i_am_on_the_parkbeecom_home_page() {
		System.out.println("Parkbee.com home page url:" + URLProperties.get("parkbee"));
		helper.getURL(URLProperties.get("parkbee"));
	}

	@When("^I enter \"([^\"]*)\" into \"([^\"]*)\" input field$")
	public void i_enter_into_input_field(String arg1, String arg2) {

		helper.entertoInputField(arg2, arg1);
	}

	@And("^enter \"([^\"]*)\" into \"([^\"]*)\" input field$")
	public void enter_into_input_field(String arg1, String arg2) {

		helper.entertoInputField(arg2, arg1);
	}

	@When("^I scroll to the element having \"([^\"]*)\"$")
	public void scroll_to_the_element(String accessName) throws Exception {
		String[] KeyAccess = helper.splitAndGet(accessName);
		helper.validateLocator(KeyAccess[0]);
		helper.scrollToElement(KeyAccess[0], KeyAccess[1]);
	}

	@Then("^I check the \"([^\"]*)\"$")
	public void i_check_the_rate(String rate) throws Throwable {
		helper.getRate(rate);
	}

	@Given("^close browser$")
	public void close_browser() {
		helper.closeBrowser();
	}

	@Given("^I take screenshot$")
	public void screenshot() {
		helper.takeScreenshot(this.scenario);
	}

	@Given("^I wait for \"([^\"]*)\" seconds$")
	public void i_wait_for(String arg1) throws Exception {
		Thread.sleep(Integer.parseInt(arg1) * 1000);
	}

	@Then("^I maximize browser window$")
	public void i_maximize_browser_window() {
		helper.maximizeBrowser();
	}

	@Then("^I enter \"([^\"]*)\" date into \"([^\"]*)\" input field$")
	public void i_enter_date_into_input_field(String arg1, String arg2) {
		helper.entertoInputField(arg2, arg1);
	}

	@Then("^I should see the page title as \"([^\"]*)\"$")
	public void i_should_see_the_page_title_as(String title) throws TestCaseFailed {
		String present = "";
		assertionObj.checkTitle(title, present.isEmpty());
	}

	@Then("^element having \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String accessName, String present, String value) throws Exception {
		String[] keyAccess = helper.splitAndGet(accessName);
		System.out.println("Checking for element having text " + value + "with " + keyAccess[0] + "  " + keyAccess[1]);
		helper.validateLocator(keyAccess[0]);
		assertionObj.checkElementText(keyAccess[0], value, keyAccess[1], present.isEmpty());
	}

	@When("^I click on element having \"(.*?)\"$")
	public void click(String accessName) throws Exception {
		String[] keyAccess = helper.splitAndGet(accessName);
		System.out.println("clcik on element having  " + keyAccess[0] + " " + keyAccess[1]);
		assertionObj.click(keyAccess[0], keyAccess[1]);
	}
}
