package Generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryExample implements IRetryAnalyzer {
int count=0;
int rtrylimit=4;
	public boolean retry(ITestResult result) {
		
		if(count<rtrylimit){
			count++;
			return true;
		}
		return false;
	}

}
