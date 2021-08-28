package test_package;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import basePackage.Base_walmart;
import pomTest.PomLogin;
import testdata.Excel_sheet;

public class Test_CreateAccount extends Base_walmart{ 
	
	PomLogin log;
	public Test_CreateAccount()
	{
		super();
		
		
	}
	
	@BeforeMethod
	public void initsetup()
		{
		initiate();
	log=new PomLogin();
		
		
		
		}
	
	
	@Test(priority=1)
	public void Title()
	{
		String b=log.Verify();
		Assert.assertEquals(b,"Walmart Canada");
		
	}

	@Test(priority=2)
	public void enterFirstNameTest() {
		log.typefirstname(prop.getProperty("FName"));
		
	}
	@Test(priority=3)
	public void enterLastNameTest() {
		log.typelastname(prop.getProperty("LName"));
	}
	@Test(priority=4)
	public void enterValidPhoneTest() {
		log.typephone(prop.getProperty("Phone"));
	}
	@Test(priority=5)
	public void enterValidEmailIdTest() {
		log.typeemail(prop.getProperty("EmailId"));
	}
	@Test(priority=6)
	public void enterPasswordTest() {
		log.typepass(prop.getProperty("Password"));
	}
	@Test(priority=7)
	public void clickOnMktngChkboxTest() {
		log.mPreference();
	}
	
	@Test(priority=8)
	public void clickOnTermsChkboxTest() {
		log.termsC();
	}
	
	@Test(priority=9)
	public void createAccountButtonTest() {
		log.createbutton();
	}
	
	
	
	@DataProvider
	public Object[][] details()
			{
		Object result[][]=Excel_sheet.readdata("Sheet1");
		return result;
			}
	
	/*
	@Test(priority=10,dataProvider="details")
	public void invalid_create_account(String firstname,String lastname,String phonenumber,String email,String password) throws InterruptedException
	{
		log.typefirstname(firstname);
		log.typelastname(lastname);
		log.typephone(phonenumber);
		log.typeemail(email);
		log.typepass(password);
		Thread.sleep(3000);
		
		//log.mPreference();
		//log.termsC();
		//log.createbutton();
		
		Thread.sleep(3000);
		
		
	} 
	
	*/
	@Test(priority=10)
	public void Password_Show()
	{
		log.typepass(prop.getProperty("Password"));
		log.show_Pass();
		String Pass1=driver.findElement(By.xpath("//*[@id=\"password\"]")).getText();
		Assert.assertEquals(Pass1,"Jatin@12345");
		
	}
	
	@Test(priority=11)
	public void valid_create_account() throws InterruptedException
	{
		log.typefirstname(prop.getProperty("FName"));
		log.typelastname(prop.getProperty("LName"));
		log.typephone(prop.getProperty("Phone"));
		log.typeemail(prop.getProperty("EmailId"));
		log.typepass(prop.getProperty("Password"));
		Thread.sleep(3000);
		
		log.mPreference();
		log.termsC();
		log.createbutton();
		
		Thread.sleep(3000);
		
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
	
	
}

