package basePackage;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class Base_walmart{
		
		public static Properties prop=new Properties();
		public static WebDriver driver;
		
		public Base_walmart() 
		{
			try
			{
		
			
			FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\HRM\\src\\test\\java\\environmentVariables\\Config.properties"); 
			prop.load(file);
			}
			catch(FileNotFoundException e )
			{
				e.printStackTrace();
				
			}
		catch(IOException a)
			{
			a.printStackTrace();
			}
		
		
		}
		
		public static void  initiate()
		{
			String browser=prop.getProperty("browser");
			
			if(browser.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver" , "E:\\libs\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","chrome.exe");
				driver=new ChromeDriver();
			}
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); //implicit wait
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		public static void  initiate2()
		{
			String browser=prop.getProperty("browser");
			
			if(browser.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver" , "E:\\libs\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","chrome.exe");
				driver=new ChromeDriver();
			}
			
			driver.get(prop.getProperty("url2"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS); //implicit wait
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		}
		
		
	}

