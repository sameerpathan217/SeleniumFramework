package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Exel_Utility;

public class DataProviderExample {
	@Test(dataProvider="ReadExcelDta")
	public void exceldata(String src, String destn) {
		System.out.println("Souce Location "+ src+ "  Destination Location  "+ destn);
		
	}
	
	
	
	@DataProvider
	public Object[][] ReadExcelDta() throws EncryptedDocumentException, IOException {
		Exel_Utility eu=new Exel_Utility();
		/*Object[][] obj=new Object[3][2];
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				String data = eu.getExcelDataFormatter("Sheet2", i, j);
				obj[i][j]=data;
			}
		}
		return obj;*/
		Object[][] data = eu.excelDatafetch("Sheet2");
		return data;
	}
}


 
 /*   @Test(dataProvider="readData")
	public void accessData(String src,String dest) {
		System.out.println("Source Name Is "+src +" Destination Is "+dest);
		
	}
	
@DataProvider	
public Object[][] readData() {
	Object[][] obj=new  Object[3][2];
	obj[0][0]="Mumbai";
	obj[0][1]="Pune";
	
	obj[1][0]="Benglore";
	obj[1][1]="Delhi";
	
	obj[2][0]="Chennai";
	obj[2][1]="Mumbai";
	
	return obj;
}	
	
	
	
	
	
	
}*/





//READ DATA FROM EXCEL SHEET
	