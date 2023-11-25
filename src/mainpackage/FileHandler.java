package mainpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

	public static void generateLogFile(String line) throws IOException {
		
		File logFile = new File(DateTime.generateDate()+".txt");
		
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
	}
	
}
