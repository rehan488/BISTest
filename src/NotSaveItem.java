import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NotSaveItem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String driverpath = "/home/indictrans/Documents/Rehan Pc backup/selenium data/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverpath);

		WebDriver driver = new ChromeDriver();

		driver.get("http://tria-group.indictranstech.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='login_email']")).sendKeys("administrator");
		driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("PaG4nqmr");
		driver.findElement(By.xpath(".//*[@id='page-login']/div/div/div[2]/section[1]/div[1]/form/button")).click();
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.id("navbar-search")).sendKeys("Item List");
		Thread.sleep(1000);
		driver.findElement(By.id("navbar-search")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		// driver.findElement(By.xpath(".//*[@id='navbar-search']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("navbar-search")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		
		
		//driver.findElement(By.xpath("//*[@id=\"page-List/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div[1]/button/span")).click();

		for (int i = 10; i <= 30; i++) // itemcount
		{
			
			/*driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).clear();
			driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys("M6X35MM S.S. SCREW");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(Keys.ENTER);*/
			Thread.sleep(1000);
			driver.findElement(By.xpath(
					".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div["
							+ i + "]/div[1]/div[1]/a"))
					.click();

			if (driver.findElement(By.xpath("//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span"))
					.getText() == "Not Saved") {
				
				String notsave=driver.findElement(By.xpath("//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span")).getText();
				System.out.println("notsave item is  :" + notsave);
				// driver.findElement(By.xpath(".//*[@id='page-Form/Item']/div[1]/div/div/div[2]/button[2]")).click();

				driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click();
				
				
				System.out.println("Value of i is :" + i);
				Thread.sleep(2000);
			} else {
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click();
				Thread.sleep(2000);
			}

		}

	}

}