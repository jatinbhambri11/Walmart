package utilities;


	

	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;

import basePackage.Base_walmart;

	
	public class testutils extends Base_walmart {
	
		
		public static long page_timeout =20;
		public static long implicit_wait =20;
		
		
	
		
		
		public void ScrollDown() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
		}
		
		public void Scrollbottom() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		
		public static void takeScreenshotAtEndOfTest() throws IOException{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			
		}
	}


