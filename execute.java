//Control load or new
//New: Check if expense have been added; give option to overwrite
//Expenses to file - budgetGrabber
//Loading existing: ls function - cd into folder, etc
//Ask user for date of expense
//Limit # of scanners
//work on montly budgetbuilder

import java.io.*;
import java.util.*;

public class execute {

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

    public static void main(String[] args) {
	Scanner ans = new Scanner(System.in);
	String whatdo;
	while (whatdo.equals('load') == false || whatdo.equals('create') == false) {
	    System.out.println("Would you like to load or create a new expense? (Type 'load' or 'create')");
	    whatdo = ans.nextLine();
	    if (whatdo.equals('load')) {
		displayIt(new File("C:\\Downloads"));
		System.out.println("Please choose a txt file.");
		String filename = ans.nextLine();
		String[] file = filename.split(".");
		boolean loaded = false;
		while (loaded == false) {
		    if (file[file.length - 1].equals("txt")) {
			budgetGrabber b = new budgetGrabber();
			monthlyBudgetBuilder m = b.read(filename);
		    }
		    else {
			System.out.println("Invalid file. Please choose another.");
		    }
		}
	    }
	    else if (whatdo.equals('create')) {

	    }	
	}
    }
}
