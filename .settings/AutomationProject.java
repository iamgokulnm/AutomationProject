package Test;

import org.testng.annotations.Test;

import Base.Project;
import Pages.AutoProject;
import Utility.Automation_Project;

public class AutomationProject extends Project
{
	@Test
	public void operations() throws Exception
	{
		AutoProject ob=new AutoProject(driver);
		String path="D:\\PICS\\Data.xlsx";
		String sheet="Sheet1";
		int count=Automation_Project.details(path, sheet);
		for(int i=1;i<=count;i++)
		{
			String fname=Automation_Project.values(path, sheet, i, 0);
			System.out.println(fname);
			String lname=Automation_Project.values(path, sheet, i, 1);
			System.out.println(lname);
			String mail=Automation_Project.values(path, sheet, i, 2);
			System.out.println(mail);
			String conmail=Automation_Project.values(path, sheet, i, 3);
			System.out.println(conmail);
			ob.input(fname, lname, mail, conmail);
			ob.titleverification();
			ob.pageverification();
			ob.linkvalidation();	
			
			
			
			
		}
		

		
	}

}


