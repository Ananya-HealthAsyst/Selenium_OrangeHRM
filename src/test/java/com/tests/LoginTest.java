package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.MyInfoPage;
import com.pages.SearchPage;
import com.utilities.BaseTest;
import com.utilities.ReadConfig;

public class LoginTest extends BaseTest{
	
	
  @Test
  public void loginSuccessfull() {
	  String baseURL = ReadConfig.readPropertyFileData("baseURL", "config");
      String userName = ReadConfig.readPropertyFileData("userName", "config");
      String password = ReadConfig.readPropertyFileData("password", "config");
      String empName = ReadConfig.readPropertyFileData("empName", "config");
      String username = ReadConfig.readPropertyFileData("username", "config");
      String passWord = ReadConfig.readPropertyFileData("passWord", "config");
      String empNameSearchPage=ReadConfig.readPropertyFileData("empName", "config");
      String usernameSearchPage = ReadConfig.readPropertyFileData("username", "config");
      String statusSearchPage = ReadConfig.readPropertyFileData("status", "config");
      String userRoleSearchPage = ReadConfig.readPropertyFileData("userrole", "config");
      
	  LoginPage lg=new LoginPage(getDriver());
//	  System.out.println("login successfull");
//	  lg.open();
	  lg.loginComplete(userName, password);
	  System.out.println("login successfull");
	  MyInfoPage mp = new MyInfoPage(getDriver());
	  mp.adminclick();
	  mp.addButton();
	  mp.UserForm(empName,username,passWord);
	  
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  SearchPage sp=new SearchPage(getDriver());
	  sp.waitForSearchPageToLoad();
	  sp.searchEmp(usernameSearchPage, empNameSearchPage,statusSearchPage,userRoleSearchPage);
	  System.out.println("Success");
  }
  
//  @Test
//  public void myInfo() {
//	  System.out.println("user on info page");
//	  MyInfoPage mp = new MyInfoPage(getDriver());
//	  mp.myInfoclick();
//	  System.out.println("user on info page");
//  }
}
