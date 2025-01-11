package SpiceJetTest;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecifications;
import SpiceJetPages.HomePage;
import SpiceJetPages.SignUpPage;

public class SignUpTest extends ProjectSpecifications{
	
	HomePage homePage;
	SignUpPage signUpPage;	
	
	@BeforeTest
	public void setup() {
		excelFile = "/home/thrymr/eclipse-workspace/SpiceJet/src/test/java/Resources/TestData.xlsx";
		excelSheet = 1;
	}
	
	
	@Test(dataProvider = "getExcelData")
	public void SignUpTest(String fName,String lName, String DOB, String Number,String email, String password, 
			String ConfirmPassword) throws InterruptedException, AWTException {

		homePage = new HomePage(driver);
		click(homePage.signUpBtn);
		Thread.sleep(5000);
		switchWindows("https://spiceclub.spicejet.com/signup");
		
		signUpPage= new SignUpPage(driver);
		signUpPage.signUp(fName, lName, DOB, Number, email, password, ConfirmPassword);
		
		

	}
}
