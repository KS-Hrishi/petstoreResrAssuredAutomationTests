package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {

	@DataProvider(name = "Data")
	public String [][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//UserApiData.xlsx";
		
		ExcelUtility util = new ExcelUtility(path);
		
		int totalrows = util.getRowCount("sheet1");
		int totalcols = util.getCellCount("sheet1", 1);
		
		String apidata[][] = new String[totalrows][totalcols]; 
		
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j= 0;j<totalcols;j++) 
			{
				apidata[i-1][j] = util.getCellData("sheet1", i, j);
			}
		}
		
		return apidata;
	}
	
	@DataProvider(name = "UserNames")
	public String [] getUserNames() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//UserApiData.xlsx";
		
		ExcelUtility util = new ExcelUtility(path);
		
		int totalrows = util.getRowCount("sheet1");
		
		
		String apidata[] = new String[totalrows];
		
		for(int i=1;i<=totalrows;i++) 
		{
			
		  apidata[i-1] = util.getCellData("sheet1", i, 1);
			
		}
		
		return apidata;
	}
	
}
