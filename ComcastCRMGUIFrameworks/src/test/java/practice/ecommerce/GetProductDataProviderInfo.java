package practice.ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;

public class GetProductDataProviderInfo
{
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName,String title)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.className("a-button-text")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		Actions action=new Actions(driver);
		String x="//h2[contains(@aria-label,'"+title+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//descendant::span[@class='a-price-whole']";
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'"+title+"')]"))).build().perform();
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Exception
	{
		ExcelUtility eu=new ExcelUtility();
		int rowcnt=eu.getRowCount("Product");
		Object[][] obj=new Object[rowcnt][2];
		for(int i=0;i<=rowcnt-1;i++)
		{
			obj[i][0]=eu.getDataFromExcel("Product",i+1, 0);
			obj[i][1]=eu.getDataFromExcel("Product", i+1, 1);
		//We go for i+1 as 0 index is having the header so consider from 1 index
		}
		return obj;
	}
}
