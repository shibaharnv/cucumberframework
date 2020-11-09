
package stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Aconexhomepage_PF;
import pagefactory.Documentregisterpage_PF;
import pagefactory.Documentuploadpage_PF;
import pagefactory.Loginpage_PF;
import pagefactory.Mailpage_PF;
import utility.BrowserUtility;
import utility.PropertiesFileReader;

public class StepDefinition_PF extends utility.BrowserUtility {

	WebDriver driver = null;
	WebDriverWait wait = null;
	String projectpath;

	Loginpage_PF loginobj;

	Aconexhomepage_PF homepageobj;

	Mailpage_PF mailpageobj;

	Documentuploadpage_PF documentpageobj;

	Documentregisterpage_PF documentregisterpageobj;

	StringBuffer randomString;

	PropertiesFileReader obj = new PropertiesFileReader();

	@Given("Open the aconex application")
	public void open_the_aconex_application() throws InterruptedException, IOException {

		System.out.println("Open the aconex application");

		Properties properties = obj.getProperty();
		driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"),
				properties.getProperty("browser.baseURL"));
	}

	@When("login into the application with valid {string} username and {string} password")
	public void login_into_the_application_with_valid_username_and_password(String username, String password) {

		System.out.println("Entering username and password");
		System.out.println("Entering page factory login test class");

		loginobj = new Loginpage_PF(driver);

		loginobj.enterUsername(username);
		loginobj.enterPassword(password);
		loginobj.clickLogin();

	}

	@And("Navigate to blank mail section through page mail")
	public void navigate_to_blank_mail_section_through_page_mail() throws InterruptedException {
		System.out.println("Entering page factory mail click test class");
		homepageobj = new Aconexhomepage_PF(driver);
		homepageobj.mailtabclick();
		homepageobj.blankmailclick();
	}

	@And("Enter the required fields in mail page")
	public void enter_the_required_fields_in_mail_page() throws InterruptedException {

		mailpageobj = new Mailpage_PF(driver);

		System.out.println("Filling the details in mail page using page factory");

		driver.switchTo().frame("main");

		mailpageobj.setmailtype();
		mailpageobj.setsubject("testmailsubject");
		mailpageobj.attributeconfiguration();

	}

	@And("Set the receipient by clicking on directory button and navigate to global tab")
	public void set_the_receipient_by_clicking_on_directory_button_and_navigate_to_global_tab() {

		System.out.println("Clicking on directory button");

		mailpageobj.navigatetoglobaltab();

	}

	@And("Search for groupname and familyname and click on the ok button")
	public void search_for_groupname_and_familyname_and_click_on_the_ok_button() {

		System.out.println("Entering groupname and family name");

		mailpageobj.searchgroupfamilyname("Kenton", "Tillman");

	}

	@And("Click on send button")
	public void click_on_send_button() {

		mailpageobj.clickSendbutton();

	}

	@Then("Verify if the mail is sent as per the standard practices")
	public void verify_if_the_mail_is_sent_as_per_the_standard_practices() {

		mailpageobj.validateEmail();

	}

	@When("Navigate to documents and upload a new document")
	public void navigate_to_documents_and_upload_a_new_document() {
		homepageobj = new Aconexhomepage_PF(driver);
		homepageobj.opennewdocumentuploadpage();
	}

	@When("Enter the required fields and upload a document and verify and close")
	public void enter_the_required_fields_and_upload_a_document_and_verify_and_close()
			throws InterruptedException, AWTException, IOException {

		System.out.println("Entering the values in upload a document page.");

		driver.switchTo().frame("main");

		documentpageobj = new Documentuploadpage_PF(driver);

		documentpageobj.fillUploaddocumentpage();

	}

	@Then("Navigate to document register and search for the document and save and display it")
	public void navigate_to_document_register_and_search_for_the_document_and_save_and_display_it()
			throws InterruptedException {
		driver.switchTo().defaultContent();

		homepageobj = new Aconexhomepage_PF(driver);
		homepageobj.opendocregisterpage();

		Thread.sleep(5000);

		driver.switchTo().frame("main");

		documentregisterpageobj = new Documentregisterpage_PF(driver);

		documentregisterpageobj.savesearchas();

	}

}
