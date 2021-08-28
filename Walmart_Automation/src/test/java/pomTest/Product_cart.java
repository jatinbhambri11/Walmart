package pomTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.Base_walmart;

public class Product_cart extends Base_walmart{
	
	@FindBy(xpath = "//button[@data-automation='increase-qty']") 
	WebElement AddQuantity;
	
	@FindBy(xpath = "//button[@data-automation='decrease-qty']")
	WebElement Minusquantity;
	
	@FindBy(xpath = "//button[@data-automation='cta-button']")
	WebElement AddtoCart;
	
	
	@FindBy(xpath = "//button[@data-automation='checkout']")
	WebElement checkout;
	
	public Product_cart() {
		PageFactory.initElements(driver, this);
	}
	
	public void quantityAndCart() throws InterruptedException {
		AddQuantity.click();
		Minusquantity.click();
		AddtoCart.click();
		Thread.sleep(2000);
		checkout.click();
	}

}
