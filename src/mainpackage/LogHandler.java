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

	private static String generateMessage(Class<?> context, String msg, LogType type) {
		String returnMessage = "";
		String date = DateTime.generateDate();
		String time = DateTime.generateTime();
		String classInfo = context.toString();

		switch (type) {
		case INFO: {
			returnMessage = YELLOW + "[" + classInfo + "]" + " [" + date + "]" + " [" + time + "]" + " [INFO]: " + msg
					+ RESET;
			break;
		}
		case WARNING: {
			returnMessage = YELLOW + "[" + classInfo + "]" + " [" + date + "]" + " [" + time + "]" + " [WARNING]: "
					+ msg + RESET;
			break;
		}
		case ERROR: {
			returnMessage = RED + "[" + classInfo + "]" + " [" + date + "]" + " [" + time + "]" + " [ERROR]: " + msg
					+ RESET;
			break;
		}
		case FATAL: {
			returnMessage = RED + "[" + classInfo + "]" + " [" + date + "]" + " [" + time + "]" + " [FATAL]: " + msg
					+ RESET;
			break;
		}
		}
		return returnMessage;
	}

	private static String generateLogFileMessage(Class<?> context, String msg, LogType type) {
		String returnMessage = "";
		String time = DateTime.generateTime();
		String classInfo = context.toString();

		switch (type) {
		case INFO: {
			returnMessage = " [" + time + "]" + " [" + classInfo + "]" + " [INFO]: " + msg;
			break;
		}
		case WARNING: {
			returnMessage = " [" + time + "]" + " [" + classInfo + "]" + " [WARNING]: " + msg;
			break;
		}
		case ERROR: {
			returnMessage = " [" + time + "]" + " [" + classInfo + "]" + " [ERROR]: " + msg;
			break;
		}
		case FATAL: {
			returnMessage = " [" + time + "]" + " [" + classInfo + "]" + " [FATAL]: " + msg;
			break;
		}
		}
		return returnMessage;
	}

	public void log(Class<?> context, LogType type, String msg){
		
		if (ConfigReader.getLogMode() == 0) {
			System.out.println(generateMessage(context, msg, type));
		}else if (ConfigReader.getLogMode() == 1){
			FileHandler.generateLogFile(generateLogFileMessage(context, msg, type));
		}else {
			// TODO: Custom error message.
		}
	}

}
