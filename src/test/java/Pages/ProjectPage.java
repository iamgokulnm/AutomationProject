package Pages;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.io.FileHandler;

public class ProjectPage 
{
	WebDriver driver;
	By email=By.xpath("//*[@id=\"userEmail\"]");
	By password=By.id("password");
	By status=By.xpath("//*[@id=\"experienceLevelContainer\"]/div/label[2]/span");
	By account=By.xpath("//*[@id=\"submitBtn\"]/span[1]");
	
	
	public ProjectPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void registration(String username,String pwrd)
	{
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwrd);
		driver.findElement(status).click();
		driver.findElement(account).click();
	}
	
	public void Titleverification()
	{
	   String Title=driver.getTitle();
	   System.out.println(Title);
	   String Expectedtitle="Job Seeker Registration";
	   if(Title.equalsIgnoreCase(Expectedtitle))
	   {
		   System.out.println("The title is matched");
	   }
	   else
	   {
		   System.out.println("The title is not matched");
	   }
	}
	
	public void pageverification()
	{
		String page=driver.getPageSource();
		if(page.contains("Google"))
		{
			System.out.println("The content is available");
		}
		else
		{
			System.out.println("The content is not available");
		}
	}
	
	public void screenshot() throws Exception
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(image, new File("D:\\pic.png"));
	}
	
	public void singlescreenshot() throws Exception
	{
		By fileelement=By.xpath("//*[@id=\"fbReg\"]/span[2]");
		WebElement photo=driver.findElement(fileelement);
		File storage=photo.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(storage, new File("./Photo//screenshotimage.png"));
	}
	
	public void linkvalidation() throws Exception
	{
		String link="https://www.naukrigulf.com/register/?expName=expa&source=dtop_login_layer";
		URL obj=new URL(link);
		HttpsURLConnection connection=(HttpsURLConnection)obj.openConnection();
		connection.connect();
		if(connection.getResponseCode()==200)
		{
			System.out.println("The link is valid");
		}
		else
		{
			System.out.println("The link is invalid");
		}
	}
	
	public void textverification()
	{
		By text=By.xpath("//*[@id=\"resman\"]/div/div[1]/h4");
		WebElement word=driver.findElement(text);
		String letter=word.getText();
		if(letter.equalsIgnoreCase("create your account"))
		{
			System.out.println("The text is verified");
		}
		else
		{
			System.out.println("The text is not verified");
		}
	}
	
	public void buttonverification()
	{
		WebElement button=driver.findElement(account);
		String text=button.getText();
		if(text.equals("Create Account for Free"))
		{
			System.out.println("The button is verified");
		}
		else
		{
			System.out.println("The button is not verified");
		}
	}
	
	public void mutiplelinkvalidation()
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement A:links)
		{
			String datas=A.getAttribute("href");
			Verify(datas);
		}
	}
	public void Verify(String datas)
	{
		try
		{
			URL li=new URL("https://www.naukrigulf.com/register/?expName=expa&source=dtop_login_layer");
			HttpsURLConnection security=(HttpsURLConnection)li.openConnection();
			security.connect();
			if(security.getResponseCode()==200)
			{
				System.out.println("The link is valid");
			}
			else if(security.getResponseCode()==404)
			{
				System.out.println("The link is broken");
			}
			
		}
		catch(Exception Z)
		{
			System.out.println(Z.getMessage());
		}
		
	}
	
	public void scrolldown() throws Exception
	{
		Thread.sleep(600);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3200)");
	}
	
	public void Scrolldown2() throws Exception
	{
		Thread.sleep(300);
		By create=By.xpath("//*[@id=\"submitBtn\"]/span[1]");
		JavascriptExecutor Aj=(JavascriptExecutor) driver;
		Aj.executeScript("arguments[0].scrollIntoView();",driver.findElement(create));
	}
	
	public void logoverification()
	{
		By logo=By.xpath("//*[@id=\"resman\"]/div/div[1]/span");
		WebElement design=driver.findElement(logo);
		boolean display=design.isDisplayed();
		if(display)
		{
			System.out.println("The logo is displayed");
		}
		else
		{
			System.out.println("The logo is not displayed");
		}
	}
	
	
	
	public void windowandtab()
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.naukrigulf.com/register/?expName=expa&source=dtop_login_layer");
	}	

}
