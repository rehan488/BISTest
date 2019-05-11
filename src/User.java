import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class User {
	static ArrayList<String> list = new ArrayList<String>();

	public void Readexcel() {
		try {
			String excelFilePath = "/home/indictrans/Documents/Rehan Pc backup/selenium data/User.xlsx";
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

	public void Useredit(WebDriver d) {
		try {

			Readexcel();
			System.out.println("In User ");
			int size = list.size();
			System.out.println("Size of list " + size);

			for (int i = 0; i < size; i++) {
				
				
				Thread.sleep(1000);
				d.findElement(By.id("navbar-search")).clear();
				d.findElement(By.id("navbar-search")).sendKeys("User List");
				Thread.sleep(2000);
				d.findElement(By.id("navbar-search")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				// d.findElement(By.id("navbar-search")).sendKeys(Keys.ARROW_DOWN);
				d.findElement(By.id("navbar-search")).sendKeys(Keys.ENTER);

				// Thread.sleep(2000);
				
				/* * d.findElement(By.xpath(
				 * "//*[@id='page-List/User']/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/button"
				 * )) .click();*/
				 

				Thread.sleep(2000);
				d.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).clear();
				d.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(list.get(i));
				Thread.sleep(1000);
				d.findElement(By.xpath("//*[@data-fieldname='name'] //input[@type='text']")).sendKeys(Keys.ENTER);

				Thread.sleep(1000);

				d.findElement(By.xpath(
						"//*[@id=\"page-List/User\"]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/div[3]/div/div/div[1]/div[1]/a"))
						.click();

				Thread.sleep(3000);
				d.findElement(By.xpath("//*[@data-fieldname='last_name'] //input[@type='text']")).clear();
			//	d.findElement(By.xpath("//*[@data-fieldname='last_name'] //input[@type='text']")).sendKeys("Test");

				Thread.sleep(1000);
				d.findElement(By.xpath("//span[contains(@class, 'hidden-xs') and text() = 'Save']")).click();

				System.out.println("User Data Updated " + list.get(i));
				System.out.println("I ="+i);

				Thread.sleep(1000);
				d.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/a[2]")).click();
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
