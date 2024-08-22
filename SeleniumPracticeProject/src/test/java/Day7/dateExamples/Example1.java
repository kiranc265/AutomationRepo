package Day7.dateExamples;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example1 {

	public static void main(String[] args) {
		Date d1=new Date();
		System.out.println("System default date and time: "+d1);
		
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
		
		String currentDate=sf.format(d1);
		System.out.println("Current date: "+currentDate);

	}

}
