 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class TestRead {
	 static ArrayList<String> list=new ArrayList<String>();
    public static void main(String[] args) throws IOException {
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
                      //  System.out.print(cell.getStringCellValue());
                        list.add(cell.getStringCellValue());
                        
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print("R "+cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                     //   System.out.print("S2 "+cell.getNumericCellValue());
                        break;
                }
               // System.out.print(" - ");
            }
           // System.out.println();
        }
         
        
        System.out.println(list);
        
        workbook.close();
        inputStream.close();
    }
 
}