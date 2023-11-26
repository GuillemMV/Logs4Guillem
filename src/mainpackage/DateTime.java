package mainpackage;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {
	
	public static String generateDate() {
		String dateFormat = ConfigReader.getDateFormat();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date actualDate = new Date();
		return sdf.format(actualDate);
	}
	
	public static String generateTime() {
		String timeFormat = ConfigReader.getTimeFormat();
		LocalTime actualTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		return actualTime.format(formatter);
	}

}
