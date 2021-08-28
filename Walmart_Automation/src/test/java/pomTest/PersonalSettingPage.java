package pomTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.Base_walmart;



	public class PersonalSettingPage extends Base_walmart {
		

		
		@FindBy(id = "firstName")
		WebElement EditFirstName;
		
		@FindBy(id = "lastName")
		WebElement EditLastName;
		
		@FindBy(id= "phoneNumber")
		WebElement EditPhone;
		
		@FindBy(name = "postalCode")
		WebElement EditPostalCode;
		
		@FindBy(xpath="//button[@data-automation='save-full-name']")
		WebElement saveDetail;
		
		@FindBy(xpath="(//button[@data-automation='edit-password'])[2]") 
		WebElement EditPassword;
		
		@FindBy(id = "currentPassword")
		WebElement oldPassword;
		
		@FindBy(id ="newPassword")
		WebElement newPassword;
		
		
		@FindBy(xpath= "(//button[@data-automation='update-password'])[2]")
		WebElement Update_Pass;
		
		@FindBy(xpath= "//*[@data-automation='edit-language-preference']")
		WebElement EditLanguage;
		
		@FindBy(name= "French")
		WebElement selectFrench;
		
		@FindBy(name="English")
		WebElement selectEnglish;
		
		@FindBy(xpath = "//button[@data-automation='save-language-preference']")
		WebElement saveLanguage;
		
		public PersonalSettingPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		
		public void EditName(String Fname, String Lname) {
			
			
			EditFirstName.clear();
			EditFirstName.sendKeys(Fname);
			EditLastName.clear();
			EditLastName.sendKeys(Lname);
			
		}
		public void clickOnSaveDetail() {
			saveDetail.click();
		}
		
		public void ClickOnEditPassword() {
			EditPassword.click();
		}
		
		public void ChangePassword(String oldpswd, String newpswd) {
			EditPassword.click();
			oldPassword.sendKeys(oldpswd);
			newPassword.sendKeys(newpswd);
			Update_Pass.click();
		}
		
		public void ClickOnEditLanguage() {
			
			EditLanguage.click();
		}
		
		public void changingLanguage() {
			String English = selectEnglish.getText();
			
			
			if(English.equals("English")) {
				selectFrench.click();
			}
			else {
				selectEnglish.click();
			}
			saveLanguage.click();
			
		}
		
	



}