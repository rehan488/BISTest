import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

	static WebDriver d;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			String driverpath="/home/indictrans/Documents/Rehan Pc backup/selenium data/chromedriver";
			System. setProperty("webdriver.chrome.driver",driverpath);

			d = new ChromeDriver();
			
			Login l=new Login();
			l.loginfun(d);
			
			Thread.sleep(1000);
			//CreateBIS cb=new CreateBIS();
			//cb.BIS(d);
			
			User u=new User();
			u.Useredit(d);
			
			
			
			
					
			Thread.sleep(5000);
			d.close();
			d.quit();

		} catch (Exception e) {
			
			System.out.println("Error "+e);
			d.close();
			d.quit();
			

		}
	}

}
