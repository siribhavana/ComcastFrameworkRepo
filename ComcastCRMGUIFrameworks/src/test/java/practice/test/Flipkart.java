package practice.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart
{
	@Test
	public void flip() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.flipkart.com/");
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		List<WebElement> ele=driver.findElements(By.xpath("//a"));
		int no=ele.size();
		System.out.println(no);
		for(WebElement e:ele)
		{
			String value=e.getAttribute("href");
			if(value==null || value.isEmpty())
			{
				System.out.println("We can't check");
				continue;
			}
			URL urlobj=new URL(value);
			HttpURLConnection h=(HttpURLConnection)urlobj.openConnection();
			h.connect();
			if(h.getResponseCode()>=400)
			{
				System.out.println(value+" link "+h.getResponseCode()+" it is a broken link "+h);
			}
			else
			{
				System.out.println(value+" link"+h.getResponseCode()+" it is unbroken link "+h);
			}
			System.out.println(urlobj);
			//System.out.println(value);
		}
	}
}
