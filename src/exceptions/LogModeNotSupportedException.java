package exceptions;

public class LogModeNotSupportedException extends Exception{
	
	public LogModeNotSupportedException() {
		super("Log Mode can only be 0(Console) or 1(LogFiles)");
	}
}
