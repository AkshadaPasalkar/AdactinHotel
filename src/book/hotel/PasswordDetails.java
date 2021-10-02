package book.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordDetails {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Lenovo\\eclipse-workspace\\AdactinHotel\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/index.php");
		
		WebElement uname=driver.findElement(By.xpath("//input[@type='text']"));
		uname.sendKeys("akshadadeshmukh1");
		
		WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("pppqqq");
		String password=pass.getAttribute("value");
		System.out.print("Your Password in Index Page is :"+password);
		
		WebElement btn=driver.findElement(By.xpath("//input[@name='login']"));
		btn.click();
		
		WebElement change=driver.findElement(By.xpath("//a[@href='ChangePassword.php']"));
		change.click();
		
		WebElement currentPass=driver.findElement(By.xpath("//input[@name='current_pass']"));
		currentPass.sendKeys("pppqqq");
		
		String currentPassword=currentPass.getAttribute("value");
		
		
		String newPassword;
		String confirmPassword;
		
		//To verify user is changing the password using its current password
		if(currentPassword.equals(password))
		{
			System.out.print("\nCurrent Password is: "+ currentPassword);
		WebElement newPass=driver.findElement(By.xpath("//input[@name='new_password']"));
		newPass.sendKeys("pqr1234");
		newPassword=newPass.getAttribute("value");
		
		WebElement confirmPass=driver.findElement(By.xpath("//input[@name='re_password']"));
		confirmPass.sendKeys("pqr1234");
		confirmPassword=confirmPass.getAttribute("value");
	
		boolean a=newPassword.isEmpty();
		boolean b=confirmPassword.isEmpty();
		
		System.out.print("\nPassword in index page is same as current password in Change Password page\n");
		
			if(newPassword.equals(confirmPassword) & a!=true & b!=true)
			{
				WebElement btn1=driver.findElement(By.xpath("//input[@type='submit']"));
				btn1.click();
				System.out.print("Your Password is Successfully updated!!!");
			}
			else if (newPassword.isEmpty() & confirmPassword.isEmpty()) 
			{
				System.out.println("Please Enter New Password and Confirm Password\n");
				WebElement btn1=driver.findElement(By.xpath("//input[@type='submit']"));
				btn1.click();
			}
			else if(newPassword.isEmpty()) 
			{
				System.out.print("Please Enter New Password");
				WebElement btn1=driver.findElement(By.xpath("//input[@type='submit']"));
				btn1.click();
			}
			else if (confirmPassword.isEmpty()) 
			{
				System.out.print("Please Enter Confirm Password");
				WebElement btn1=driver.findElement(By.xpath("//input[@type='submit']"));
				btn1.click();
			}
			
			else 
			{
				System.out.print("\nYour New Password and Confirmation Password do not match");
				WebElement btn1=driver.findElement(By.xpath("//input[@type='submit']"));
				btn1.click();
			}
		}
		else if (currentPassword.isEmpty())
		{
			WebElement newPass=driver.findElement(By.xpath("//input[@name='new_password']"));
			newPass.sendKeys("pqr1234");
			newPassword=newPass.getAttribute("value");
			
			WebElement confirmPass=driver.findElement(By.xpath("//input[@name='re_password']"));
			confirmPass.sendKeys("pqr1234");
			confirmPassword=confirmPass.getAttribute("value");
			
			WebElement btn1=driver.findElement(By.xpath("//input[@type='submit']"));
			btn1.click();
			System.out.println("\nPlease Enter Correct Current Password");
		}
		else
		{
			System.out.print("Current Password is wrong");
		}
		
		
		//driver.close();
		
}
}