import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven2Method {

	
		public ArrayList<String> getData(String testcaseName)
		{
			
		
		ArrayList<String> al = new ArrayList<String>();//creating array list to store data
		 FileInputStream fis = new FileInputStream("C:\\\\Users\\\\kumar\\\\Downloads\\\\ExcelDriven datasheet.xlsx");// permission to read the excel sheet
		 XSSFWorkbook workbook = new  XSSFWorkbook(fis);// create a object get hold of workbook
		
		  
		 int sheets = workbook.getNumberOfSheets();// hold of how many sheets in the workbook
		 for(int i=0;i<sheets;i++)
		 
			if (workbook.getSheetName(i).equalsIgnoreCase("Testdata"))
	 {
				  XSSFSheet sheet=  workbook.getSheetAt(i);
				  //identify testcases column in the entire row
				  Iterator <Row> rows =sheet.iterator(); //collection of rows is a sheet
				  Row firstrow=rows.next();
				  Iterator <Cell> ce= firstrow.cellIterator();//collection of cells is a row
				  int k=0;
				  int coloumn = 0;
				  while (ce.hasNext())
				  {
					 Cell value= ce.next();
					 if (value.getStringCellValue().equalsIgnoreCase("testcaseName"))
							 {
						       coloumn = k;
							 }
					 k++;
				  }
				  System.out.println(coloumn);
				  //once coloumn identified scan entire  testcase coloumn to identify purchase testcase row
				  while (rows.hasNext())
				  {
					  Row r=rows.next();
					  if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("purchase"))
							  {
						  		//grab your purchase test case column, pull all the data of that row
						       Iterator <Cell> ci = r.cellIterator();
						       while (ci.hasNext())
						       {
						    	   //System.out.println(ci.next().getStringCellValue());
						    	   al.add(ci.next().getStringCellValue()); //stored the data in Array list value in the a
						       }
							  }
				  }
				  return al;
			 
		 
		 
		 
		
	}

	
}


}