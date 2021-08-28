package pomTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.Base_walmart;

public class PomLogin extends Base_walmart{
  
	
	//object repository
	@FindBy(id="firstName")  //driver.findelement
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div/form/div/div[10]/button")
	WebElement CreateAccount;
	 
	@FindBy(id="phoneNumber")
	WebElement Phonenumber;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="marketingPreference")
	WebElement Mpreference;
	
	@FindBy(id="TAndC")
	WebElement Terms;
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div/form/div/div[6]/div[1]/button/span")
	WebElement show;
	
	public PomLogin()
	{PageFactory.initElements(driver, this);
		
	}
	public void typefirstname(String fname)
	{
		firstname.sendKeys(fname);
		
	}
	public void typelastname(String lname)
	{
		lastname.sendKeys(lname);
		
	}
	
	public void typephone(String phone)
	{
		Phonenumber.sendKeys(phone);
		
	}
	public void typeemail(String email)
	{
		Email.sendKeys(email);
		
	}
	public void typepass(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void mPreference()
	{
		Mpreference.click();
	}
	
	public void termsC()
	{
		Terms.click();
	}
	
	public void createbutton()
	{
		CreateAccount.click();
	}
	
	public void show_Pass()
	{
		show.click();
	}
	public String Verify()
	{
		String a=driver.getTitle();
		return a;
	}
	
}
