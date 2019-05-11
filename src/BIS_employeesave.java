import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BIS_employeesave {

	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> notsavelist = new ArrayList<String>();
	static WebDriver driver;
	static int i;
	static String driverpath = "/home/indictrans/Documents/Rehan Pc backup/selenium data/chromedriver";

	public static void main(String[] args) {

		Readexcel();
		Activeemployee();

	}

	public static void Readexcel() {
		try {

			String excelFilePath = "/home/indictrans/Documents/Rehan Pc backup/KF (Mamta farm)/testscript/employeecode.xlsx";

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						// System.out.print(cell.getStringCellValue());
						list.add(cell.getStringCellValue());

						break;
					case Cell.CELL_TYPE_BOOLEAN:
						// System.out.print("R "+cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						// System.out.print("S2 "+cell.getNumericCellValue());
						break;
					}
					// System.out.print(" - ");
				}
				// System.out.println();
			}

			// System.out.println(list);

			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void Activeemployee() {
		try {
			// live password : PaG4nqmr

			int size = list.size();
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();

			driver.get("http://kf-bis.indictranstech.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.findElement(By.xpath(".//*[@id='login_email']")).sendKeys("administrator");
			driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("admin");
			driver.findElement(By.xpath(".//*[@id='page-login']/div/div/div[2]/section[1]/div[1]/form/button")).click();
			// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

			// driver.findElement(By.xpath("//*[@id=\"page-List/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div[1]/button/span")).click();

			for (i = 1; i<= size-1; i++) // itemcount
			{

				Thread.sleep(2000);			  
				driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/a[2]/img")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("navbar-search")).sendKeys("Employee List");
				Thread.sleep(1000);
				driver.findElement(By.id("navbar-search")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				// driver.findElement(By.xpath(".//*[@id='navbar-search']")).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(By.id("navbar-search")).sendKeys(Keys.ENTER);

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(list.get(i));// "G00384");//
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
				
				try
				{
				//click on employee 
				driver.findElement(By.xpath(
						"//*[@id=\"page-List/Employee\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a"))
						.click();
				
				Thread.sleep(1000);

				String  nsavetext= driver
						.findElement(By.xpath("//*[@id=\"page-Form/Employee\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[4]/div[2]/div[1]/form/div/div/div[2]/div[1]/select"))
						.getAttribute("value");
				
				//System.out.println("employee status   :" + nsavetext);
				
				if (nsavetext.equals("Active")) 
				{
					System.out.println(list.get(i)+" Already employee status --- " + nsavetext);
					
				}
				else
				{
					Thread.sleep(1000);
					System.out.println(list.get(i)+" Change employee status --- " + nsavetext);
					
					driver
					.findElement(By.xpath("//*[@id=\"page-Form/Employee\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[4]/div[2]/div[1]/form/div/div/div[2]/div[1]/select"))
					.sendKeys("Active");
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"page-Form/Employee\"]/div[1]/div/div/div[2]/button[2]/span"))
							.click();					
									
					Thread.sleep(1000);
					try
					{
						Thread.sleep(1000);
						String error=driver.findElement(By.xpath("//h4[contains(@class, 'modal-title') and text() = 'Message']")).getText();
						if(error.startsWith("Message"))
						{
								Thread.sleep(1000);
								driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[1]/div/div[2]/div/button[1]/span")).click();
								System.out.println("Message : Employee Save  :" + list.get(i));
							//	Thread.sleep(1000);
						}
					
					}
					catch (Exception e) {
						System.out.println("Exception Employee Save  :" + list.get(i));
						//System.out.println("Exception e" + e);
						// driver.quit();
					}
				}
				
				Thread.sleep(1000);
				
				}
				catch (Exception e) {
					System.out.println("\n Exception Employee in link click :" + list.get(i));
					//System.out.println("Exception e" + e);
					// driver.quit();
				}
			
				
			}
		}catch(

	Exception e)
	{
		System.out.println("Exception Employee  in is  :" + list.get(i));
		System.out.println("Exception e" + e);
		// driver.quit();
	}

	// System.out.println("Not save list is :" + notsavelist);
}

}