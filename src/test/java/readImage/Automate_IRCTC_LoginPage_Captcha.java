package readImage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Automate_IRCTC_LoginPage_Captcha {
	
	@Test
	public void f() throws IOException, TesseractException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("loginText")).click();
		
		Thread.sleep(5000);
		
		File src=driver.findElement(By.id("nlpCaptchaImg")).getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/screenshot/captcha.png";
		FileHandler.copy(src, new File(path));
		
		Thread.sleep(2000);
		ITesseract image=new Tesseract();
		File file=new File(path);
		String str=image.doOCR(file);
		System.out.println("Data for Image is: "+ str);
		
		
	}

}
