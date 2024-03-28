package Test;

import org.testng.annotations.Test;

import Base.ProjectBase;
import Pages.ProjectPage;
import Utility.ProjectUtility;

public class ProjectTest extends ProjectBase
{
	@Test
	public void operations() throws Exception
	{
		ProjectPage ob=new ProjectPage(driver);
		String path="D:\\Work.xlsx";
		String sheet="Sheet1";
		int count=ProjectUtility.details(path, sheet); 
		for(int i=1;i<=count;i++)
		{
			String username=ProjectUtility.values(path, sheet, i, 0);
			System.out.println(username);
			String pwrd=ProjectUtility.values(path, sheet, i, 1);
			System.out.println(pwrd);
			ob.registration(username, pwrd);
			ob.Titleverification();
			ob.pageverification();
			ob.screenshot();
			ob.singlescreenshot();
			ob.linkvalidation();
			ob.textverification();
			ob.buttonverification();
			ob.mutiplelinkvalidation();
			ob.scrolldown();
			ob.Scrolldown2();		
			ob.logoverification();
			ob.windowandtab();
			
		}
	}

}
