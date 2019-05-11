import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemList {

	public static void loginfun(WebDriver d) throws Exception
	{
		System.out.println("In loginfun method");
		d.manage().wait(500);
		try {
		    d.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[1]/div[1]")).click();
			//d.findElement(By.className("case-wrapper")).click();
			
			//   /html/body/div[1]/div/div/div[1]/div[1]/div[1]/div[1]
			
		}
		catch(Exception e)
		{
		
			
		}
		}
	}

