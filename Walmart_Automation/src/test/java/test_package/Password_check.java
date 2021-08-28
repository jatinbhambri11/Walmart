package test_package;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base_walmart;
import pomTest.PomLogin;

public class Password_check extends Base_walmart {
	PomLogin log;
	public Password_check()
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
	public void valid_Password1()
	{log.typepass("abcdef");
	log.createbutton();
	String Strength1 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength1, "Password Strength: weak");
		
	}

	@Test(priority=2)
	public void valid_Password2()
	{log.typepass("123456");
	log.createbutton();
	String Strength2 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength2, "Password Strength: weak");
		
	}

	@Test(priority=3)
	public void valid_Password3()
	{log.typepass("@!@!@!");
	log.createbutton();
	String Strength3= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength3, "Password Strength: weak");
		
	}
	@Test(priority=4)
	public void valid_Password4()
	{log.typepass("abcd@!");
	log.createbutton();
	String Strength4= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength4, "Password Strength: moderate");
		
	}
	@Test(priority=5)
	public void valid_Password5()
	{log.typepass("abcdef@!");
	log.createbutton();
	String Strength5= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength5, "Password Strength: moderate");
		
	}
	@Test(priority=6)
	public void valid_Password6()
	{log.typepass("abcd23");
	log.createbutton();
	String Strength6= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength6, "Password Strength: moderate");
		
	}
	
	@Test(priority=7)
	public void valid_Password7()
	{log.typepass("abcd2312");
	log.createbutton();
	String Strength7= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength7, "Password Strength: moderate");
	
	
	}
	@Test(priority=8)
	public void valid_Password8()
	{log.typepass("1234@!");
	log.createbutton();
	String Strength8= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength8,"Password Strength: moderate");
		
		
	}
	@Test(priority=9)
	public void valid_Password9()
	{log.typepass("ab12@!");
	log.createbutton();
	String Strength9= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength9, "Password Strength: strong");
		
	}
	@Test(priority=10)
	public void valid_Password10()
	{log.typepass("1234@!12");
	log.createbutton();
	String Strength10= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]/span")).getText();	
	Assert.assertEquals(Strength10, "Password Strength: moderate");
		
	}


	
	
	
	
	
	
	
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
}
