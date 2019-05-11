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

public class Trianotsave {
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> notsavelist = new ArrayList<String>();

	static ArrayList<String> uom1list = new ArrayList<String>();

	static ArrayList<String> taxlist = new ArrayList<String>();

	static WebDriver driver;
	static int i;
	static String driverpath = "/home/indictrans/Documents/Rehan Pc backup/selenium data/chromedriver";

	public static void main(String[] args) {

		Readexcel();
		Tnotsave();
		
		// DeleteUOM();
		//System.out.println("saved after script run = "+notsavelist);
		// System.out.println("uom1list = "+uom1list);
		// System.out.println("uom1list = "+taxlist);
	}

	public static void Tnotsave() {
		try {
			// live password : PaG4nqmr

			int size = list.size();
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();

			driver.get("http://uat.tria.indictranstech.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.findElement(By.xpath(".//*[@id='login_email']")).sendKeys("administrator");
			driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("admin");
			driver.findElement(By.xpath(".//*[@id='page-login']/div/div/div[2]/section[1]/div[1]/form/button")).click();
			// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

			// driver.findElement(By.xpath("//*[@id=\"page-List/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div[1]/button/span")).click();

			for (i = 1; i <= 1837; i++) // itemcount
			{

				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/a[2]/img")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("navbar-search")).sendKeys("Item List");
				Thread.sleep(1000);
				driver.findElement(By.id("navbar-search")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				// driver.findElement(By.xpath(".//*[@id='navbar-search']")).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(By.id("navbar-search")).sendKeys(Keys.ENTER);

				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(list.get(i));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"//*[@id=\"page-List/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a"))
						.click();
				// *[@id="page-List/Item"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a
				Thread.sleep(2000);

				String nsavetext = driver
						.findElement(By.xpath("//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span"))
						.getText();
				Thread.sleep(2000);
				if (nsavetext.equals("Not Saved")) {

					// String
					// notsave=driver.findElement(By.xpath("//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span")).getText();
					System.out.println("Notsave item is  :" + list.get(i));
					// save Item
					Thread.sleep(2000);
					driver.findElement(By.xpath(".//*[@id='page-Form/Item']/div[1]/div/div/div[2]/button[2]/span"))
							.click();

					
					Thread.sleep(1000);
					notsavelist.add(list.get(i));
					System.out.println(" after save");
					Thread.sleep(2000);
					/*String uomerror = driver
							.findElement(By.xpath("//h4[contains(@class, 'modal-title') and text() = 'Message']"))
							.getText();
					// System.out.println(" 123" + uomerror);
					if (uomerror.startsWith("Message")) {
						System.out.println("Error Message  for item " + list.get(i));
						Thread.sleep(1000);

						driver.findElement(
								By.xpath("/html/body/div[22]/div[2]/div/div[1]/div/div[2]/div/button[1]/span")).click();
						Thread.sleep(1000);
					}*/

					// *[@id="page-Form/Item"]/div[1]/div/div/div[2]/button[2]/span
					// driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click();
					
					//System.out.println("Value of i is :" + i);
					Thread.sleep(2000);
				} else {
					Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click();
					//System.out.println("other i is : " + i);
					Thread.sleep(2000);
				}
				System.out.println("value of is : " + i);
			}
		} catch (Exception e) {
			System.out.println("Exception item is  :" + list.get(i));
			System.out.println("Exception e" + e);
			// driver.quit();
		}

		 System.out.println("Not save list is :" + notsavelist);
	}

	public static void Readexcel() {
		try {
			// String excelFilePath = "/home/indictrans/Documents/Rehan Pc backup/Tria
			// Group/Item.xlsx";

			String excelFilePath = "/home/indictrans/Documents/Rehan Pc backup/Tria Group/Item List for Resave.xlsx";

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

	public static void DeleteUOM() {
		try {
			// live server pwd PaG4nqmr

			int size = list.size();
			System.out.println();
			String driverpath = "/home/indictrans/Documents/Rehan Pc backup/selenium data/chromedriver";
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();

			driver.get("http://uat.tria.indictranstech.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			driver.findElement(By.xpath(".//*[@id='login_email']")).sendKeys("administrator");
			driver.findElement(By.xpath(".//*[@id='login_password']")).sendKeys("admin");
			driver.findElement(By.xpath(".//*[@id='page-login']/div/div/div[2]/section[1]/div[1]/form/button")).click();
			// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

			// driver.findElement(By.xpath("//*[@id=\"page-List/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div[1]/button/span")).click();

			for (i = 1; i <= size - 1; i++) // itemcount
			{

				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/a[2]/img")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("navbar-search")).sendKeys("Item List");
				Thread.sleep(1000);
				driver.findElement(By.id("navbar-search")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				// driver.findElement(By.xpath(".//*[@id='navbar-search']")).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(By.id("navbar-search")).sendKeys(Keys.ENTER);

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(list.get(i));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.xpath(
						"//*[@id=\"page-List/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a"))
						.click();
				// *[@id="page-List/Item"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"//*[@id=\"page-Form/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[7]/div[1]/a"))
						.click();

				try {
					Thread.sleep(2000);
					// Delete item from row in child table
					driver.findElement(By.xpath(
							"//*[@id=\"page-Form/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[7]/div[2]/div/form/div/div/div/div[2]/div[1]/div[2]/div[1]/div[4]/a/span"))
							.click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(
							"//*[@id=\"page-Form/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[7]/div[2]/div/form/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/button[4]/i"))
							.click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(
							"//*[@id=\"page-Form/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[14]/div[1]/a"))
							.click();
					Thread.sleep(3000);
					try {
						String nodata = driver.findElement(By.xpath(
								"//*[@id=\"page-Form/Item\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[14]/div[2]/div/form/div/div/div/div[2]/div[2]"))
								.getText();

						System.out.println(" tax " + " " + nodata);
						Thread.sleep(2000);
						if (nodata.equals("No Data")) {
							System.out.println(" tax " + " " + nodata);
						} else {
							System.out.println(" tax " + list.get(i) + "  " + nodata);
						}
					} catch (Exception e1) {
						System.out.println("Exception item tax is  : " + list.get(i));
						taxlist.add(list.get(i));
						System.out.println("Tax found " + e1);
					}

				} catch (Exception e1) {
					System.out.println("Exception item is  :" + list.get(i));
					uom1list.add(list.get(i));
					System.out.println("duplicate UOM not found " + e1);
				}

				/*
				 * String nsavetext=driver.findElement(By.xpath(
				 * "//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span")).getText();
				 * Thread.sleep(1000); if (nsavetext.equals("Not Saved")) {
				 * 
				 * //String notsave=driver.findElement(By.xpath(
				 * "//*[@id='page-Form/Item']/div[1]/div/div/div[1]/h1/span/span")).getText();
				 * System.out.println("notsave item is  :" + list.get(i)); //save Item
				 * Thread.sleep(2000); driver.findElement(By.xpath(
				 * ".//*[@id='page-Form/Item']/div[1]/div/div/div[2]/button[2]/span")).click();
				 * System.out.println(" after save"); Thread.sleep(2000); String
				 * uomerror=driver.findElement(By.
				 * xpath("//h4[contains(@class, 'modal-title') and text() = 'Message']")).
				 * getText(); System.out.println(" 123"+uomerror);
				 * if(uomerror.startsWith("Message")) { // System.out.
				 * println("Unit of Measure Nos has been entered more than once in Conversion Factor Table"
				 * + list.get(i)); Thread.sleep(1000);
				 * 
				 * driver.findElement(By.xpath(
				 * "/html/body/div[22]/div[2]/div/div[1]/div/div[2]/div/button[1]/span")).click(
				 * ); Thread.sleep(1000); }
				 * //*[@id="page-Form/Item"]/div[1]/div/div/div[2]/button[2]/span
				 * driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click(
				 * ); Thread.sleep(1000); notsavelist.add(list.get(i));
				 * System.out.println("Value of i is :" + i); Thread.sleep(2000); } else {
				 * Thread.sleep(1000);
				 * driver.findElement(By.xpath(".//*[@id='navbar-breadcrumbs']/li[2]/a")).click(
				 * ); // System.out.println("other i is :" + i); Thread.sleep(2000); }
				 */

			}
		} catch (Exception e) {
			System.out.println("Exception item is  :" + list.get(i));
			System.out.println("Exception error" + e);

		}
	}

}