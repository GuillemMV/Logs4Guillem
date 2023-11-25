package mainpackage;

import java.io.IOException;

public class LogHandler {

	private static LogHandler logHandler;
	public static final String RED = "\u001B[31m";
	public static final String YELLOW = "\u001B[33m";
	public static final String RESET = "\u001B[0m";

	private LogHandler() {
		ConfigReader.readConfig();
	}

	public static LogHandler generateHandler() {
		if (logHandler == null) {
			logHandler = new LogHandler();
		}
		return logHandler;
	}

	private static String generateMessage(Class<?> context, String msg, LogType type, String dateFormat, String timeFormat) {
		String returnMessage = "";
		switch (type) {
		case INFO: {
			returnMessage = YELLOW + "[" + DateTime.generateDate() + "]" 
							+ " [" + context.toString() + "]"
							+ " [" + DateTime.generateTime() + "]" 
							+ " [INFO]: " + msg + RESET;
			break;
		}
		case WARNING: {
			returnMessage = YELLOW + "[" + DateTime.generateDate() + "]"
							+ " [" + context.toString() + "]"
							+ " [" + DateTime.generateTime() + "]"
							+ " [WARNING]: " + msg + RESET;
			break;
		}
		case ERROR: {
			returnMessage = RED + "[" + DateTime.generateDate() + "]"
							+ " [" + context.toString() + "]"
							+ " [" + DateTime.generateTime() + "]"
							+ " [ERROR]: " + msg + RESET;
			break;
		}
		case FATAL: {
			returnMessage = RED + "[" + DateTime.generateDate() + "]"
							+ " [" + context.toString() + "]"
							+ " [" + DateTime.generateTime() + "]"
							+ " [FATAL]: " + msg + RESET;
			break;
		}
		}
		return returnMessage;
	}

	public void log(Class<?> context, LogType type, String msg) throws IOException {
		//System.out.println(generateMessage(context, msg, type, ConfigReader.getDateFormat(), ConfigReader.getTimeFormat()));
		FileHandler.generateLogFile(generateMessage(context, msg, type, ConfigReader.getDateFormat(), ConfigReader.getTimeFormat()));
	}

}
