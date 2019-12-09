package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static WebDriver driver;
	static String excelPath = "src/test/resources/resources/Book1.xls";
	public static String chromeDriverPath = "src/test/resources/resources/chromedriver.exe";
	public static String firefoxDriverPath = "src/test/resources/resources/geckodriver.exe";
	public static WebDriverWait wait;
	static Workbook wb;

	static File file;
	static FileInputStream fis;
	static String fileExtn = null;
	
	@BeforeClass
	public static void setup() throws IOException {
		String browser = readDataFromExcel("login", 1, 3);
		String url = readDataFromExcel("login", 1, 0);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		/*else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
			driver = new FirefoxDriver();
		}*/
		else{System.out.println("Driver not found");

		System.exit(0);}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		driver.get(url);
		

	}

	public static String readDataFromExcel(String sheetName, int rowNo, int colNo) throws IOException {
		file = new File(excelPath);
		fis = new FileInputStream(file);
		fileExtn = excelPath.substring(excelPath.indexOf("."));
		if (fileExtn.contains("xlsx")) {
			// wb = new HSSFWorkbook(fis);
		} else if (fileExtn.contains("xls")) {
			wb = new HSSFWorkbook(fis);
		}
		Sheet s1 = wb.getSheet(sheetName);
		String data = s1.getRow(rowNo).getCell(colNo).getStringCellValue();
		return data;
	}


	public static void dWaitID(int seconds, String locator) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}
	public static void dWaitXpath(int seconds, String locator) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	public static void dWaitClassName(int seconds, String locator) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
	}
	public static void dWaitClassNameInvisibility(int seconds, String locator) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
	}

//@AfterClass
public void tearDown()
{
	driver.quit();
	
}

}
