package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	public String baseUrl= "https://www.google.com/";

	  @BeforeTest
	 
	  @Parameters("browser")
		 public void setup(String browser) throws Exception{
				
				if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "D:/new path/geckodriver.exe");
					driver = new FirefoxDriver();
				}
				
				else if(browser.equalsIgnoreCase("chrome")){
					//set path to chromedriver.exe
					System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/path/browse/new/chromedriver.exe");
					  driver= new ChromeDriver();
			
						}
	
				
				  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	  }
	
  @Test
  public void TitleCheck() throws InterruptedException {
	  
		  driver.get(baseUrl);
		  driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Flipkart");
		 Thread.sleep(5000);
		 List <WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li[@role='presentation']/descendant::div[@class='sbl1']/span"));
		System.out.println(list.size());
		// Thread.sleep(3000);
		for(int i=0; i<list.size(); i++){
	
		System.out.println(list.get(i).getText());
		}
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']/center//input[@value='Google Search']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[@class='bkWMgd']//a[@href='https://www.flipkart.com/']")).click();

		driver.findElement(By.xpath("//div[@class='_3Njdz7']/button[@class='_2AkmmA _29YdH8']")).click();
		
		  Actions actions = new Actions(driver);
		
		WebElement Tv= driver.findElement(By.xpath("//li[@class='Wbt_B2 _1YVU3_']//span[contains(text(),'TVs & Appliances')]"));
		actions.moveToElement(Tv).build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Window ACs')]")).click();
		
		driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//a[1]//div[1]//div[2]//div[1]//span[1]//div[1]//label[1]//div[1]")).click();
		driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//a[1]//div[1]//div[2]//div[1]//span[1]//div[1]//label[1]//div[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'COMPARE')]")).click();
		
		
		List<WebElement> list2=driver.findElements(By.xpath("//div[@class='_1k1axX _1DLH7w']"));
	
		
		for(int i=0; i<list2.size(); i++){
			
			System.out.println(list2.get(i).getText());
			}
		
	  
	
  }
  
 
}
  