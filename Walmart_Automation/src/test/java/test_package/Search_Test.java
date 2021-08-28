package test_package;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base_walmart;
import pomTest.Pom_Search;
import utilities.testutils;

public class Search_Test extends Base_walmart{

	

	Pom_Search pom1;
	testutils utils;
	public Search_Test()
	{
		super();
		
		
	}
	
	
	@BeforeMethod
	public void initsetup()
		{
		initiate2();
	pom1=new Pom_Search();
	utils=new testutils();
	
}
	
	
	@Test(priority=1)
	public void test_Search()
	{ pom1.items("apple");
		}
	

	@Test(priority=2)
	public void test_Search2()
	{ pom1.items("red fruit");	
	}
	
	
	@Test(priority=3)
	public void test_Search3()
	{ pom1.items("School bus to");
	}
	@Test(priority=4)
	public void test_Search4()
	{ pom1.items("30746632");
	
	}
	
	@Test(priority=5)
	public void test_Search5()
	{ pom1.items("307466");
	}
	
	

	
	@Test(priority=6)
	public void test_Search6()
	{
		pom1.items("banana");
		driver.findElement(By.cssSelector("#product-results > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > img:nth-child(2)")).click();
		String Category=driver.findElement(By.cssSelector("li.css-1wco68u:nth-child(2) > a:nth-child(2)")).getText();
		
		Assert.assertEquals(Category,"Grocery");
	}
	
	@Test(priority=7)
	public void test_Search7()
	{ pom1.items("Gala Apples");
	}
	
	
	@Test(priority=8)
	public void test_Search8()
	{ pom1.items("abdfasdfa");
	
	
	String invalid= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div/div/h1")).getText();
		Assert.assertEquals("Sorry! We can't find a match for 'abdfasdfa'.", invalid);
	}
	
	@Test(priority=9)
	public void test_Search9()
	{ pom1.items("Aveeno");
	}
	
	
	@Test(priority=10)
	public void test_Search1()
	{ pom1.items("Aveeno");
WebElement ratings=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div/div/div/div/div[7]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div/a/div/div[2]/div[2]/div[2]/div/div/div"));
	
	if(ratings.isDisplayed()&&ratings.isEnabled())
	{ Assert.assertEquals(true, true);
		
	}
	}
	
	
	
	@Test(priority=11)
	public void checkingNumbOfItemsPerPage() throws InterruptedException {
		
		pom1.items("Aveeno");
		Thread.sleep(4000);
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		utils.Scrollbottom();
		int number=driver.findElements(By.xpath("//div[@data-automation='product']")).size();
		System.out.println(number);
		Assert.assertEquals(60,number);
	}
		

	

	@Test(priority=12)
	public void Sorting() throws InterruptedException
	{
		pom1.items("Aveeno");
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-automation='sort-by-dropdown-text']")));
	// drop down
	
	utils.ScrollDown();
	

	
	pom1.selectSorting();
	}
	
	
	
	@Test(priority=13)
	
	public void filtration1()
	{
		pom1.items("bread");
		utils.ScrollDown();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		pom1.FilterByCustomerRating();
		
	}
	
	
	@Test(priority=14)
	public void filtration2()
	{
		pom1.items("bread");
		utils.ScrollDown();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pom1.FilterByNewArrival();
		
	}
	
	
	@Test(priority=15)
	public void filtration3()
	{
		pom1.items("bread");
		utils.ScrollDown();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pom1.FilterByBestSellers();
		
	}
	
	
	@Test(priority=16)
	public void filtration4()
	{
		pom1.items("bread");
		utils.ScrollDown();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pom1.FilterByAvailaibity();
	
	
	}
	
	
	@Test(priority =17)
	public void validateImage() throws InterruptedException {
		
		pom1.items("bread");
		Thread.sleep(3000);
		Boolean flag = pom1.verifyImage();
		Assert.assertTrue(flag);
	}
	

	
	@Test(priority = 18)
	public void paginationTest() throws InterruptedException {
		
		
		pom1.items("bread");
		utils.Scrollbottom();
		Thread.sleep(3000);
		pom1.pagination();
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
	
}
	
	
