package test_package;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base_walmart;
import pomTest.PomLogin;

public class Test_Invalid_CreateAccount extends Base_walmart{ 
		
		PomLogin log;
		public Test_Invalid_CreateAccount()
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
		public void invalidFirstName1Test() {
			log.typefirstname("t");
			log.createbutton();
			String name1 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[2]/div/span")).getText();
					
			Assert.assertEquals(name1, "Please enter a valid first name.");
			//Assert.assertEquals(name1, "Enter a valid first name.", "Dosen't match with the requirement");
		}
		
		@Test(priority=2)
		public void invalidFirstName2Test() {
			log.typefirstname("1234");
			log.createbutton();
			String name2 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[2]/div/span")).getText();
					
			Assert.assertEquals(name2, "Please enter a valid first name.");
		}
		
		@Test(priority=3)
		public void blankFirstNameTest() {
			log.typefirstname("   ");
			log.createbutton();
			String name_blank = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[2]/div/span")).getText();
					
			Assert.assertEquals(name_blank, "Please enter your first name.");
			
		}
		
		@Test(priority=4)
		public void invalidLastName1Test() {
			
			log.typelastname("y");
			log.createbutton();
			String lastName1 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[3]/div/span")).getText();
					
			Assert.assertEquals(lastName1, "Please enter a valid last name.");
			
		}
		
		@Test(priority=5)
		public void invalidLastName2Test() {
			log.typelastname("1234");
			log.createbutton();
			String lastName2 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[3]/div/span")).getText();
					
			Assert.assertEquals(lastName2, "Please enter a valid last name.");
			
		}
		
		@Test(priority=6)
		public void blankLastNameTest() {
			log.typelastname("  ");
			log.createbutton();
			String blank_lastName = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[3]/div/span")).getText();
					
			Assert.assertEquals(blank_lastName, "Please enter your last name.");
		}
		
		@Test(priority=7)
		public void invalidPhoneNumberTest() {
			log.typephone("647860123");
			log.createbutton();
			String phoneNumber = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[4]/div[2]/span")).getText();
					
			Assert.assertEquals(phoneNumber, "Please enter a valid phone number.");
			
		}
		
		@Test(priority=8)
		public void invaEmailIdTest1() {
			log.typeemail("abcd");
			log.createbutton();
			String email1 = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[5]/div[2]/span")).getText();
					
			Assert.assertEquals(email1, "Please enter a valid email address.");
			
		}
		
		@Test(priority=9)
		public void blankPasswordTest(){
			log.typepass("");
			log.createbutton();
			String blankPassword = driver.findElement(By.xpath("//span[contains(text (), 'Password is a required field.')]")).getText();	
			Assert.assertEquals(blankPassword, "Password is a required field.");
			
		}
		
		@Test(priority=10)
		public void invalid_Password()
		{log.typepass("abcd");
		log.createbutton();
		String invalid_Password = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[2]/span")).getText();	
		Assert.assertEquals(invalid_Password, "Your password must be at least 6 characters long.");
			
		}
		
		
		
		
		@Test(priority=11)
		public void doNotClickTandCCheckBoxTest() {
			
			log.createbutton();
			String tandcCheckbox = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[9]/div/div[2]")).getText();
					
			Assert.assertEquals(tandcCheckbox, "You must read and accept Walmart’s Terms of Use to subscribe.");
			
		}
		
		@AfterMethod
		public void close()
		{
			driver.close();
		}

}
