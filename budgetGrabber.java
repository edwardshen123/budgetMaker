//Reads a txt file to build a budget

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class budgetGrabber {

    public static monthlyBudgetBuilder read(String filename) {
	try {
	    Scanner sc = new Scanner(filename);
	    //File Name Parser
	    String[] info = filename.split(" ");
	    String month = info[0];
	    int year = Integer.parseInt(info[1]);
	    budgetTree bTree = new budgetTree(false);
	    //Data Parser
	    while (sc.hasNextLine()) {
		String s = sc.nextLine();
		String[] data = s.split("/");
		String location = data[0];
		String[] category = location.split(";");
	    }
	} catch (FileNotFoundException e) {
	    return null;
	}
    }

    public static void write(monthlyBudgetBuilder builder) {
	String filename = builder.getMonth() + " " + builder.getYear() + " budget";
	try {
	    PrintWriter printer = new PrintWriter(new File(filename));
	    String output = builder.getExpenses().traverse();
	    printer.write(output);
	    printer.close();
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	}
    }
}
