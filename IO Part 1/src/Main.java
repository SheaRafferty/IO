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
		
		// See if data directory exists, if not, create the directory
		
		File dataDir = new File("data");
		if(!dataDir.exists()) {
		dataDir.mkdir(); // Create the directory
		System.out.println("Directory 'data' created");	
	}
	
	File myFile = new File(dataDir, "quotes.txt");
	if(!myFile.exists()) {
		try { 
			myFile.createNewFile();
			System.out.println("File 'quotes.txt' has been created");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} else {
		System.out.println("File 'quotes.txt' already exists! ");
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
	
	
	try(FileWriter fw = new FileWriter(new File("userEcho.txt"));
	 Scanner scan = new Scanner(System.in)) {
	 for (int i = 0; i < 10; i++) {
		 fw.write(scan.nextLine() + "\n" );
	 }
	} catch (IOException e) {
		e.printStackTrace();
		
	}
	
	
	}

	}

