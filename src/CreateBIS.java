import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateBIS {

	public void BIS(WebDriver d) {
		try {

			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@id=\"icon-grid\"]/div[1]/div[1]/i")).click();
			
			Thread.sleep(1000);
					
			d.findElement(By.xpath("//a[contains(@class, 'module-section-link small') and text() = ' BIS ']")).click();
			
			
			
			System.out.println("Create BIS form");

			//// *[@id="page-List/BIS"]/div[1]/div/div/div[2]/button[2]/span
			d.findElement(By.xpath("//*[@id=\"page-List/BIS\"]/div[1]/div/div/div[2]/button[2]/span")).click();
			Thread.sleep(1000);

			General(d);
			Financials(d);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void General(WebDriver d) {
		try {
			System.out.println("in General tab");
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='general_tab'] //*[@data-fieldtype='Button']")).click();
			
			d.findElement(By.xpath("//a[contains(@class, 'h6 uppercase') and text() = 'General']")).click();
			
			d.findElement(By.xpath("//a[contains(@class, 'h6 uppercase') and text() = 'Client Details (Billing will be done as per details below, hence fill in correctly and completely)']")).click();
			
			//Form Filling 
			
			d.findElement(By.xpath("//*[@data-fieldname='department_name'] //input[@type='text']")).sendKeys("Occupiers Solutions");
			
			d.findElement(By.xpath("//*[@data-fieldname='location'] //input[@type='text']")).sendKeys("Mumbai");
			
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='date'] //input[@type='text']")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='date'] //input[@type='text']")).clear();
			d.findElement(By.xpath("//*[@data-fieldname='date'] //input[@type='text']")).sendKeys("28-05-2018");
			
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='start_date'] //input[@type='text']")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='start_date'] //input[@type='text']")).clear();
			d.findElement(By.xpath("//*[@data-fieldname='start_date'] //input[@type='text']")).sendKeys("29-05-2018");
			
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='completion_date'] //input[@type='text']")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='completion_date'] //input[@type='text']")).clear();
			d.findElement(By.xpath("//*[@data-fieldname='completion_date'] //input[@type='text']")).sendKeys("30-05-2018");
			
			Thread.sleep(1000);
			
	     	d.findElement(By.xpath("//*[@data-fieldname='client_name'] //input[@type='text']")).sendKeys("Test");
			
			d.findElement(By.xpath("//*[@data-fieldname='address'] //textarea[@type='text']")).sendKeys("Test abc");
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='pin_code'] //input[@type='text']")).sendKeys("423150");
			
			
			d.findElement(By.xpath("//*[@data-fieldname='tel_no'] //input[@type='text']")).sendKeys("0201514251");
			
			d.findElement(By.xpath("//*[@data-fieldname='pan'] //input[@type='text']")).sendKeys("PANNOTAVLB");
			
			d.findElement(By.xpath("//*[@data-fieldname='primary_contact'] //input[@type='text']")).sendKeys("Test person");
			
			d.findElement(By.xpath("//*[@data-fieldname='description'] //textarea[@type='text']")).sendKeys("Test description");
			
			
			
			// Save Form 
			
			d.findElement(By.xpath("//span[contains(@class, 'hidden-xs') and text() = 'Save']")).click();
			Thread.sleep(3000);
			String bisfname =d.findElement(By.xpath("//*[@id=\"page-Form/BIS\"]/div[1]/div/div/div[1]/h1/div[2]")).getText();
			
			//	System.out.println("----"+bisfname);
			
			Thread.sleep(1000);
			if(bisfname.equals("New BIS 1"))
			{		
				System.out.println(" Not Saved "+bisfname);
			}
			else
			{
				System.out.println("BIS Assignment Deal No is "+bisfname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	public void Financials(WebDriver d) {
		try {
			String amount="520000";
			
			System.out.println("in Financials tab");
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='financials_tab'] //*[@data-fieldtype='Button']")).click();
			
			d.findElement(By.xpath("//a[contains(@class, 'h6 uppercase') and text() = 'Financials']")).click();
			
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@data-fieldname='total_fees'] //input[@type='text']")).clear();
			d.findElement(By.xpath("//*[@data-fieldname='total_fees'] //input[@type='text']")).sendKeys(amount);
			
			Thread.sleep(1000);
			
			String error=d.findElement(By.xpath("//h4[contains(@class, 'modal-title') and text() = 'Error']")).getText();
			if(error.equals(""))
			
			
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@id=\"page-Form/BIS\"]/div[2]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/div[2]/div[6]/div[2]/div/form/div[1]/div/div/div[2]/div[3]/div/div[1]/button[3]")).click();
			
			d.findElement(By.xpath("//*[@id=\"page-Form/BIS\"]/div[2]/div[2]/div/div[3]/div/div[1]/div[3]/div/div/div[2]/div[6]/div[2]/div/form/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/select")).sendKeys("Yes");
			
			d.findElement(By.xpath("//*[@data-fieldname='state_name'] //input[@type='text']")).sendKeys("Maharashtra");
			
			d.findElement(By.xpath("//*[@data-fieldname='gst_no'] //input[@type='text']")).sendKeys("EXPORTSERVICES1");
			
			d.findElement(By.xpath("//*[@data-fieldname='amount'] //input[@type='text']")).sendKeys(amount);
			
			

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	
	public void test(WebDriver d) {
		try {

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
