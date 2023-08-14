package Pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Setup.Setup;

public class Snapdeal extends Setup
{
	List<WebElement> Productname;
	List<WebElement> price;
	public void openUrl()
	{
		 driver.get("https://www.snapdeal.com/");
	}
	public void searchItem()
	{
		driver.findElement(By.name("keyword")).sendKeys("Bluetooth headphone");
		driver.findElement(By.className("searchTextSpan")).click();
	}
	public void filterPrice()
	{
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("700");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1400");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
	}
	public void sortItem() throws InterruptedException
	{
		//WebElement element = driver.findElement(By.className("sort-label"));
		//Actions actions=new Actions(driver);
		//actions.moveToElement(element).click().build().perform();
				//driver.execute_script("arguments[0].click();", element)
		//WebDriverWait wait3=new WebDriverWait(driver,10);
		//wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.className("sort-label")));
		driver.findElement(By.className("sort-label")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plrty']")).click();	
		 // WebElement s2=driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/ul/li[2]"));
	       // s2.click();
	    Thread.sleep(2000);
	}
	public void getProductName()
	{
		 Productname=driver.findElements(By.className("product-title"));
	}
	public void getProductPrice()
	{
	price=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	}
	public void display()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println((i+1)+" "+Productname.get(i).getText());
			System.out.println(price.get(i).getText());
			System.out.println();
		}
	}
	public static void main(String[] args) throws InterruptedException{
		Snapdeal ha= new Snapdeal();
		ha.driverSetup();
		ha.openUrl();
		ha.searchItem();
		ha.filterPrice();
		ha.sortItem();
		ha.getProductName();
		ha.getProductPrice();
		ha.display();
		ha.closeBrowser();
	}
}
