package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name="Data")
	
	public String[][] getAllData() throws IOException{
	 String path=System.getProperty("user.dir")+"//UserData.xlsx";
	 XLUtility utility=new XLUtility(path);
	 
	  int rownum=utility.GetRowcount("Sheet1");
	  int colcount=utility.GetCellcount("Sheet1",1);
	  
	  String apidata[][]= new String[rownum][colcount];
	  
	  for(int i=0; i<=rownum; i++) {
		  for(int j=0; j<colcount; j++) {
			  apidata[i-1][j]= utility.getcellData("Sheet1", i, j);
		  }
	  }
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUseName() throws IOException {
		String path=System.getProperty("user.dir")+"//testdata//Userdata.xlsx";
		XLUtility utility1= new XLUtility(path);
		 int rownumber= utility1.GetRowcount("Sheet1");		
		 String apidata[]= new String[rownumber];
		 
		 for(int i=1; i<rownumber; i++) {
			 apidata[i-1]=utility1.getcellData("Sheet",i, 1);
		 }
		 return apidata;
	}

}
