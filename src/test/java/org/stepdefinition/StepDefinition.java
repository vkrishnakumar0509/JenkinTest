package org.stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.base.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.LoginPojo;
import org.pojo.OtpPojo;
import org.pojo.SignupPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition extends BaseMethods {

	@Given("User should launch the portal by enter the url")
	public void user_should_launch_the_portal_by_enter_the_url() {

		url("https://dev.madtechai.com/");

	}

	@Then("verify user should be in login page")
	public void verify_user_should_be_in_login_page() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.equals("https://demo.madtechai.com/")) {

			System.out.println("Passed");

		} else {

			Assert.fail();

		}

	}

	@Given("verify that LOGO should be there in Login page")
	public void verify_that_logo_should_be_there_in_login_page() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		WebElement w1 = p.getLoginLogo();

		Thread.sleep(3000);
		String logo = w1.getAttribute("src");
		if (logo.contains("")) {

			System.out.println(logo + "-> " + "Passed");

		} else {

			Assert.fail();
		}
	}

	@Given("Provide valid username in Alternative case and enter the valid password")
	public void provide_valid_username_in_alternative_case_and_enter_the_valid_password()
			throws IOException, InterruptedException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("alternateEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("alternatePass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();

	}

	@Given("it should login into the MTAI application")
	public void it_should_login_into_the_mtai_application() throws InterruptedException {

		Thread.sleep(20000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://dev.madtechai.com/home")) {

			System.out.println(url + "->" + "Passed");
		} else {
			System.out.println(url);
			Assert.fail();
		}
	}

	@Given("Verify that sign-in button should be there in login page by locating the element")
	public void verify_that_sign_in_button_should_be_there_in_login_page_by_locating_the_element() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getSigninbutn()));
		WebElement w1 = p.getSigninbutn();
		String s1 = w1.getText();
		if (s1.contains("Sign in")) {
			System.out.println("Passed");

		} else {

			System.out.println(s1);
			Assert.fail();
		}

	}

	@Given("Verify that Sign-in with SSO button should be there in login page by locating the element")
	public void verify_that_sign_in_with_sso_button_should_be_there_in_login_page_by_locating_the_element() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getSigningoogle()));
		WebElement w1 = p.getSigningoogle();
		String s1 = w1.getText();
		if (s1.contains("Sign in with Google")) {
			System.out.println("Passed");

		} else {

			System.out.println(s1);
			Assert.fail();
		}

	}

	@Given("click on the Sign In with google SSO button")
	public void click_on_the_sign_in_with_google_sso_button() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(p.getSigningoogle()));
		p.getSigningoogle().click();
	}

	@Given("Provide valid username and valid password for SSO")
	public void provide_valid_username_and_valid_password_for_sso() throws InterruptedException, IOException {
		LoginPojo p = new LoginPojo();
		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		p.getGoogleEmailTextbox().sendKeys(props.getProperty("SSOEmail"));
		p.getGoogleNext().click();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(p.getGooglePwdTextbox()));
		WebElement pwd = p.getGooglePwdTextbox();
		pwd.sendKeys(props.getProperty("SSOPass"));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(p.getGoogleNexttwo()));
		element.click();

	}

	@Given("it should login into the MTAI application homepage")
	public void it_should_login_into_the_mtai_application_homepage() throws InterruptedException {

		Thread.sleep(20000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://dev.madtechai.com/home")) {

			System.out.println(url + "->" + "Passed");
		} else {
			System.out.println(url);
			Assert.fail();
		}

	}

	@Given("Provide valid username and valid password")
	public void provide_valid_username_and_valid_password() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("alternateEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("alternatePass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();

	}

	@Given("Click on the Sign-out button which is in profile button")
	public void click_on_the_sign_out_button_which_is_in_profile_button() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(p.getProfileIcon()));
		WebElement w1 = p.getProfileIcon();
		Thread.sleep(2000);
		w1.click();
		p.getSignoutbtn().click();
		Thread.sleep(5000);

	}

	@Then("verify user should be in login page after logout")
	public void verify_user_should_be_in_login_page_after_logout() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.equals("https://dev.madtechai.com/login")) {

			System.out.println("Passed");

		} else {

			System.out.println(currentUrl + " -> Failed");
			Assert.fail();
		}

	}

	@Given("click on the sign-in button without entering the credentials")
	public void click_on_the_sign_in_button_without_entering_the_credentials() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(p.getSigninbutn()));
		p.getSigninbutn().click();
	}

	@Then("verify that validation message should be displayed at the email and password field")
	public void verify_that_validation_message_should_be_displayed_at_the_email_and_password_field() {

		String emailValidation = driver.findElement(By.xpath("//div[text()=' Email is required ']")).getText();
		String passValidation = driver.findElement(By.xpath("//div[text()=' Password is required ']")).getText();

		if (emailValidation.equals("Email is required") && passValidation.equals("Password is required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Provide invalid username and valid password")
	public void provide_invalid_username_and_valid_password() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("invalidEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("validPass"));

	}

	@Given("Click on the sign-in button")
	public void click_on_the_sign_in_button() {

		LoginPojo p = new LoginPojo();
		WebElement w3 = p.getSigninbutn();
		w3.click();
	}

	@Then("verify validation should be shown as -Please enter a valid email id-")
	public void verify_validation_should_be_shown_as_please_enter_a_valid_email_id() {

		String emailValidation = driver.findElement(By.xpath("//div[text()=' Please enter valid email address ']"))
				.getText();
		if (emailValidation.equals("Please enter valid email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(emailValidation);
		}
	}

	@Given("Provide valid username and invalid password with less than {int} char")
	public void provide_valid_username_and_invalid_password_with_less_than_char(Integer int1) throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("validEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("invalidPassChar"));

	}

	@Then("verify validation should be shown as -Please enter a valid password-")
	public void verify_validation_should_be_shown_as_please_enter_a_valid_password() {

		String passValidation = driver.findElement(By.xpath("//div[text()=' Please enter valid password ']")).getText();
		if (passValidation.equals("Please enter valid password")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(passValidation);
		}
	}

	@Given("Provide valid username and invalid password")
	public void provide_valid_username_and_invalid_password() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("validEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("invalidPass"));

	}

	@Then("verify validation should be shown as -Incorrect username or password-")
	public void verify_validation_should_be_shown_as_incorrect_username_or_password() {

		String validation = driver.findElement(By.xpath("//span[text()='Incorrect username or password.']")).getText();
		if (validation.equals("Incorrect username or password.")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(validation);
		}

	}

	@Given("Provide valid username and valid password for LoginPage")
	public void provide_valid_username_and_valid_password_for_login_page() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("alternateEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("alternatePass"));

	}

	@Given("verify that remember me option should be checked by default")
	public void verify_that_remember_me_option_should_be_checked_by_default() {

		LoginPojo p = new LoginPojo();
		boolean checkbox = p.getRemembermecheckbox().isSelected();

		if (checkbox) {
			System.out.println("Passed-Checked by default");

		} else {

			System.out.println("Failed-Unchecked by default");
			// Assert.fail();
		}

	}

	@Given("verify that remember me option should be able to check and uncheck")
	public void verify_that_remember_me_option_should_be_able_to_check_and_uncheck() {

		LoginPojo p = new LoginPojo();
		p.getRemembermecheckbox().click();
		boolean checkbox = p.getRemembermecheckbox().isSelected();

		if (checkbox) {
			System.out.println("Passed-Checked");

		} else {

			System.out.println("Failed-Unchecked");
			// Assert.fail();
		}

		p.getRemembermecheckbox().click();

		boolean checkbox1 = p.getRemembermecheckbox().isSelected();
		// System.out.println(checkbox1);

		if (checkbox1) {
			System.out.println("Failed-checked");

		} else {

			System.out.println("Passed-UnChecked");
			// Assert.fail();
		}

	}

	@Given("Provide password with {int} chars")
	public void provide_password_with_chars(Integer int1) throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTextboxpassword()));
		p.getTextboxpassword().sendKeys(props.getProperty("validPass"));
	}

	@Given("Click on Eye icon it should unmask the password and for another click it should mask the password")
	public void click_on_eye_icon_it_should_unmask_the_password_and_for_another_click_it_should_mask_the_password() {

		LoginPojo p = new LoginPojo();
		String secure = p.getTextboxpassword().getAttribute("type");

		if (secure.equals("password")) {

			System.out.println("Masked");
		} else {

			System.out.println("UnMasked");
			Assert.fail();
		}

		WebElement w1 = p.getLogineyeicon();
		w1.click();

		WebElement w2 = p.getTextboxpassword();
		String secure1 = w2.getAttribute("type");

		if (secure1.equals("text")) {

			System.out.println("Unmasked");
		} else {

			System.out.println("Masked");
			Assert.fail();
		}

	}

	@Given("verify Forgot Password option under password text box")
	public void verify_forgot_password_option_under_password_text_box() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		Thread.sleep(5000);
		boolean buttn = p.getForgotpassbtn().isDisplayed();
		if (buttn) {
			System.out.println("Passed");

		} else {

			System.out.println("Passed- but Hidden");
			// Assert.fail();
		}

	}

	@Given("Click Forgot Password option under password text box")
	public void click_forgot_password_option_under_password_text_box() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		Thread.sleep(5000);
		WebElement btn = p.getForgotpassbtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn);

	}

	@Given("verify that Forgot Password should open a popup to enter email id")
	public void verify_that_forgot_password_should_open_a_popup_to_enter_email_id() {

		LoginPojo p = new LoginPojo();
		boolean textbox = p.getFgtpasstextbox().isEnabled();
		System.out.println(textbox);

	}

	@Given("verify that Forgot Password should have Submit and cancel button")
	public void verify_that_forgot_password_should_have_submit_and_cancel_button() {

		LoginPojo p = new LoginPojo();
		boolean submit = p.getFgtpasssubmit().isEnabled();
		boolean cancel = p.getFgtpasscancel().isEnabled();

		if (submit && cancel) {
			System.out.println("Passed");

		} else {

			Assert.fail();
		}

	}

	@Given("verify that user has to enter valid email id to get reset password link")
	public void verify_that_user_has_to_enter_valid_email_id_to_get_reset_password_link()
			throws IOException, InterruptedException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		Thread.sleep(3000);
		WebElement w1 = p.getFgtpasstextbox();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		w1.sendKeys("fe@hdg.com");

		Thread.sleep(2000);
		WebElement w2 = p.getFgtpasssubmit();
		js.executeScript("arguments[0].click()", w2);
	}

	@Then("Validation message should be emerged - password reset request sent successfully-")
	public void validation_message_should_be_emerged_password_reset_request_sent_successfully() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement w1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

		String validation = w1.getText();
		if (validation.equals("Password Reset request has been sent successfully")) {

			System.out.println("Passed");
		} else {

			System.out.println(validation);
			Assert.fail();
		}

	}

	@Given("verify that after clicking cancel button the pop-up should be closed")
	public void verify_that_after_clicking_cancel_button_the_pop_up_should_be_closed() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		WebElement w1 = p.getFgtpasscancel();
		wait.until(ExpectedConditions.elementToBeClickable(w1));
		w1.click();
		Thread.sleep(2000);
		if (w1.isDisplayed()) {

			System.out.println("Failed");
			Assert.fail();

		} else {

			System.out.println("Passed");
		}

	}

	@Given("Verify that all CSS components are matching with the requirements")
	public void verify_that_all_css_components_are_matching_with_the_requirements() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.visibilityOf(p.getSigninbutn()));
		String color = butn.getCssValue("background-color");
		String font = butn.getCssValue("font-family");

		Assert.assertEquals("Verify the font", "AvenirNextLTPro-Regular", font);
		Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);

	}

	@Given("User should give restricted domain email and Password in the login page")
	public void user_should_give_restricted_domain_email_and_password_in_the_login_page() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("restrictedEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("validPass"));

	}

	@Given("verify that after clicking Sign-in button, validation should be shown")
	public void verify_that_after_clicking_sign_in_button_validation_should_be_shown() {

		LoginPojo p = new LoginPojo();
		WebElement w3 = p.getSigninbutn();
		w3.click();

		String emailValidation = driver
				.findElement(By.xpath("//div[text()=' Please use your business email address ']")).getText();
		if (emailValidation.equals("Please use your business email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(emailValidation);
		}

	}

	@Given("User should give restricted domain email in the Forgot password pop-up")
	public void user_should_give_restricted_domain_email_in_the_forgot_password_pop_up()
			throws InterruptedException, IOException {

		LoginPojo p = new LoginPojo();
		Thread.sleep(5000);
		WebElement btn = p.getForgotpassbtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn);

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		Thread.sleep(3000);
		WebElement w1 = p.getFgtpasstextbox();

		w1.sendKeys(props.getProperty("restrictedEmail"));

		Thread.sleep(2000);
		WebElement w2 = p.getFgtpasssubmit();
		js.executeScript("arguments[0].click()", w2);

	}

	@Given("verify that after clicking Submit button, validation should be shown")
	public void verify_that_after_clicking_submit_button_validation_should_be_shown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Please use your business email address ']")));

		String emailValidation = butn.getText();
		if (emailValidation.equals("Please use your business email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(emailValidation);
			Assert.fail();
		}
	}

	@Given("user should click the close icon in Forgot password pop-up")
	public void user_should_click_the_close_icon_in_forgot_password_pop_up() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.visibilityOf(p.getFgtpasscloseicon()));

		butn.click();

	}

	@Given("Again user should click on Forgot password button, the validation should be removed")
	public void again_user_should_click_on_forgot_password_button_the_validation_should_be_removed()
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()=' Forgot your password? ']")));
		btn.click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//div[text()=' Please use your business email address ']"));

		} catch (Exception e) {

			System.out.println("Passed- Exception Handled");
		}

	}

	@Given("User should click on the clicks on the Privacy policy & Terms of use")
	public void user_should_click_on_the_clicks_on_the_privacy_policy_terms_of_use() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getPrivacypolicy()));
		butn.click();

		String title = pageTitle();
		System.out.println(title);
		if (title.equals("MADTechAI - Privacy Policy")) {
			System.out.println("Passed");
		} else {

			Assert.fail();
		}

	}

	@Given("verify that it has been properly redirected to corresponding page")
	public void verify_that_it_has_been_properly_redirected_to_corresponding_page() {

		driver.navigate().back();

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getTermsofuse()));
		butn.click();

		String title = pageTitle();
		System.out.println(title);
		if (title.equals("MADTechAI - Terms & Conditions")) {
			System.out.println("Passed");
		} else {

			Assert.fail();
		}

	}

	@Given("User should click on the clicks on the MadTechAI LLC")
	public void user_should_click_on_the_clicks_on_the_mad_tech_ai_llc() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getMadtechllc()));
		butn.click();

	}

	@Given("verify that it has been properly redirected to MadTechAI webpage")
	public void verify_that_it_has_been_properly_redirected_to_mad_tech_ai_webpage() {

		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		String title = pageTitle();

		if (title.contains("The Unified MADTech Data Decision Intelligence Platform")) {

			System.out.println("Passed");
			driver.close();

		} else {

			Assert.fail();
		}

		driver.switchTo().window(originalWindow);
	}

	@Given("User should click on the clicks on the Sign-up for free trial button")
	public void user_should_click_on_the_clicks_on_the_sign_up_for_free_trial_button() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getSignupfree()));
		butn.click();

	}

	@Given("verify that it has been properly redirected to Sign-up page")
	public void verify_that_it_has_been_properly_redirected_to_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		String title = pageTitle();
		System.out.println(title);

		if (title.contains("MADTechAI - Sign Up")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
		}
	}

	// Direct client Scenarios

	@Given("User should launch the portal by enter the custom url")
	public void user_should_launch_the_portal_by_enter_the_custom_url() {

		/* url("https://acme.madtechai.com/"); */

	}

	@Given("User should locate the Sign-up naming")
	public void user_should_locate_the_sign_up_naming() {
		/*
		 * LoginPojo p = new LoginPojo(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(5)); WebElement butn =
		 * wait.until(ExpectedConditions.visibilityOf(p.getDcsignup())); String signUp =
		 * butn.getText();
		 * 
		 * if (signUp.equals("Sign up")) {
		 * 
		 * System.out.println("Passed");
		 * 
		 * } else {
		 * 
		 * Assert.fail(); }
		 */
	}

	@Given("User should give other than registered domain")
	public void user_should_give_other_than_registered_domain() throws IOException {
		/*
		 * fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		 * 
		 * LoginPojo p = new LoginPojo(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(4));
		 * wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail())); WebElement
		 * w1 = p.getTxtboxemail(); w1.sendKeys(props.getProperty("alternateEmail"));
		 * WebElement w2 = p.getTextboxpassword();
		 * w2.sendKeys(props.getProperty("alternatePass")); WebElement w3 =
		 * p.getSigninbutn(); w3.click();
		 */
	}

	@Given("verify that it has to show validation -Please use registered mail id-")
	public void verify_that_it_has_to_show_validation_please_use_registered_mail_id() {

	}

	@Given("User should give registered domain")
	public void user_should_give_registered_domain() {

	}

	@Given("verify that it has to accept the registered mail id")
	public void verify_that_it_has_to_accept_the_registered_mail_id() {

	}

	@Given("user should click on the Sign-in with google and enter invalid credentials")
	public void user_should_click_on_the_sign_in_with_google_and_enter_invalid_credentials() {

	}

	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {

	}

	@Given("user should click on the Sign-in with linkedin and enter valid credentials")
	public void user_should_click_on_the_sign_in_with_linkedin_and_enter_valid_credentials() {

	}

	@Then("user should be redirecting to homepage")
	public void user_should_be_redirecting_to_homepage() {

	}

	// Sign-up page

	@Given("User should click on the Sign-up for free trial button")
	public void user_should_click_on_the_sign_up_for_free_trial_button() {

		SignupPojo pj = new SignupPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement w1 = wait.until(ExpectedConditions.elementToBeClickable(pj.getSignupfree()));
		w1.click();

	}

	@Given("User should be in sign-up page")
	public void user_should_be_in_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		String title = pageTitle();
		if (title.equals("MADTechAI - Sign Up")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
		}
	}

	@Given("Verify the presence of all mandatory fields on the sign-up page.")
	public void verify_the_presence_of_all_mandatory_fields_on_the_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		List<WebElement> li = new ArrayList<WebElement>();
		li.add(pj.getFname());
		li.add(pj.getlName());

		li.add(pj.getAccntName());
		li.add(pj.getAccntType());
		li.add(pj.getEmail());
		li.add(pj.getMarktServed());

		li.add(pj.getTxtboxphone());
		li.add(pj.getCountryPhone());
		li.add(pj.getDpmt());
		li.add(pj.getInterest());

		li.add(pj.getDiscoverMTAI());
		li.add(pj.getPwd());
		li.add(pj.getCpwd());

		for (WebElement x : li) {

			if (x.isDisplayed()) {

				System.out.println("Passed");

			} else {

				System.out.println("Failed");
				Assert.fail();
			}

		}

	}

	@Given("Verify that Sign-up page in proper CSS format as per requirement")
	public void verify_that_sign_up_page_in_proper_css_format_as_per_requirement() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement butn = pj.getFormSubmit();

		String color = butn.getCssValue("background-color");
		String font = butn.getCssValue("font-family");

		System.out.println(font + "  " + color);
		Assert.assertEquals("Verify the font", "AvenirNextLTPro-Regular", font);
		Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);

	}

	@Given("Verify the content of sign-up page")
	public void verify_the_content_of_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement logo = pj.getLogo();

		if (logo.isEnabled()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
		List<WebElement> texts = driver.findElements(By.xpath("//div[@class='box1']"));

		String s1 = "";
		List<String> li = new ArrayList<String>();

		String expectedText = "Try MADTechAI free for 15 days\n" + "Totally risk free. No commitment. Cancel anytime.\n"
				+ "Powerful iPaaS integration\n"
				+ "Transform disparate data on the fly with 300+ purpose-built connectors\n"
				+ "Pre-built analytics suite\n"
				+ "Access dozens of out-of-the-box data models, dashboards, and reports\n"
				+ "Conversational AI insights\n"
				+ "Get instant answers and visualizations using plain English queries\n" + "Flexible data ingestion\n"
				+ "Explore with our sample data or seamlessly integrate your own\n" + "Advanced marketing modeling\n"
				+ "Optimize strategy with our custom Marketing Mix Model (and hundreds more)\n"
				+ "Comprehensive data export\n" + "Download all data, graphics, and reports in your preferred format\n"
				+ "Free AWS data warehouse\n" + "Leverage our secure, scalable cloud infrastructure at no extra cost\n"
				+ "Always-on expert support\n"
				+ "Get 24/7/365 global support and access our thorough knowledge base anytime";

		for (WebElement line : texts) {
			s1 = line.getText();
			li.add(s1);
			System.out.println(s1);
		}

		String actualtext = String.join("\n", li);
		if (actualtext.equals(expectedText)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Give only email address and tries to sign-up and it has to show validation")
	public void give_only_email_address_and_tries_to_sign_up_and_it_has_to_show_validation() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		SignupPojo pj = new SignupPojo();
		pj.getEmail().sendKeys("jckdjbv@jwd.com");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);

		js.executeScript("arguments[0].click()", w1);

		WebElement w2 = driver.findElement(By.xpath("//div[text()=' Professional Phone is required ']"));

		if (w2.isDisplayed()) {
			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("verify that if user tries to submit the form without filling it has to show validation for all the fields")
	public void verify_that_if_user_tries_to_submit_the_form_without_filling_it_has_to_show_validation_for_all_the_fields() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		SignupPojo pj = new SignupPojo();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);

		js.executeScript("arguments[0].click()", w1);

		WebElement v1 = driver.findElement(By.xpath("//div[text()=' First Name is required ']"));
		WebElement v2 = driver.findElement(By.xpath("//div[text()=' Last Name is required ']"));
		WebElement v3 = driver.findElement(By.xpath("//div[text()=' Account Name is required ']"));
		WebElement v4 = driver.findElement(By.xpath("//div[text()=' Account Type is required ']"));
		WebElement v5 = driver.findElement(By.xpath("//div[text()=' Professional Email is required ']"));
		WebElement v6 = driver.findElement(By.xpath("//div[text()=' Market(s) Served is required ']"));
		WebElement v7 = driver.findElement(By.xpath("//div[text()=' Professional Phone is required ']"));
		WebElement v8 = driver.findElement(By.xpath("//div[text()=' Department is required ']"));
		WebElement v9 = driver.findElement(By.xpath("(//div[text()=' Please pick an option from the list ']) [1]"));
		WebElement v10 = driver.findElement(By.xpath("(//div[text()=' Please pick an option from the list ']) [2]"));
		WebElement v11 = driver.findElement(By.xpath("//div[text()=' Password is required ']"));
		WebElement v12 = driver.findElement(By.xpath("//div[text()=' Confirm Password is required ']"));
		WebElement v13 = driver.findElement(
				By.xpath("//div[text()=' Please agree to the Terms of use & Privacy Policy before signing up ']"));

		ArrayList<WebElement> list = new ArrayList<WebElement>(
				Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13));

		for (WebElement x : list) {

			if (x.isDisplayed()) {

				System.out.println("Passed");

			} else {

				Assert.fail();
				System.out.println("Failed");
			}

		}

	}

	@Given("verify that if user tries to submit the form with invalid data and it has to show validation for all the fields")
	public void verify_that_if_user_tries_to_submit_the_form_with_invalid_data_and_it_has_to_show_validation_for_all_the_fields() {

		// First name

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		SignupPojo pj = new SignupPojo();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);

		js.executeScript("arguments[0].click()", w1);

		pj.getFname().sendKeys("122");
		WebElement v1 = driver.findElement(By.xpath("//div[text()=' Invalid First Name ']"));
		String s1 = v1.getText();
		if (s1.equals("Invalid First Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w2 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w2);

		js.executeScript("arguments[0].click()", w2);

		pj.getFname().sendKeys("@`!");
		WebElement v2 = driver.findElement(By.xpath("//div[text()=' Invalid First Name ']"));
		String s2 = v2.getText();
		if (s2.equals("Invalid First Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w3 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w3);

		js.executeScript("arguments[0].click()", w3);

		pj.getFname().sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		WebElement v3 = driver.findElement(By.xpath("//div[text()=' First Name can be max 70 characters long ']"));
		String s3 = v3.getText();
		if (s3.equals("First Name can be max 70 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// LastName

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w4 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w4);

		js.executeScript("arguments[0].click()", w4);

		pj.getlName().sendKeys("123");
		WebElement v4 = driver.findElement(By.xpath("//div[text()=' Invalid Last Name ']"));
		String s4 = v4.getText();
		if (s4.equals("Invalid Last Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w5 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w5);

		js.executeScript("arguments[0].click()", w5);

		pj.getlName().sendKeys("@!`");
		WebElement v5 = driver.findElement(By.xpath("//div[text()=' Invalid Last Name ']"));
		String s5 = v5.getText();
		if (s5.equals("Invalid Last Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w6 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w6);

		js.executeScript("arguments[0].click()", w6);

		pj.getlName().sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		WebElement v6 = driver.findElement(By.xpath("//div[text()=' Last Name can be max 70 characters long ']"));
		String s6 = v6.getText();
		if (s6.equals("Last Name can be max 70 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Account Name

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w7 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w7);

		js.executeScript("arguments[0].click()", w7);

		pj.getAccntName()
				.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		WebElement v7 = driver.findElement(By.xpath("//div[text()=' Account Name can be max 70 characters long ']"));
		String s7 = v7.getText();
		if (s7.equals("Account Name can be max 70 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Professional Email

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w8 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w8);

		js.executeScript("arguments[0].click()", w8);

		pj.getEmail().sendKeys("testemail.com");

		WebElement v8 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s8 = v8.getText();
		if (s8.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w9 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w9);

		js.executeScript("arguments[0].click()", w9);

		pj.getEmail().sendKeys("user@@domain.com");

		WebElement v9 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s9 = v9.getText();
		if (s9.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w10 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w10);

		js.executeScript("arguments[0].click()", w10);

		pj.getEmail().sendKeys("user@com");

		WebElement v10 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s10 = v10.getText();
		if (s10.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		/*
		 * driver.navigate().refresh();
		 * 
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		 * 
		 * WebElement w11 = pj.getFormSubmit();
		 * js.executeScript("arguments[0].scrollIntoView(true)", w11);
		 * 
		 * js.executeScript("arguments[0].click()", w11);
		 * 
		 * pj.getEmail().sendKeys("useremail@domain.com");
		 * 
		 * WebElement v11 = driver.findElement(By.
		 * xpath("//div[text()=' Please enter valid Email address ']")); String s11 =
		 * v11.getText(); if (s11.equals("Please enter valid Email address")) {
		 * 
		 * System.out.println("Passed"); } else {
		 * 
		 * System.out.println("Failed"); }
		 */

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w12 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w12);

		js.executeScript("arguments[0].click()", w12);

		pj.getEmail().sendKeys("user@domain");

		WebElement v12 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s12 = v12.getText();
		if (s12.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w13 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w13);

		js.executeScript("arguments[0].click()", w13);

		pj.getEmail().sendKeys("user...email@domain.com");

		WebElement v13 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s13 = v13.getText();
		if (s13.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w14 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w14);

		js.executeScript("arguments[0].click()", w14);

		pj.getEmail().sendKeys("useremail.@domain.com");

		WebElement v14 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s14 = v14.getText();
		if (s14.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w15 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w15);

		js.executeScript("arguments[0].click()", w15);

		pj.getEmail().sendKeys("user@domain,com");

		WebElement v15 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s15 = v15.getText();
		if (s15.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w16 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w16);

		js.executeScript("arguments[0].click()", w16);

		pj.getEmail().sendKeys(
				"averyveryveryverylongusernamepartthatexceedsthenormalcharacterlimitfortheusernamepartoftheemailaddressjusttoensurethatthisemailislongenoughandwillnotfitintheusualformatwhichshouldcauseittobedeemedinvalidbecauseitseemswaytoobigtobeacceptedbyanysystemevenwithmodernemailvalidationsupport@averyveryveryverylongdomainnamepartthatexceedsthenormallimitforthenamepartoftheemailjusttoensureitgoesbeyondthe254characterslimit.com");

		WebElement v16 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s16 = v16.getText();
		if (s16.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w17 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w17);

		js.executeScript("arguments[0].click()", w17);

		pj.getEmail().sendKeys("awhd@gmail.com");

		WebElement v17 = driver.findElement(By.xpath("//div[text()=' Please use your Professional Email address ']"));
		String s17 = v17.getText();
		if (s17.equals("Please use your Professional Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Professional Phone

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w18 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w18);

		js.executeScript("arguments[0].click()", w18);

		pj.getTxtboxphone().sendKeys("888888888");

		WebElement v18 = driver.findElement(By.xpath("//div[text()=' Professional Phone is invalid ']"));
		String s18 = v18.getText();
		if (s18.equals("Professional Phone is invalid")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w19 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w19);

		js.executeScript("arguments[0].click()", w19);

		pj.getTxtboxphone().sendKeys("88888888888");

		WebElement v19 = driver.findElement(By.xpath("//div[text()=' Professional Phone is invalid ']"));
		String s19 = v19.getText();
		if (s19.equals("Professional Phone is invalid")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Password

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w20 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w20);

		js.executeScript("arguments[0].click()", w20);
		// less than 8 char
		pj.getPwd().sendKeys("1234");

		WebElement v20 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s20 = v20.getText();
		if (s20.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w21 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w21);

		js.executeScript("arguments[0].click()", w21);

		// only alphabets
		pj.getPwd().sendKeys("abcdefghij");

		WebElement v21 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s21 = v21.getText();
		if (s21.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
		/*
		 * driver.navigate().refresh();
		 * 
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		 * 
		 * WebElement w22 = pj.getFormSubmit();
		 * js.executeScript("arguments[0].scrollIntoView(true)", w22);
		 * 
		 * js.executeScript("arguments[0].click()", w22);
		 * 
		 * pj.getPwd().sendKeys(
		 * "averyverylongpasswordthatexceedsthemaximumallowedcharacterslength123456789K@"
		 * );
		 * 
		 * WebElement v22 = driver.findElement(By.
		 * xpath("//div[text()=' Password must not exceed 64 characters ']")); String
		 * s22 = v22.getText(); if
		 * (s22.equals("Password must not exceed 64 characters")) {
		 * 
		 * System.out.println("Passed"); } else {
		 * 
		 * System.out.println("Failed"); }
		 * 
		 */

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w23 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w23);

		js.executeScript("arguments[0].click()", w23);

		// No uppercase
		pj.getPwd().sendKeys("password123!");

		WebElement v23 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s23 = v23.getText();
		if (s23.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w24 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w24);

		js.executeScript("arguments[0].click()", w24);

		// No lowercase
		pj.getPwd().sendKeys("PASSWORD123!");

		WebElement v24 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s24 = v24.getText();
		if (s24.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w25 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w25);

		js.executeScript("arguments[0].click()", w25);

		// No numbers
		pj.getPwd().sendKeys("Password!@#");

		WebElement v25 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s25 = v25.getText();
		if (s25.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w26 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w26);

		js.executeScript("arguments[0].click()", w26);

		// No Special Character
		pj.getPwd().sendKeys("Password123");

		WebElement v26 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s26 = v26.getText();
		if (s26.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w27 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w27);

		js.executeScript("arguments[0].click()", w27);

		// All Special character
		pj.getPwd().sendKeys("!@#$%^&*()");

		WebElement v27 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s27 = v27.getText();
		if (s27.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w28 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w28);

		js.executeScript("arguments[0].click()", w28);

		// only numbers
		pj.getPwd().sendKeys("123456789");

		WebElement v28 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s28 = v28.getText();
		if (s28.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Password masked
		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w29 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w29);

		js.executeScript("arguments[0].click()", w29);

		WebElement pwd = pj.getPwd();
		pwd.sendKeys("123456");

		String str = pwd.getAttribute("type");

		if (str.equals("password")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		// Password unmasked

		pj.getEyepwd().click();

		WebElement strUnmasked = pj.getPwd();

		String str1 = strUnmasked.getAttribute("type");

		if (str1.equals("text")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		// Confirm Password

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w30 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w30);

		js.executeScript("arguments[0].click()", w30);

		pj.getPwd().sendKeys("Test@123");

		pj.getCpwd().sendKeys("Test");

		WebElement v30 = driver.findElement(By.xpath("//div[text()=' Password and Confirm Password must match ']"));
		String s30 = v30.getText();

		if (s30.equals("Password and Confirm Password must match")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// T&C Validation

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w31 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w31);

		js.executeScript("arguments[0].click()", w31);

		WebElement v31 = driver.findElement(
				By.xpath("//div[text()=' Please agree to the Terms of use & Privacy Policy before signing up ']"));

		String s31 = v31.getText();

		if (s31.equals("Please agree to the Terms of use & Privacy Policy before signing up")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that user entering only Account Name and tries to submit and the entered values shouldnt get clear")
	public void verify_that_user_entering_only_account_name_and_tries_to_submit_and_the_entered_values_shouldnt_get_clear() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();
		pj.getAccntName().sendKeys("Test");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement w31 = pj.getFormSubmit();

		js.executeScript("arguments[0].scrollIntoView(true)", w31);

		js.executeScript("arguments[0].click()", w31);

		WebElement w1 = pj.getAccntName();

		String str = w1.getAttribute("value");

		if (str.equals("Test")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that user entering only email with spaces and the space shouldnt accept")
	public void verify_that_user_entering_only_email_with_spaces_and_the_space_shouldnt_accept() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement w1 = pj.getEmail();
		w1.sendKeys("a v k @gmt.com");
		String s1 = w1.getAttribute("value");

		if (s1.equals("avk@gmt.com")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that the sign-up page contains placeholder text at mandatory fields")
	public void verify_that_the_sign_up_page_contains_placeholder_text_at_mandatory_fields() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		String p1 = pj.getFname().getAttribute("placeholder");
		if (p1.equals("Enter First Name")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p2 = pj.getlName().getAttribute("placeholder");
		if (p2.equals("Enter Last Name")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p3 = pj.getAccntName().getAttribute("placeholder");
		if (p3.equals("Enter Account Name")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p4 = pj.getAccntType().getText();
		if (p4.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p5 = pj.getEmail().getAttribute("placeholder");
		if (p5.equals("Enter Professional Email")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p6 = pj.getMarktServed().getText();
		if (p6.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p7 = pj.getDpmt().getText();
		if (p7.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p8 = pj.getTxtboxphone().getAttribute("placeholder");
		if (p8.equals("+1 201-555-0123")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p9 = pj.getInterest().getText();
		if (p9.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p10 = pj.getDiscoverMTAI().getText();
		if (p10.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p11 = pj.getPwd().getAttribute("placeholder");
		if (p11.equals("Enter Password")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p12 = pj.getCpwd().getAttribute("placeholder");

		if (p12.equals("Enter Confirm Password")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that dropdown should provide only Single select option")
	public void verify_that_dropdown_should_provide_only_single_select_option() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement slt = pj.getAccntType();
		slt.click();

		driver.findElement(By.xpath("//a[text()='Marketer']")).click();
	}

	@Given("Verify that if user clicks on the Signin button, user should redirect to Login page")
	public void verify_that_if_user_clicks_on_the_signin_button_user_should_redirect_to_login_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getRtnSignin();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);
		js.executeScript("arguments[0].click()", w1);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w2 = driver.findElement(By.xpath("//h3[text()='Sign in with email']"));
		String str = w2.getText();
		if (str.equals("Sign in with email")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			Assert.fail();

		}

	}

	@Given("Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page")
	public void verify_that_if_user_fills_all_the_mandatory_fields_it_has_to_redirect_to_otp_verification_page()
			throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		pj.getFname().sendKeys("Test");
		pj.getlName().sendKeys("Client");
		pj.getAccntName().sendKeys("Client1");
		Thread.sleep(1000);
		pj.getAccntType().click();
		driver.findElement(By.xpath("//a[text()='Marketer']")).click();

		// generate dummy email

		String uniqueID = UUID.randomUUID().toString().substring(0, 8);
		// System.out.println(uniqueID);
		pj.getEmail().sendKeys("testuser" + uniqueID + "@cucumber.com");

		driver.findElement(By.id("marketserved")).click();
		driver.findElement(By.xpath("//a[text()='B2B']")).click();
		pj.getCountryPhone().click();
		driver.findElement(By.id("country-search-box")).sendKeys("India");
		WebElement w1 = driver.findElement(By.xpath("//span[text()='+91']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", w1);
		pj.getTxtboxphone().sendKeys("9898787871");

		Thread.sleep(1000);
		pj.getDpmt().click();
		driver.findElement(By.xpath("//a[text()='Finance']")).click();

		pj.getInterest().click();
		driver.findElement(By.xpath("//a[text()='Data Visualization']")).click();

		pj.getDiscoverMTAI().click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

		pj.getPwd().sendKeys("Test@123");
		pj.getCpwd().sendKeys("Test@123");

		pj.getCheckboxtc().click();

		pj.getFormSubmit().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement otpPage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thanks for Signing Up!']")));

		String otpText = otpPage.getText();

		if (otpText.equals("Thanks for Signing Up!")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that OTP verification Page is in proper CSS format as per requirement")
	public void verify_that_otp_verification_page_is_in_proper_css_format_as_per_requirement() {

		/*
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		 * 
		 * OtpPojo pj=new OtpPojo(); WebElement butn = pj.getVerify();
		 * 
		 * String color = butn.getCssValue("background-color"); String font =
		 * butn.getCssValue("font-family");
		 * 
		 * 
		 * Assert.assertEquals("Verify the font", "AvenirNextLTPro-Regular", font);
		 * Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);
		 */
	}

	@Given("Verify that if user enters invalid OTP, it shouldn not accept and it has to show validation")
	public void verify_that_if_user_enters_invalid_otp_it_shouldn_not_accept_and_it_has_to_show_validation()
			throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		OtpPojo pj = new OtpPojo();

		// empty
		pj.getVerify().click();

		String s1 = driver.findElement(By.xpath("//div[text()='OTP is required']")).getText();
		if (s1.equals("OTP is required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// invalid otp

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement otpInput = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//h1[text()='Thanks for Signing Up!']/following::div[2]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * js.
		 * executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
		 * , otpInput); js.
		 * executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));"
		 * , otpInput);
		 */
		js.executeScript("arguments[0].value='1';", otpInput);

	}

	@Given("Verify that user can able to resend verification emails if needed.")
	public void verify_that_user_can_able_to_resend_verification_emails_if_needed() {

		OtpPojo pj = new OtpPojo();

		pj.getVerificationCode().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//p[text()='Please check your email for the verification code.']")));

		String S1 = driver.findElement(By.xpath("//p[text()='Please check your email for the verification code.']"))
				.getText();

		if (S1.equals("Please check your email for the verification code.")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("if user clicks on the Back to sign-up button in OTP verification page , he should be redirect to Sign-up page")
	public void if_user_clicks_on_the_back_to_sign_up_button_in_otp_verification_page_he_should_be_redirect_to_sign_up_page() {

		OtpPojo pj = new OtpPojo();
		pj.getRtnSignup().click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));

		SignupPojo pj1 = new SignupPojo();

		if (pj1.getFname().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the Signin button in OTP verification page , he should be redirect to Login page")
	public void verify_that_if_user_clicks_on_the_signin_button_in_otp_verification_page_he_should_be_redirect_to_login_page() {

		OtpPojo pj = new OtpPojo();
		pj.getRtnSignin().click();

		LoginPojo pj1 = new LoginPojo();

		if (pj1.getTxtboxemail().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that LOGO is present in the OTP verification Page")
	public void verify_that_logo_is_present_in_the_otp_verification_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		OtpPojo pj = new OtpPojo();
		if (pj.getLogo().isDisplayed()) {
			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		List<WebElement> texts = driver.findElements(By.xpath("//div[@class='box1']"));

		String s1 = "";
		List<String> li = new ArrayList<String>();

		String expectedText = "Try MADTechAI free for 15 days\n" + "Totally risk free. No commitment. Cancel anytime.\n"
				+ "Powerful iPaaS integration\n"
				+ "Transform disparate data on the fly with 300+ purpose-built connectors\n"
				+ "Pre-built analytics suite\n"
				+ "Access dozens of out-of-the-box data models, dashboards, and reports\n"
				+ "Conversational AI insights\n"
				+ "Get instant answers and visualizations using plain English queries\n" + "Flexible data ingestion\n"
				+ "Explore with our sample data or seamlessly integrate your own\n" + "Advanced marketing modeling\n"
				+ "Optimize strategy with our custom Marketing Mix Model (and hundreds more)\n"
				+ "Comprehensive data export\n" + "Download all data, graphics, and reports in your preferred format\n"
				+ "Free AWS data warehouse\n" + "Leverage our secure, scalable cloud infrastructure at no extra cost\n"
				+ "Always-on expert support\n"
				+ "Get 24/7/365 global support and access our thorough knowledge base anytime";

		for (WebElement line : texts) {
			s1 = line.getText();
			li.add(s1);
			System.out.println(s1);
		}

		String actualtext = String.join("\n", li);
		if (actualtext.equals(expectedText)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that email should be masked in OTP page")
	public void verify_that_email_should_be_masked_in_otp_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		OtpPojo pj = new OtpPojo();
		String str = pj.getMaskedEmail().getText();

		if (str.contains("***")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Check the response when providing an email address already registered")
	public void check_the_response_when_providing_an_email_address_already_registered() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		pj.getFname().sendKeys("Test");
		pj.getlName().sendKeys("Client");
		pj.getAccntName().sendKeys("Client1");
		Thread.sleep(1000);
		pj.getAccntType().click();
		driver.findElement(By.xpath("//a[text()='Marketer']")).click();

		pj.getEmail().sendKeys("testuser31e93154@cucumber.com");

		driver.findElement(By.id("marketserved")).click();
		driver.findElement(By.xpath("//a[text()='B2B']")).click();
		pj.getCountryPhone().click();
		driver.findElement(By.id("country-search-box")).sendKeys("India");
		WebElement w1 = driver.findElement(By.xpath("//span[text()='+91']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", w1);
		pj.getTxtboxphone().sendKeys("9898787871");

		Thread.sleep(1000);
		pj.getDpmt().click();
		driver.findElement(By.xpath("//a[text()='Finance']")).click();

		pj.getInterest().click();
		driver.findElement(By.xpath("//a[text()='Data Visualization']")).click();

		pj.getDiscoverMTAI().click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

		pj.getPwd().sendKeys("Test@123");
		pj.getCpwd().sendKeys("Test@123");

		pj.getCheckboxtc().click();

		pj.getFormSubmit().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement validation = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' This email address is already registered ']")));

		if (validation.getText().equals("This email address is already registered")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
		
	}
}
