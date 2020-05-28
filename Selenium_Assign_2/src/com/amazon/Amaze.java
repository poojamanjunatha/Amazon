package com.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amaze {
	public static void main(String[] args) throws InterruptedException {

		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sys\\Desktop\\Workspace\\Selenium_Assign_2\\driver1\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement searchbox= driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchbox.sendKeys("samsung Galaxy mobile");    
		    driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		   
		
		    List<String> allLinks = new ArrayList<String>();
		 List<WebElement> data = driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
		 System.out.println("total mobiles are =="+data.size());//total searches coming on the page
		 
		 for(int i=0;i<data.size();i++){
		  System.out.println(data.get(i).getText());//printing all samsung phones
		 
		 
		  List<String> allLinks1 = new ArrayList<String>();
		  List<WebElement> Rating = driver.findElements(By.xpath("//div[@class=\"sb_3XOrDvex\"]"));
		  System.out.println("Printng the rating =="+Rating.size());
		 //3. Click on the Items and displayed in the another window and 4. print the details in the console
		 
		 WebElement  item= driver.findElement(By.partialLinkText("Samsung Galaxy M21 (Midnight Blue, 6GB RAM, 128GB Storage"));
		 Actions newwin = new Actions(driver);
		 newwin.keyDown(Keys.SHIFT).click(item).keyUp(Keys.SHIFT).build().perform();

		 System.out.println("the details of an item is:"+item.getText());
		 for(String winHandle : driver.getWindowHandles()){
		 driver.switchTo().window(winHandle);
		// WebElement txt= driver.findElement(By.xpath("//*[@id=\"feature-bullets\"]/ul/li[1]/span")); 
		 //txt.getText();
		 //driver.close();
			   
  }
}
}
}





