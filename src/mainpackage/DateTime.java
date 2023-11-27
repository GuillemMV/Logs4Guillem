package mainpackage;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {
	
	/**
	 * Generate a String from the actual time, applying configured pattern.
	 * @return String
	 */
	public static String generateDate() {
		String dateFormat = ConfigReader.getDateFormat();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date actualDate = new Date();
		return sdf.format(actualDate);
	}
	
	/**
	 * Generate a String from the actual time, applying configured pattern.
	 * @return String
	 */
	public static String generateTime() {
		String timeFormat = ConfigReader.getTimeFormat();
		LocalTime actualTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		return actualTime.format(formatter);
	}

}
