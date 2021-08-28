package test_package;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base_walmart;
import pomTest.Pom_SignIn;

public class SignIn extends Base_walmart
{
	Pom_SignIn log1;
	public SignIn()
	{
		super();
		
		
	}
	
	@BeforeMethod
	public void initsetup()
		{
		initiate2();
	log1=new Pom_SignIn();
	log1.loginAsUser(prop.getProperty("uname"), prop.getProperty("pass"));
	
		
		
		
		}
	
	@Test(priority=1)
	public void verifyUserAccountPageTest(){
		String url = log1.verifyMyAccountPage();
		Assert.assertEquals(url, "https://www.walmart.ca/my-account");
		
	
	}
	
	@Test(priority=2)
	public void verifyUserDetailTest() {
		String userInitials = log1.verifyUserDetails();
		Assert.assertEquals(userInitials, "Welcome Jatin Bhambri");
		
	}
	
	
	@Test(priority=3)
	public void my_recomm() throws InterruptedException
	{
		log1.myRecommendations();
		String text=driver.findElement(By.xpath("//span[text()='You may like these top items']")).getText();
		Assert.assertEquals("You may like these top items", text);
	}
	
	
	@Test(priority=4)
	public void verifyUserOrderHistoryPageTest() {
		log1.verifyUserOrderHistoryPage();
	}
	
	@Test(priority=5)
	public void verifystartshopping()
	{
		log1.start_shopping();
	}
	
	
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	

}
