package testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import objectRepo.LandingPaje_Object;
import utility.TestBase;
public class TestRunner extends TestBase {

	@Test(priority = 0)
	public static void addProduct() throws IOException {
		
		dWaitID(10, LandingPaje_Object.no_Offer_Needed_id);
		System.out.println("user is on landing page");
		driver.findElement(By.id(LandingPaje_Object.no_Offer_Needed_id)).click();
		dWaitClassName(10, LandingPaje_Object.location_class);
		driver.findElement(By.className(LandingPaje_Object.location_class)).sendKeys(readDataFromExcel("locationDetails", 1, 0));
		System.out.println("location entered");
		dWaitID(5, LandingPaje_Object.location_suggestionMainText_id);
		List<WebElement> ddSize = driver.findElements(By.id(LandingPaje_Object.location_suggestionMainText_id));
		for(int i=1;i<ddSize.size();i++)
		{
			if((LandingPaje_Object.dropdownList(i).getText()).equalsIgnoreCase(readDataFromExcel("locationDetails", 1, 0)))
			{
				LandingPaje_Object.dropdownList(i).click();
				break;
			}

		}
		dWaitID(10, LandingPaje_Object.collection_list_id);

		List<WebElement> productSize = driver.findElements(By.className(LandingPaje_Object.productImage_class));
		for (int i =1;i<productSize.size();i++)
		{
			if(LandingPaje_Object.getProductName(i).getText().equalsIgnoreCase(readDataFromExcel("locationDetails", 1, 1)))
			{
				LandingPaje_Object.addProduct(i).click();
				break;
			}
		}
		System.out.println("product selected");
		dWaitClassName(15, LandingPaje_Object.custoisation_class);
		LandingPaje_Object.selectItem1(readDataFromExcel("locationDetails", 1, 2)).click();
		driver.findElement(By.className(LandingPaje_Object.click_on_save_class)).click();

		LandingPaje_Object.selectItem2Base(readDataFromExcel("locationDetails", 1, 3)).click();
		WebElement web = driver.findElement(By.xpath("//*[@class='comboCustomisationName' and contains(string(),'"+readDataFromExcel("locationDetails", 1, 4)+"')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", web);
		driver.findElement(By.xpath("//*[@class='comboCustomisationName']/label[contains(text(),'"+readDataFromExcel("locationDetails", 1, 4)+"')]")).click();
		System.out.println("customisation done");
		driver.findElement(By.className(LandingPaje_Object.click_on_save_class)).click();
		dWaitID(5, LandingPaje_Object.clickOn_checkOut_id);
		System.out.println("clicked on checkOut");
		driver.findElement(By.id(LandingPaje_Object.clickOn_checkOut_id)).click();
		dWaitID(10, LandingPaje_Object.recommendedCart_id);
		driver.findElement(By.id(LandingPaje_Object.recommendedCart_id)).isDisplayed();
		System.out.println("Cart page displyed");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(LandingPaje_Object.verify_amount_test_xpath)));
		Assert.assertTrue(driver.findElement(By.xpath(LandingPaje_Object.verify_amount_test_xpath)).isDisplayed());


	}

	@Test(priority = 1)
	public static void verifySideMenu() throws InterruptedException {
		String menu = LandingPaje_Object.menu_xpath;
		System.out.println("verifying side menu");
		clickOnMenu(menu);
		driver.findElement(By.id(LandingPaje_Object.menu_inside_menu_id)).click();
		dWaitID(5, LandingPaje_Object.promotionalContainer_id);
		Assert.assertTrue(driver.findElement(By.id(LandingPaje_Object.promotionalContainer_id)).isDisplayed());
		dWaitXpath(10, menu);

		clickOnMenu(menu);
		dWaitID(5, LandingPaje_Object.party_order_id);
		driver.findElement(By.id(LandingPaje_Object.party_order_id)).click();

		dWaitClassName(5, LandingPaje_Object.partyOrdersContent_class);
		Assert.assertTrue(driver.findElement(By.className(LandingPaje_Object.partyOrdersContent_class)).isDisplayed());
		clickOnMenu(menu);
		dWaitID(5, LandingPaje_Object.terms_id);
		driver.findElement(By.id(LandingPaje_Object.terms_id)).click();

		dWaitClassName(5, LandingPaje_Object.terms_page_class);
		Assert.assertTrue(driver.findElement(By.className(LandingPaje_Object.terms_page_class)).isDisplayed());
		clickOnMenu(menu);
		dWaitID(5, LandingPaje_Object.privacy_id);
		driver.findElement(By.id(LandingPaje_Object.privacy_id)).click();
		dWaitClassName(5, LandingPaje_Object.privacy_content_class);
		Assert.assertTrue(driver.findElement(By.className(LandingPaje_Object.privacy_content_class)).isDisplayed());
		clickOnMenu(menu);
		driver.findElement(By.id(LandingPaje_Object.menu_inside_menu_id)).click();
		System.out.println("side meu verified");

	}


	@Test(priority = 2)
	public static void changeLocation() throws IOException, InterruptedException {
		String locationExcel = readDataFromExcel("locationDetails", 1, 5);
		driver.findElement(By.className(LandingPaje_Object.locationNameHeader_class)).click();
		dWaitClassName(10, LandingPaje_Object.location_class);
		System.out.println("New location entered");
		driver.findElement(By.className(LandingPaje_Object.location_class)).sendKeys(locationExcel);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//dWaitClassName(10, LandingPaje_Object.location_suggestionDescription_class);

		//dWaitXpath(10, LandingPaje_Object.location_suggestion_xpath);
		Thread.sleep(3000);
		driver.findElement(By.xpath(LandingPaje_Object.firstLocation_xpath)).click();
		//driver.findElement(By.id(LandingPaje_Object.location_suggestionMainText_id)).click();
		dWaitClassNameInvisibility(10, LandingPaje_Object.location_class);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);
		dWaitClassName(5, LandingPaje_Object.locationNameHeader_class);
		String loctaionText =driver.findElement(By.className(LandingPaje_Object.locationNameHeader_class)).getText();


		loctaionText = loctaionText.substring(0, locationExcel.length());
		Assert.assertEquals(locationExcel, loctaionText);
		System.out.println("new location verified");
	}
	public static void clickOnMenu(String e)
	{
		WebElement web = driver.findElement(By.xpath(e));
		dWaitXpath(5, e);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", web);
		web.click();

	}
}
