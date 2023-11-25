package mainpackage;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		LogHandler lh = LogHandler.generateHandler();
		lh.log(ConfigReader.class, LogType.INFO, "Mensaje no encontrado, recorriendo siguiente pais...");
		lh.log(ConfigReader.class, LogType.INFO, "Mensaje no encontrado, recorriendo siguiente pais...");
		lh.log(ConfigReader.class, LogType.INFO, "Mensaje no encontrado, recorriendo siguiente pais...");
		lh.log(ConfigReader.class, LogType.INFO, "Mensaje no encontrado, recorriendo siguiente pais...");
		lh.log(ConfigReader.class, LogType.INFO, "Mensaje no encontrado, recorriendo siguiente pais...");
	}
}
