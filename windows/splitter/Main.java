import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String fileLocation = scanner.next().replace("{", " ");
			if(fileLocation.equals("done"))
				break;
			String inputName = scanner.next().replace("{", " ");
			String outputName = scanner.next().replace("{", " ");
			String timeBase = scanner.next();
			int startTime = Integer.parseInt(timeBase.replace("\"", "").replace("“","").replace("”","").split(":")[0])*3600 + Integer.parseInt(timeBase.replace("\"", "").replace("“","").replace("”","").split(":")[1])*60 + Integer.parseInt(timeBase.replace("\"", "").replace("“","").replace("”","").split(":")[2]);
			timeBase = scanner.next();
			int stopTime = Integer.parseInt(timeBase.replace("\"", "").replace("“","").replace("”","").split(":")[0])*3600 + Integer.parseInt(timeBase.replace("\"", "").replace("“","").replace("”","").split(":")[1])*60 + Integer.parseInt(timeBase.replace("\"", "").replace("“","").replace("”","").split(":")[2]);
			split(inputName, outputName+".mp4", startTime, stopTime);
		}
		
		scanner.close();
	}
	
	public String getNext(Scanner scanner) {
		String input = scanner.next();
		if(input.matches(".*\\w.*"))
			return input;
		return getNext(scanner);
	}
	
	public static void split(String inputFile, String outputFile, int startTime, int stopTime) {
		String command = "\"HandBrakeCLI\" -i \"" + inputFile + "\" -o \"" + outputFile + "\" --start-at duration:" + startTime + " --stop-at duration:" + (stopTime-startTime);
		System.out.println("Running command: " + command);
		Runtime rt = Runtime.getRuntime();
		try {
			Process pr = rt.exec(command);
		} catch (IOException e) {
			System.out.println("ERROR RUNNING COMMAND: " + command);
			e.printStackTrace();
		}
		System.out.println("Finished sucessfully");
	}
}
