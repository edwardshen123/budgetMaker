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
    public static void main(String[] args) {
	Scanner ans = new Scanner(System.in);
	String whatdo;
	while (whatdo.equals('load') == false || whatdo.equals('create') == false) {
	    System.out.println("Would you like to load or create a new expense? (Type 'load' or 'create')");
	    whatdo = ans.nextLine();
	    if (whatdo.equals('load')) {
	        budgetGrabber b = new budgetGrabber();
		monthlyBudgetBuilder m = b.read(filename);
		
	    }
	    else if (whatdo.equals('create')) {

	    }	
	}
    }
}
