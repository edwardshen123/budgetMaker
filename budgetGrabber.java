import java.util.Scanner;

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
	Scanner sc = new Scanner(new File(filename));    
    }

    public static String makeString(monthlyBudgetBuilder budget) {
    }
}
