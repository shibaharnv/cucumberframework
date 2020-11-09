package pagefactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mailpage_PF {

	@FindBy(xpath = "//table[@id='typeSection']/tbody//td//select[@id='Correspondence_correspondenceTypeID']")
	WebElement dropdown_Type;

	@FindBy(xpath = "//input[@id='Correspondence_subject']")
	WebElement textbox_subject;

	@FindBy(xpath = "//div[@id='multiselect0']")
	WebElement attribute1box;

	@FindBy(xpath = "//div[@class='uiTextField uiField  uiIconField']")
	WebElement attributeelement1text;

	@FindBy(xpath = "//select[@multiple='multiple']")
	WebElement attributeelementvaluefirst;

	@FindBy(xpath = "//button[@id='attributeBidi_PRIMARY_ATTRIBUTE_add']")
	WebElement attributeelement1addbutton;

	@FindBy(xpath = "//div[@id='attributeBidi_SECONDARY_ATTRIBUTE']//select")
	WebElement attribute2box;

	@FindBy(id = "attributeBidi_SECONDARY_ATTRIBUTE_add")
	WebElement attributeelement2addbutton;

	@FindBy(xpath = "//button[@title='OK']")
	WebElement attributediaglogokbutton;

	@FindBy(xpath = "//div[@class='uiButton-content']//div[contains(text(), \"Directory\")]")
	WebElement directorybutton;

	@FindBy(xpath = "//*[@id='ACONEX_list']")
	WebElement globaltab;

	@FindBy(xpath = "//input[@id='FIRST_NAME']")
	WebElement groupname;

	@FindBy(xpath = "//input[@id='LAST_NAME']")
	WebElement familyname;

	@FindBy(xpath = "//div[@class='uiButton-content']//div[contains(text(), \"Search\")]")
	WebElement mailSearchbutton;

	@FindBy(xpath = "//input[@name='USERS_LIST']")
	WebElement resultcheckbox;

	@FindBy(xpath = "//div[@class='uiButton-content']//div[contains(text(), \"To\")]")
	WebElement Tobutton;

	@FindBy(xpath = "//div[@id='recipients']//div[contains(text(), \"Remove\")]")
	WebElement removetext;

	@FindBy(xpath = "//button[@id='btnOk']")
	WebElement okbuttonmail;

	@FindBy(xpath = "//div[contains(text(),'Send')]")
	WebElement mailsendbutton;

	@FindBy(xpath = "//div[@class='auiToolbar fixed noprint']//h1[contains(text(),'View Mail')]")
	WebElement viewmailtext;

	@FindBy(xpath = "//div[@class='auiDetails-value mailAttributes-value ng-binding']")
	WebElement mailattributevalue;

	@FindBy(xpath = "//button[contains(text(),'Forward')]")
	WebElement mailforwardbutton;

	@FindBy(xpath = "//button[contains(text(),'Reply')]")
	WebElement mailreplybutton;

	WebDriver driver;
	WebDriverWait wait;

	public Mailpage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void setmailtype() {

		wait.until(ExpectedConditions.elementToBeClickable(dropdown_Type));
		Select dropdownmailtype = new Select(dropdown_Type);
		dropdownmailtype.selectByIndex(1);

	}

	public void setsubject(String subjectvalue) {
		wait.until(ExpectedConditions.elementToBeClickable(textbox_subject));
		textbox_subject.sendKeys(subjectvalue);
	}

	public void attributeconfiguration() {
		wait.until(ExpectedConditions.elementToBeClickable(attribute1box));
		attribute1box.click();
		wait.until(ExpectedConditions.elementToBeClickable(attributeelementvaluefirst));
		Select dropdownattribute1 = new Select(attributeelementvaluefirst);
		dropdownattribute1.selectByIndex(2);
		attributeelement1addbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(attribute2box));
		Select dropdownattribute2 = new Select(attribute2box);

		dropdownattribute2.selectByIndex(2);
		attributeelement2addbutton.click();
		attributediaglogokbutton.click();
	}

	public void navigatetoglobaltab() {
		wait.until(ExpectedConditions.elementToBeClickable(directorybutton));
		directorybutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(globaltab));
		globaltab.click();
	}

	public void searchgroupfamilyname(String groupnames, String familynames) {

		wait.until(ExpectedConditions.elementToBeClickable(groupname));
		groupname.sendKeys(groupnames);
		wait.until(ExpectedConditions.elementToBeClickable(globaltab));
		familyname.sendKeys(familynames);
		wait.until(ExpectedConditions.elementToBeClickable(mailSearchbutton));
		mailSearchbutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(resultcheckbox));
		resultcheckbox.click();
		Boolean checkboxselect = resultcheckbox.isSelected();
		if (checkboxselect.equals(false)) {
			resultcheckbox.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(Tobutton));
		Tobutton.click();

		wait.until(ExpectedConditions.visibilityOf(removetext));
		wait.until(ExpectedConditions.elementToBeClickable(okbuttonmail));
		okbuttonmail.click();

	}

	public void clickSendbutton() {

		wait.until(ExpectedConditions.elementToBeClickable(mailsendbutton));
		mailsendbutton.click();

	}

	public void validateEmail() {
		// checking if view mail text is displayed
		wait.until(ExpectedConditions.visibilityOf(viewmailtext));
		Assert.assertTrue(viewmailtext.isDisplayed());

		// validating forward and reply to button
		wait.until(ExpectedConditions.visibilityOf(mailforwardbutton));
		Assert.assertTrue(mailforwardbutton.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(mailreplybutton));
		Assert.assertTrue(mailreplybutton.isDisplayed());

	}

}
