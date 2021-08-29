package pomTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import basePackage.Base_walmart;

public class Pom_Search extends Base_walmart{
	
	testutils utils=new testutils();
	@FindBy(css=".e1xoeh2i1")
	WebElement Search_key;
	
	@FindBy(css =".css-f72ea9" )
	WebElement Search;
	
	
	

	@FindBy(xpath = "(//img[@data-automation='image'])[3]")
	WebElement product_image;
	
	@FindBy(xpath="//div[@data-automation='sort-by-dropdown-text']")
	WebElement dropdown_sort;

	
	


	@FindBy(xpath = "//span[text()='Price: Low to High']")
	WebElement LPrice;
	
	@FindBy(xpath = "//span[text()='Price: High to Low']")
	WebElement HPrice;
	
	
	@FindBy(xpath = "//span[text()='Popular']")
	WebElement popular;
	
	@FindBy(xpath = "//span[text()='Newest']")  
	WebElement Newest;
	
	@FindBy(xpath = "//span[text()='Top Rated']")
	WebElement top_rated;
	
	@FindBy(xpath = "//select[@class='page-select']")
	WebElement rangeSelect;
	
	@FindBy(xpath="//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[2]/div[1]/div/div/div[4]/div/div/div/div[1]/button")
	WebElement customerRating;
	
	@FindBy(id="51")
	WebElement starFive;
	
	@FindBy(xpath="//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[2]/div[1]/div/div/div[7]/div/div/div/div[1]/button")
	WebElement newarrival;
	
	@FindBy(xpath="//label[@for='82002']")
	WebElement newarrival_checkbox;
	
	
	@FindBy(xpath="//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/button")
	WebElement Best_Sellers;
	
	@FindBy(id="40601")
	WebElement bestsellers_checkbox;
	
	@FindBy(xpath="//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[2]/div[1]/div/div/div[6]/div/div/div/div[1]/button")
	WebElement Availaibility;
	
	@FindBy(xpath="//label[@for='12']")
	WebElement instore;
	
	public Pom_Search() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void items(String a) {
		Search_key.sendKeys(a);
		Search.click();
		
		
	}

		public void pagination() {
		
	
		List<WebElement> page = driver.findElements(By.xpath("//div[@data-automation='product']"));
		System.out.println(page.size());
		WebElement NextButton= driver.findElement(By.xpath("//a[@data-automation='pagination-next-button']"));

		//WebElement prevButton= driver.findElement(By.xpath("//a[@data-automation='pagination-previous-button']"));

		// checkif pagination link exists
		if(page.size()>0)
		{ 
		System.out.println("pagination exists"); 

		// click on pagination link 

		for(WebElement p:page)
		{ 
			System.out.println(p.getText());
			System.out.println("          ");
			
					}
		//Check if nextbutton is enable or not.
		
		utils.ScrollDown();
		   if(NextButton.isEnabled())
		{

		    NextButton.click();
		    List<WebElement> page2 = driver.findElements(By.xpath("//div[@data-automation='product']"));
		    for(WebElement p2:page2)
		    {
		    	System.out.println(p2.getText());
				System.out.println("          ");
		    	
		    }
		    System.out.println("Products are duplicate" + page2.containsAll(page));
		}
		
		   
			}}

		
		

	public boolean verifyImage() {
		
		return product_image.isDisplayed();
	}
	
	public void selectSorting() throws InterruptedException {
		
		dropdown_sort.click(); 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		Newest.click();
		
		dropdown_sort.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		LPrice.click();
		
		dropdown_sort.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		HPrice.click();
		
		dropdown_sort.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		popular.click();
		
		dropdown_sort.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		top_rated.click();
		
		dropdown_sort.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(2000);
		popular.click();


		
	}
	
	public void FilterByCustomerRating() {
		customerRating.click();
		starFive.click();
	}
	
	public void FilterByNewArrival() {
		newarrival.click();
		newarrival_checkbox.click();
	}
	
	public void FilterByBestSellers() {
		Best_Sellers.click();
		bestsellers_checkbox.click();
	}
	public void FilterByAvailaibity() {
		Availaibility.click();
		instore.click();
	}
	
	
	
	
	

}



	
	
	
	



