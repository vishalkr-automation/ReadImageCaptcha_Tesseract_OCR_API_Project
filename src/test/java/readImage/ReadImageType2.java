package readImage;


import java.io.File;
import org.testng.annotations.Test;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;


public class ReadImageType2 {

	@Test
	public void f(){
		
		ITesseract image=new Tesseract();
		try{
			File file=new File(System.getProperty("user.dir")+"\\ImageFolder\\50873_original.png");
			//String str=image.doOCR(new File("C:\\Users\\vishalkumar\\Desktop\\image\\helenkeller1-2x.jpg"));
			String str=image.doOCR(file);
			System.out.println("Data for Image is: "+ str);
			
		}
		catch(Exception e){
			System.out.println("Exception: "+ e.getMessage());
		}		
			
}
}
