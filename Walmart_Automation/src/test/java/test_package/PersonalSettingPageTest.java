package test_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base_walmart;
import pomTest.PersonalSettingPage;
import pomTest.Pom_SignIn;
import utilities.testutils;

public class PersonalSettingPageTest extends Base_walmart {

	
	PersonalSettingPage log2;
	testutils utils;
	Pom_SignIn sign;
	public PersonalSettingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initiate2();
		sign=new Pom_SignIn();
	     utils=new testutils();
		log2=new PersonalSettingPage();
	sign.loginAsUser(prop.getProperty("uname"), prop.getProperty("pass"));
	
	driver.findElement(By.xpath("//span[text()='My account']")).click();
	utils.ScrollDown();
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='Profile Settings']")).click();
	
		
		
		
	}
	
	@Test(priority=1)
	public void editName()
	{driver.findElement(By.xpath("//button[text()='Edit']")).click();
		log2.EditName("jat", "sut");
		log2.clickOnSaveDetail();
	}
	
	@Test(priority=2)
	public void editpassword()
	{
		log2.ChangePassword("jatin1@", "Jatin@12345");
	}
	
	
	
	@Test(priority=3)
	public void changelanguage()
	{   
		utils.ScrollDown();
		log2.ClickOnEditLanguage();
		log2.changingLanguage();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
