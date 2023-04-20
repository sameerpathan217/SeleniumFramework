package Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
/*	@Test
	public void createContact() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");

		
	}
	@Test
	public void deleteContact() {
		System.out.println("Step6");
		System.out.println("Step7");
	}*/
	@Test
	public void validateString() {
		String expres="qspiders";
		String actres="qspiders";
	   Assert.assertEquals(expres, actres);
	}

}
