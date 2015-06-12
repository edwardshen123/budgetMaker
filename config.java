import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class config {

    private static final String configFileName = "config.txt";

    public String read() {
	String s = "";
	try {
	    Scanner sc = new Scanner(new File(configFileName));
	    while (sc.hasNextLine()) {
		s += sc.nextLine() + "\n";
	    }
	    sc.close();
	} catch (FileNotFoundException e) {
	}
	return s;
    }

    public void write(String output) {
	try {
	    PrintWriter printer = new PrintWriter(new File(configFileName));
	    printer.write(output);
	    printer.close();
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	}
    }
}
