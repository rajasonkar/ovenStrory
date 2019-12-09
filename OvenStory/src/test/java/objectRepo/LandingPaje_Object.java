package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.TestBase;

public class LandingPaje_Object extends TestBase{
public static String location_class= "locationSearchInput";
public static String location_dropDownTable_xpath = "//*[@id='root']/div/div/div/main/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div";
public static String location_suggestionMainText_id ="suggestionMainText";
public static String location_suggestion_xpath ="//*[@id='suggestionMainText' and @class='suggestionMainText']";
public static String collection_list_id="collectionContainer";
public static String product_list="productName";
public static String add_button_xpath="/html/body/div[1]/div/div[1]/div[3]/div[3]/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/a";
public static String no_Offer_Needed_id="wzrk-cancel";
public static String firstLocation_xpath ="/html/body/div[4]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]";
public static String product_name_id="addProductCombo";
public static String click_on_save_class ="comboCustomisationSetChangeContainer";
public static String clickOn_checkOut_id ="checkoutBtn";
public static String custoisation_class ="customisationProduct";
public static String recommendedCart_id ="recommendedCart";
public static String  verify_amount_test_xpath ="//*[contains(@class,'payAmountHeading bold')]";
public static String menu_xpath ="//*[@id='c_hamb']/a/span";
public static String promotionalContainer_id ="promotionalCarouselContainer";
public static String menu_inside_menu_id ="sb_col";
public static String party_order_id ="sb_po";
public static String partyOrdersContent_class ="partyOrdersContent";
public static String terms_id ="sb_tr";
public static String terms_page_class = "termsPage";
public static String privacy_id ="sb_pr";
public static String privacy_content_class ="privacyPage";
public static String locationNameHeader_class = "locationNameHeader";
public static String productImage_class ="productImageContainer";
public static WebElement dropdownList(int i)
{
return	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[1]/div/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div/div["+i+"]/div/div[2]/div[1]"));
}                                    
public static WebElement addProduct(int i)
{
return driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[3]/div/div/div/div[1]/div/div/div/div/div["+i+"]/div/div/div[2]/div/div/div[2]/div/div[2]/a"));	
}


public static WebElement getProductName(int i)
{
return driver.findElement(By.xpath("//*[@id='collectionContainer']/div/div["+i+"]/div/div/div[2]/div/div/div[1]/h2"));	
}

public static WebElement selectItem1(String itemName){
	return driver.findElement(By.xpath("//*[@class ='comboProductCustomisationName' and contains(text(),'"+itemName+"')]"));

}

public static WebElement selectItem2Base(String itemName){
	return driver.findElement(By.xpath("//*[@class='comboCustomisationName' and contains(string(),'"+itemName+"')]"));
	
	
}

	
	

}                                                 
		                                          
