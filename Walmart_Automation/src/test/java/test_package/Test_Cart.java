package test_package;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base_walmart;
import pomTest.Pom_Search;
import pomTest.Product_cart;
import utilities.testutils;

public class Test_Cart extends Base_walmart{
	
	Pom_Search search1;
	testutils utils;
	Product_cart Product1;
	
	public Test_Cart()
	{
		super();
		
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initiate2();
		search1=new Pom_Search();
		Product1= new Product_cart();
		utils=new testutils();
		
		
	}
	
	@Test
	public void cart_Functionality() throws InterruptedException
	{
		search1.items("bread");
		driver.findElement(By.xpath("//img[@data-automation='image']")).click();
		utils.ScrollDown();
		Product1.quantityAndCart();
		
	}
	
     @AfterMethod
	public void close()
	{
		driver.close();
	}
	
}
