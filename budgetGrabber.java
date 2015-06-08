import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class budgetGrabber {

    public static monthlyBudgetBuilder read(String filename, monthlyBudgetBuilder builder) {
	Scanner sc = new Scanner(filename);
	while (sc.hasNextLine()) {
	    String s = sc.nextLine();
	    String[] data = s.split("|");
	    String location = data[0];
	    String[] category = location.split(";");
	}
    }

    public static void write(String filename, monthlyBudgetBuilder builder) {
	PrintWriter printer = new PrintWriter(new File(filename));
	
    }
}
