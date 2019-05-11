import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SaveItemList {

	public static void main(String[] args) {
	

			
				// TODO Auto-generated method stub
				 System.setProperty("webdriver.firefox.marionette","/media/90F0B819F0B8078C/Geetanjali_backups/geckodriver.exe");
				 WebDriver driver = new FirefoxDriver();      
			        
			     driver.get("http://uat.tria.indictranstech.com"); 
			     driver.manage().window().maximize();
			     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			     
			     //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			     driver.findElement(By.xpath(".//*[@id='login_email']")).sendKeys("administrator");
			     driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("admin");
			     driver.findElement(By.xpath(".//*[@id='page-login']/div/div/div[2]/section[1]/div[1]/form/button")).click();
			     driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
			     driver.findElement(By.xpath(".//*[@id='icon-grid']/div[1]/div[1]/i")).click(); 
			     driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
			     driver.findElement(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]")).sendKeys(Keys.PAGE_DOWN);
			     driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 
			     driver.findElement(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[6]/div/div[1]/div/button[3]")).click();
			     
			     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS); 
			     
			   //  int itemcount = driver.findElements(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a")).size();
			     //int itemcount = driver.findElements(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a"));
			//	 System.out.println("No. of items are :"+itemcount);
			    
				 driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS); 
				// driver.findElement(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]")).sendKeys(Keys.PAGE_DOWN);

				    
			    for(int i=1; i<=464; i++) //itemcount
			    {
			   //  WebElement item =(WebElement) driver.findElement(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div["+i+"]/div[1]/div[1]/a"));
			      driver.findElement(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div["+i+"]/div[1]/div[1]/a")).click();

			     // driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS); 
			   //  item.click();
			    //System.out.println("items are :"+item.getText());
			   /* if(i==20)
			    {
				     driver.findElement(By.xpath(".//*[@id='page-List/Item']/div[2]/div[2]/div/div[3]")).sendKeys(Keys.PAGE_DOWN);

			    }
			    */
			    driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS); 
			    
			   // item.click();
			    if(driver.findElement(By.xpath("//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span")).getText()=="Not Saved")
			    {
			    	driver.findElement(By.xpath(".//*[@id='page-Form/Item']/div[1]/div/div/div[2]/button[2]")).click();
			    	driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click();
			    	
			    }
			    
			    
			    }
			    
			    driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
			  //  System.out.println("No. of items are :"+itemcount);
			
			     
			  
			     
			}

		


	}


