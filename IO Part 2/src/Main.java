import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Main {

	public static void main(String[] args) {

File myFile = new File("data" + File.separator + "quotes.txt");
	if(!myFile.exists()) {
		try { 
			myFile.createNewFile();
			System.out.println("File 'quotes.txt' has been created");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	File dataDir = new File("data");
	for (File f : dataDir.listFiles()) {
	System.out.println(f.getAbsolutePath());
		
	}
	
	Path data = FileSystems.getDefault().getPath("data");
	try(DirectoryStream<Path> stream = Files.newDirectoryStream(data)) {
		for(Path entry: stream) {
			System.out.println(entry.getFileName());
			}
	} catch (IOException e) {
		e.printStackTrace();
		
		}
	
	try(FileWriter writer = new FileWriter(new File(dataDir, "myText.txt"))) {
	 writer.write("I wrote this line in a try-with-resources block\n");
	} catch (IOException e) {
		e.printStackTrace();
	}


try (Scanner scan = new Scanner(FileSystems.getDefault().getPath("userEcho.txt"))) {
	while(scan.hasNextLine()) {
		String line = scan.nextLine();
		System.out.println(line.toUpperCase());
	}
		
	} catch (IOException e) {
		e.printStackTrace();
	}

try (FileWriter writer = new FileWriter(new File("data" + File.separator + "userNumbers.txt"));
BufferedWriter bw = new BufferedWriter(writer)) {
bw.write("0 1.4 566 10 \n");
} catch (IOException e) {
	e.printStackTrace();
	
}


try(Scanner numScanner = new Scanner(new File("data" + File.separator + "userNumbers.txt"))) {
while (numScanner.hasNext()) {
if(numScanner.hasNextDouble()) {
	double num = numScanner.nextDouble();
	System.out.println(num / 2); 
} else {
	numScanner.next();
	
}
	
}

} catch (IOException e) {
	e.printStackTrace();
	
	
}

}
}




	