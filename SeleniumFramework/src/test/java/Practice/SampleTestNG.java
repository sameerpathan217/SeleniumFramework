package Practice;

import org.testng.annotations.Test;

public class SampleTestNG {
	@Test
	public void createContact() {
		int[] arr1= {1,5,9,8};
		System.out.println(arr1[3]);
		System.out.println("Contact Created");
	}
	@Test(dependsOnMethods="createContact")
	public void modifyContact() {
		System.out.println("Contact Modified");
	}
	@Test(dependsOnMethods="createContact")
	public void deleteContact() {
		System.out.println("Contact Deleted");
		//data
	}

}
