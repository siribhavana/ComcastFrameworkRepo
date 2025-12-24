package practice.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoApps 
{
	@Test
	public void data()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		//List<WebElement> heading=driver.findElements(By.xpath("//thead[@class='text-xs text-gray-700 uppercase bg-orange-200']/descendant::th[@class='px-6 py-3']"));
		//int headingno=heading.size();

		//  for(WebElement h1:heading) { System.out.println(h1.getText()); }
		 
		/*
		 * for(int i=0;i<headingno;i++) { System.out.println(heading.get(i).getText());
		 * }
		 */
		/*
		 * Iterator<WebElement> it=heading.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next().getText()); }
		 */
		//td[position()=1] ->only 1st column
		//Only Odd column values
		List<WebElement> val=driver.findElements(By.xpath("//td[position() mod 2=1]"));
		for(WebElement h2:val)
		{
			System.out.println(h2.getText());
		}
		
		System.out.println("---------");
		//Only Even column values
				List<WebElement> val2=driver.findElements(By.xpath("//td[position() mod 2=0]"));
				for(WebElement h3:val2)
				{
					System.out.println(h3.getText());
				}
		
		/*
		 * List<WebElement> body=driver.findElements(By.xpath(
		 * "//table/thead/following-sibling::tbody/descendant::th/parent::tr")); int
		 * bodyno=body.size();
		 */
		/*
		 * Iterator<WebElement> it1=body.iterator(); while(it1.hasNext()) {
		 * System.out.println(it1.next().getText()); }
		 */
		/*
		 * for(int i=0;i<bodyno;i++) { System.out.println(body.get(i).getText()); }
		 */
		/*
		 * for(WebElement b:body) { System.out.println(b.getText()); }
		 */
		driver.quit();
	}
}
