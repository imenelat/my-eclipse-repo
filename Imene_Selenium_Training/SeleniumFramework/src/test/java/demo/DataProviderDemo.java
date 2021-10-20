package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	@DataProvider(name = "dataProvider1")
	   public Object[][] dataProviderMethod1() {
	      return new Object[][] {{"kuldeep","rana"}, {"k1","r1"},{"k2","r2"}};
	   }


	   //This method is bound to the above data provider returning 2D array of 3*2 matrix
	   //The test case will run 3 times with different set of values
	   @Test(dataProvider = "dataProvider1")
	   public void sampleTest(String s1, String s2) {
	      System.out.println(s1 + " " + s2);
	   }

}
