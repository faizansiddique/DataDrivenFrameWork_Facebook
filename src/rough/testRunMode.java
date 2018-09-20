package rough;

import dd_util.Xls_Reader;

public class testRunMode {
	
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\TestData.xlsx");

	public static boolean isExecutable(String TestCase){
		
		for(int rownum=2;rownum<=excel.getRowCount("TestSuite");rownum++){
			if(excel.getCellData("TestSuite", "TestCase", rownum).equals(TestCase)){
				if(excel.getCellData("TestSuite", "runmode", rownum).equals("Y")){
				
					System.out.println(excel.getCellData("TestSuite", "runmode", rownum));
					return true;
				}
				else{
					return false;
				}
				}
			
		}
		return false;
	}
	public static void main(String[] args) {
		
		isExecutable("LoginTest");
		
	}

}
