package PracticePackage;

import java.util.Date;

public class DateClass {
	static String tourDate;
	public static void main(String[] args) {
		Date date = new Date();
		String[] d = date.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date1 = d[2];
		String year = d[5];
	 tourDate=day+" "+month+" "+date1+" "+year;
	 System.out.println(tourDate);
		

	}

}
