package mainpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import exceptions.LogModeNotSupportedException;

public class ConfigReader {
	
	private static String dateFormat;
	private static String timeFormat;
	private static int logMode;
	private static String logFilePath;
	
	private static final String DEFAULT_DATE = "dd-MM-yyyy";
	private static final  String DEFAULT_TIME = "HH:mm:mm";
	private static final  String DEFAULT_MODE = "0";
	
	public static void readConfig(){
		Properties props = new Properties();
		try(FileInputStream input = new FileInputStream("config.properties")){
			props.load(input);
			dateFormat = props.getProperty("date.format", DEFAULT_DATE);
			timeFormat = props.getProperty("time.format", DEFAULT_TIME);
			logMode = Integer.parseInt(props.getProperty("log.mode", DEFAULT_MODE));
			logFilePath = props.getProperty("logfile.path");
			
			if (logMode != 0 && logMode != 1) {
				throw new LogModeNotSupportedException();
			}
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LogModeNotSupportedException lmnse) {
			lmnse.printStackTrace();
		}
	}

	public static String getDateFormat() {
		return dateFormat;
	}

	public static String getTimeFormat() {
		return timeFormat;
	}

	public static int getLogMode() {
		return logMode;
	}

	public static String getLogFilePath() {
		return logFilePath;
	}
}
