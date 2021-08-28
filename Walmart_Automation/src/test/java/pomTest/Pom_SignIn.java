package pomTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basePackage.Base_walmart;

public class Pom_SignIn extends Base_walmart {
	
	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement clicksignInDropDown;

	@FindBy(id = "username")
	WebElement enterUsername;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/form/div/div[7]/button")
	WebElement clickOnSignIn;

	@FindBy(xpath = "//span[contains (text (),'My account')]")
	WebElement myAccountPage;

	@FindBy(xpath = "//h1[text()='Welcome Jatin Bhambri']")
	WebElement userDetails;

	@FindBy(xpath = "//p[contains(text (),'Order History')]")
	WebElement userOrderHistoryPage;

	@FindBy(xpath = "//a[(text()='Profile Settings')]")
	WebElement userProfilePage;

	@FindBy(xpath = "//div[contains (text (), 'You currently have no orders to display.')]")
	WebElement orderHistoryMessage;

	@FindBy(xpath = "//button[text()='Start shopping']")
	WebElement startShoppingLink;

	@FindBy(xpath="//div[@data-automation='account-flyout-wrapper']")
	WebElement AccountFlyout;
	
	@FindBy(xpath = "//a[@href='/my-account/recommendations']")
	WebElement userRecommendation;

	@FindBy(xpath = "//span[contains (text (), 'Add to cart']")
	WebElement addToCart;
	
	public Pom_SignIn() {
		PageFactory.initElements(driver, this);
	}

	public void loginAsUser(String un, String pwd) {
		clicksignInDropDown.click();
		enterUsername.sendKeys(un);
		enterPassword.sendKeys(pwd);
		clickOnSignIn.click();

	}

	public String verifyMyAccountPage() {
		myAccountPage.click();
		String url = driver.getCurrentUrl();
		return url;

	}

	public String verifyUserDetails() {
		myAccountPage.click();
		String userinitials = userDetails.getText();
		return userinitials;
	}

	public void verifyUserOrderHistoryPage() {
		myAccountPage.click();
		userOrderHistoryPage.click();
		String a=orderHistoryMessage.getText();
		Assert.assertEquals(a,"You currently have no orders to display.");
	}
	
	public void myRecommendations() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(AccountFlyout).click(userRecommendation);
	
		userRecommendation.click();
		Thread.sleep(2000);
	
		
	}
	
	
	
	public void start_shopping()
	{
		myAccountPage.click();
		startShoppingLink.click();
	}

}
