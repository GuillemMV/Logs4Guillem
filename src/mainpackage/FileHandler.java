package mainpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;

public class FileHandler {

	
	/**
	 * Method that handles the file creation and the log appending to it.
	 * @param line Formatted string
	 */
	public static void generateLogFile(String line){
		File logFile = new File(ConfigReader.getLogFilePath()+DateTime.generateDate()+".txt");
		
		try {
			if(logFile.createNewFile()) {
				try(FileWriter fw = new FileWriter(logFile, true)){
					fw.write(line);
				}
			}else {
				try(FileWriter fw = new FileWriter(logFile, true);
					BufferedWriter bw = new BufferedWriter(fw)){
					bw.newLine();
					bw.append(line);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
