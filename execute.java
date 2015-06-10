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

	System.out.println("Create an expense or load an existing expense");

	treeNode expensetotal  = new treeNode("Total Expense");
	Expense sum = new Expense("all", "all", 0.0, 0);
	Expense t = sum;
	boolean done = false;
	while (done == false) {
	    System.out.println("What is the source of this expense?");
	    Scanner s = new Scanner(System.in);
	    String source = s.nextLine();
	    System.out.println("What was purchased?");
	    Scanner i = new Scanner(System.in);
	    String item = i.nextLine();
	    System.out.println("What was the price of 1 of this item?");
	    Scanner p = new Scanner(System.in);
	    String price = p.nextLine();
	    System.out.println("How many items were purchased?");
	    Scanner q = new Scanner(System.in);
	    String quantity = q.nextLine();
	    t.setNext(new Expense(source, item, Double.parseDouble(price), Integer.parseInt(quantity)));
	    sum.setPrice(sum.getUnitPrice() + Integer.parseInt(price));
	    sum.setQuantity(sum.getQuantity() + Double.parseDouble(quantity));
	    boolean confirm = false;
	    while (confirm == false) {
		System.out.println("Do you have any more expenses? Type in 'yes' or 'no'.");
		Scanner finished = new Scanner(System.in);
		String fin = finished.nextLine();
		if (fin.equals("yes")) {
		    t = t.getNext();
		    confirm = true;
		    done = true;
		    break;
		}
		if (fin.equals("no")) {
		    confirm = true;
		    break;
		}
	    }
	}		
    }
}
