import java.io.*;
import java.util.*;

public class control {

    //Taken from http://www.mkyong.com/java/how-to-traverse-a-directory-structure-in-java/
    public static void displayIt(File node){
	System.out.println(node.getAbsoluteFile());
	if(node.isDirectory()){
	    String[] subNote = node.list();
	    for(String filename : subNote){
		displayIt(new File(node, filename));
	    }
	}
    }

    public void run() {
	Scanner ans = new Scanner(System.in);
	String whatdo;
	while (whatdo.equals('load') == false || whatdo.equals('create') == false) {
	    System.out.println("Would you like to load or create a new expense? (Type 'load' or 'create') ");
	    whatdo = ans.nextLine();
	    if (whatdo.equals('load')) {
		displayIt(new File("C:\\Downloads"));
		System.out.println("Please choose a txt file. ");
		String filename = ans.nextLine();
		String[] file = filename.split(".");
		boolean loaded = false;
		while (loaded == false) {
		    if (file[file.length - 1].equals("txt")) {
			loaded = true;
			budgetGrabber b = new budgetGrabber();
			monthlyBudgetBuilder m = b.read(filename);
			System.out.println(m.toString());
			System.out.println("Would you like to edit the budget? ");
			//Put in editing budget stuff here
		    }
		    else {
			System.out.println("Invalid file. Please choose another. ");
		    }
		}
	    }
	    else if (whatdo.equals('create')) {
		System.out.println("What month is this budget for? ");
		String month = ans.nextLine();
		System.out.println("What year is this budget for? ");
		String year = ans.nextLine();
		montlyBudgetBuilder create = new monthlyBudgetBuilder(month, year);
		//Add set methods to budgetbuilder
		System.out.println("What is the source of your expense? ");
		String source = ans.nextLine();
		System.out.println("What is the name of the item? ");
		String item = ans.nextLine();
		System.out.println("What is the price of the item? ");
		double price = Double.parseDouble(ans.nextLine());
		System.out.println("How many of the item did you purchase? ");
		int quantity = Integer.parseInt(ans.nextLine());
		Expense e = new Expense(source, item, price, quantity);
		System.out.println("Your expense is: " + e.toString());
		
		
	    }	
	}
    }
}
