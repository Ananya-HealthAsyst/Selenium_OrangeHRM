package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoPage {
	private WebDriver driver;
	private WebDriverWait wait;
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public MyInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	
//	@FindBy(css = ".oxd-main-menu-item.active.toggle")
//	private WebElement adminbutton;
//	 
	@FindBy(css="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2)")
	private WebElement adminbutton;
	
	
	public void adminclick() {
//		wait.until(ExpectedConditions.visibilityOf(myInfobutton));
		boolean result = adminbutton.isDisplayed();
		System.out.println(result);
		adminbutton.click();
	}
	
	@FindBy(css="oxd-select-text-input")
	private WebElement role; 
	

	@FindBy(xpath="//button[normalize-space()='Add']")
	public WebElement addbutton;
//	
	public void addButton() {
		addbutton.click();
	}
	@FindBy(xpath = "//label[text()='User Role']/following::div[1]")
    private WebElement userDropdown;
	
	
    @FindBy(xpath = "//div[@role='listbox']//div/span[text()='ESS']")
    private WebElement userRoleESS;
    public void userRole() {
    		userDropdown.click();
		userRoleESS.click();
		
	}
	
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
	  private  WebElement employeeName;
	 
	 @FindBy(xpath = "//label[text()='Status']/following::div[1]")
	 private WebElement statusDropDown;
	 
	 @FindBy(xpath = "//div[@role='listbox']//div/span[text()='Enabled']")
	 private WebElement statusOptionEnabled;

	 @FindBy(xpath = "//input[@autocomplete='off']")
	 private WebElement username;
	 
	 @FindBy(xpath = "(//input[@type='password'])[1]")
	  private WebElement passwordAdminInput;

	 @FindBy(xpath = "(//input[@type='password'])[2]")
	  private WebElement confirmPasswordInput;

	  @FindBy(xpath = "//button[normalize-space()='Save']")
	  private WebElement saveButton;

	  public void Employeename(String empName) {
			 employeeName.sendKeys(empName);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span"))).click();
		    
		 }
		 public void statusBar() {
			statusDropDown.click();
		     statusOptionEnabled.click();
		 }
		 public void userName(String userName, String passWord) {
			 username.sendKeys(userName);
			 passwordAdminInput.sendKeys(passWord);
			 confirmPasswordInput.sendKeys(passWord);
		 }
		 public void submitUserForm() {
		    saveButton.click();
		 }
		 public void UserForm(String empName, String userName, String passWord) {
			 userRole();
			 Employeename(empName);
			 statusBar();
			 userName(userName, passWord);
			 submitUserForm();
			 
		 }
	
	
	
}
