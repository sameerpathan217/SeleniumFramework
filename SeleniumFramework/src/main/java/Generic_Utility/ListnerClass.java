package Generic_Utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		
		EventFiringWebDriver ef=new EventFiringWebDriver(BasClass.sdriver);
		File src = ef.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+name+".png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
