import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 2) {
			System.out.println("Invalid Number of Arguments");
			return;
		}
		
		File csvFile = new File(args[0]);
		File templateFile = new File(args[1]);
		
		Scanner csv = new Scanner(csvFile);
		Scanner templateScanner = new Scanner(templateFile);
		
		StringBuilder stringBuilder = new StringBuilder();
		while (templateScanner.hasNextLine()) {
			stringBuilder.append(templateScanner.nextLine()).append("\n");
		}
		
		String template = stringBuilder.toString();
		String[] header = csv.nextLine().split(",");
		
		while (csv.hasNextLine()) {
			String[] data = csv.nextLine().split(",");
			String line = template;
			
			for (int i = 0; i < header.length; i++) {
				line = line.replace("__" + header[i] + "__", data[i]);
			}
			
			line = line.replace("\\n","\n");
			
			System.out.println(line);
		}
	}
}
