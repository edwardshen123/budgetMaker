//Reads a txt file to build a budget and Writes to a file

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class budgetGrabber {

    public static monthlyBudgetBuilder read(String filename) throws FileNotFoundException {
	Scanner sc = new Scanner(new File(filename));
	//File Name Parser
	String[] info = filename.split(" ");
	String month = info[0];
	int year = Integer.parseInt(info[1]);
	budgetTree bTree = new budgetTree(false);
	//Data Parser
	while (sc.hasNextLine()) {
	    String s = sc.nextLine();
	    String[] data = s.split("/");
	    
	    //Category generation
	    String location = data[0];
	    String[] category = location.split(";");
	    treeNode parent = bTree.getRoot();
	    for (int i = 0; i < category.length - 1; i++) {
		treeNode child = new treeNode(category[i]);
		boolean added = bTree.addCategory(parent, child);
		if (added = true) {
		    parent = child;
		} else {
		    parent = bTree.findCategory(category[i]);
		}
	    }
	    
	    //Add expenses
	    for (int i = 1; i < data.length; i++) {
		String[] expenseData = data[i].split(",");
		Expense expense = new Expense(expenseData[0], expenseData[1], Double.parseDouble(expenseData[2]), Integer.parseInt(expenseData[3]));
		parent.addData(expense);
	    }
	}
	return new monthlyBudgetBuilder(month, year, bTree);
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
