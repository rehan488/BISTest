import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public void loginfun(WebDriver d) {
		try {
			String Url = "http://uat.tria.indictranstech.com/";
			
			//	"http://uat.kfhr.indictranstech.com";

			System.out.println("IN Login fun");
			d.get(Url);
			d.manage().window().maximize();
			d.findElement(By.id("login_email")).clear();
			d.findElement(By.id("login_email")).sendKeys("administrator");
			d.findElement(By.id("login_password")).clear();
			d.findElement(By.id("login_password")).sendKeys("admin");
			
			d.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[2]/section[1]/div[1]/form/button")).click();

			//d.findElement(By.xpath("//*[@id=\"page-login\"]/div/div/div[2]/section[1]/div[1]/form/button")).click();
		   //	ItemList.loginfun(d);
		   d.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[1]/div[1]")).click();
			
			
			//Thread.sleep(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
