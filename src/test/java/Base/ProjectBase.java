package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ProjectBase 
{
	public WebDriver driver;
	@BeforeTest
	public void Url()
	{
		driver=new ChromeDriver();
		String link="https://www.naukrigulf.com/register/?expName=expa&source=dtop_login_layer";
		driver.get(link);
		driver.manage().window().maximize();
		
	}

}
