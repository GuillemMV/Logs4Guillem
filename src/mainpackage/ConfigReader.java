package mainpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * - Date format options (DD-MM-YYYY / MM-DD-YYYY / YYYY-MM-DD)
 * - Time format options (H:M:S / H:M / H)
 * - Log mode (0: Console / 1: LogFile)
 * - LogFile path
 */

public class ConfigReader {
	
	private static String dateFormat;
	private static String timeFormat;
	private static int logMode;
	private static String logFilePath;
	
	public static void readConfig() {
		Properties props = new Properties();
		try(FileInputStream input = new FileInputStream("config.properties")){
			props.load(input);
			dateFormat = props.getProperty("date.format", "DD-MM-YYYY");
			timeFormat = props.getProperty("time.format", "HH:MM:SS");
			logMode = Integer.parseInt(props.getProperty("log.mode", "0"));
			logFilePath = props.getProperty("logfile.path");
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static String getDateFormat() {
		return dateFormat;
	}

	public static String getTimeFormat() {
		return timeFormat;
	}

	public static int isLogMode() {
		return logMode;
	}

	public static String getLogFilePath() {
		return logFilePath;
	}
}
