package pagefactory;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Documentuploadpage_PF {

	@FindBy(xpath = "//input[@id='docno_0']")
	WebElement txt_documentnumber;
	@FindBy(xpath = "//input[@name='revision_0']")
	WebElement txt_revision;
	@FindBy(xpath = "//input[@name='title_0']")
	WebElement txt_doctitle;

	@FindBy(xpath = "//select[@id='doctype_0']")
	WebElement drpdown_doctype;

	@FindBy(xpath = "//select[@id='docstatus_0']")
	WebElement drpdown_docstatus;

	@FindBy(xpath = "//select[@id='discipline_0']")
	WebElement drpdown_docdiscipline;

	@FindBy(xpath = "//select[@id='vdrcode_0']")
	WebElement drpdown_docvdrcode;

	@FindBy(xpath = "//select[@id='category_0']")
	WebElement drpdown_doccategory;

	@FindBy(xpath = "//div[@id='attribute1_0']")
	WebElement docattribute1box;

	@FindBy(xpath = "//div[@class='uiTextField uiField  uiIconField']")
	WebElement docattributeelement1;

	@FindBy(xpath = "//div[@id='attribute1_0_bidi']//select")
	WebElement docattributeelementvalue1;

	@FindBy(xpath = "//button[@id='attribute1_0_bidi_add']")
	WebElement docattributeelementaddbutton1;

	@FindBy(xpath = "//button[@title='OK']")
	WebElement docattributeokbutton1;

	@FindBy(xpath = "//div[@id='attribute2_0']")
	WebElement docattribute2box;

	@FindBy(xpath = "//div[@id='attribute2_0_bidi']")
	WebElement docattributeelement2;

	@FindBy(xpath = "//div[@id='attribute2_0_bidi']//select")
	WebElement docattributeelementvalue2;

	@FindBy(id = "attribute2_0_bidi_add")
	WebElement docattributeelementaddbutton2;

	@FindBy(xpath = "//button[@id='attribute2_0_panel-commit']")
	WebElement docattributeokbutton2;

	@FindBy(xpath = "//div[contains(@class, 'uiButton-label') and text()='Choose source']")
	WebElement btn_docchosesourcebutton;

	@FindBy(xpath = "//div[contains(@class, 'uiMenu-label') and text() = 'Upload file from your computer']")
	WebElement btn_docuploadfromcomputer;

	@FindBy(xpath = "//input[@name='printsize_0']")
	WebElement txt_docprintsize;

	@FindBy(xpath = "//div[contains(@class, 'uiButton-label') and text() = 'Upload']")
	WebElement btn_uploadbutton;

	@FindBy(xpath = "//*[contains(@class, 'actionGuide-actionTitle textlink') and text() = 'View in the document register']")
	WebElement docviewinregistertext;

	WebDriver driver;
	WebDriverWait wait;

	public Documentuploadpage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void fillUploaddocumentpage() throws IOException, InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(txt_documentnumber));
		txt_documentnumber.sendKeys("456");
		txt_revision.sendKeys("789");
		txt_doctitle.sendKeys("doctitle");

		wait.until(ExpectedConditions.elementToBeClickable(drpdown_doctype));
		Select dropdowndoctype = new Select(drpdown_doctype);
		dropdowndoctype.selectByIndex(1);

		Select dropdowndocstatus = new Select(drpdown_docstatus);
		dropdowndocstatus.selectByIndex(1);

		Select dropdowndocdispline = new Select(drpdown_docdiscipline);
		dropdowndocdispline.selectByIndex(1);

		Select dropdownvdrcode = new Select(drpdown_docvdrcode);
		dropdownvdrcode.selectByIndex(1);

		Select dropdowndoccategory = new Select(drpdown_doccategory);
		dropdowndoccategory.selectByIndex(1);

		wait.until(ExpectedConditions.elementToBeClickable(docattribute1box));
		docattribute1box.click();
		wait.until(ExpectedConditions.elementToBeClickable(docattributeelement1));
		wait.until(ExpectedConditions.elementToBeClickable(docattributeelementvalue1));
		Select dropdowndocattrivalue1 = new Select(docattributeelementvalue1);
		dropdowndocattrivalue1.selectByIndex(2);
		wait.until(ExpectedConditions.elementToBeClickable(docattributeelementaddbutton1));
		docattributeelementaddbutton1.click();
		wait.until(ExpectedConditions.elementToBeClickable(docattributeokbutton1));
		docattributeokbutton1.click();
		wait.until(ExpectedConditions.elementToBeClickable(docattribute2box));
		docattribute2box.click();
		wait.until(ExpectedConditions.elementToBeClickable(docattributeelement2));
		wait.until(ExpectedConditions.elementToBeClickable(docattributeelementvalue2));
		Select dropdowndocattrivalue2 = new Select(docattributeelementvalue2);
		dropdowndocattrivalue2.selectByIndex(2);
		wait.until(ExpectedConditions.elementToBeClickable(docattributeelementaddbutton2));
		docattributeelementaddbutton2.click();
		wait.until(ExpectedConditions.elementToBeClickable(docattributeokbutton2));
		docattributeokbutton2.click();

		wait.until(ExpectedConditions.elementToBeClickable(btn_docchosesourcebutton));
		btn_docchosesourcebutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_docuploadfromcomputer));
		btn_docuploadfromcomputer.click();
		Thread.sleep(5000);
		fileupload();
		wait.until(ExpectedConditions.elementToBeClickable(txt_docprintsize));
		txt_docprintsize.sendKeys("30");
		wait.until(ExpectedConditions.elementToBeClickable(btn_uploadbutton));
		btn_uploadbutton.click();
		wait.until(ExpectedConditions.visibilityOf(docviewinregistertext));

		Assert.assertTrue(docviewinregistertext.isDisplayed());

	}

	public void fileupload() throws IOException, InterruptedException {
		String myprojectpath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",
				myprojectpath + "//src//test//resources//drivers//chromedriver.exe");

		Runtime.getRuntime().exec(myprojectpath + "\\projectfiles\\Fileupload.exe");
		Thread.sleep(3000);

	}

}
