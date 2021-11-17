package reusableFunctions;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Resuse {
	
	
	static String fileName = "Output-"+(new SimpleDateFormat("MMddyyyyHHmmss")).format(new Date())+".log";
	
	

	public static void selectDropdownValue(WebElement ele,String value) {
		
		Select drpCountry = new Select(ele);
		drpCountry.selectByVisibleText(value);
		
	}
	
	
	
	public static void simpleLog(String logentry)
	{
		try {
			String FinalEntry =Timestamp.from(Instant.now()) + " :: "+ logentry;
			FileWriter fw = new FileWriter(fileName,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(FinalEntry+"\n");
			System.out.println(FinalEntry);
			bw.close();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
