import java.util.Iterator;
import java.util.HashMap;

//use tree to store everything

public class monthlyBudgetBuilder {

    //Base Info
    private String month;
    private int year;

    //Sum totals
    private double netIncome;

    //Income
    private double wage;
    private double gift;
    private double capitalGain;
    private double allowances;

    //Expense
    private budgetTree expenseTree;

    public monthlyBudgetBuilder(String month, int year) {
	this(month, year, new budgetTree());
    }

    public monthlyBudgetBuilder(String month, int year, budgetTree tree) {
	this.month = month;
	this.year = year;
	expenseTree = tree;
	initiate();
    }

    //Initiates instance variables
    private void initiate() {
	//Income Initiation
	wage = 0.0;
	gift = 0.0;
	capitalGain = 0.0;
	allowances = 0.0;
    }

    public budgetTree getExpenses() {
	return expenseTree;
    }

    public String getMonth() {
	return month;
    }

    public int getYear() {
	return year;
    }

    public String toString() {
	String output = "" + month + "/" + year + " : $" + budgetBalance;
	return output;
    }
}
