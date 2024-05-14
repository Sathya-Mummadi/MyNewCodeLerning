package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;

import javax.swing.text.DateFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet  Sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  XSSFCellStyle style;
	String path;

	public XLUtility(String path) {
		this.path=path;	
	}
	
	 public int GetRowcount(String SheetName) throws IOException {
	 fis=new FileInputStream(path);
	 workbook= new XSSFWorkbook(fis);
     Sheet = workbook.getSheet(SheetName);
	 int Rowcount= Sheet.getLastRowNum();
	 workbook.close();
	 fis.close();
	return Rowcount;
	}
	
	public int GetCellcount(String SheetName, int rownum) throws IOException
	{
		 
			 fis=new FileInputStream(path);
			 workbook= new XSSFWorkbook(fis);
		     Sheet = workbook.getSheet(SheetName);
			  row= Sheet.getRow(rownum);
			  int cellcount=row.getLastCellNum();
			 workbook.close();
			 fis.close();
			 return cellcount;
		
	}
		
	public String getcellData(String SheetName, int rownum, int column) throws IOException {
		
		fis=new FileInputStream(path);
		 workbook= new XSSFWorkbook(fis);
	     Sheet = workbook.getSheet(SheetName);
	     row= Sheet.getRow(rownum);
	     cell=row.getCell(column);
	     
	     DateFormatter formatter= new DateFormatter();
	     String data;
	     
//	     try {
//			data=formatter.setFormat(cell);
//		} catch (Exception e) {
//			data=" ";
//		}
	     workbook.close();
		 fis.close();
		return SheetName;	
			 
		 }
	
}
