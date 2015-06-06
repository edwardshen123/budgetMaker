import java.util.Iterator;
import java.util.HashMap;

//use tree to store everything

public class monthlyBudgetBuilder {

    //Base Info
    private int month;
    private int year;

    private int budgetBalance;

    //Sum totals
    private double netIncome;
    private double netExpenses;

    //Income
    private double wage;
    private double gift;
    private double capitalGain;
    private double allowances;

    //Expense
    private treeNode expenses;

    public monthlyBudgetBuilder(int month, int year) {
	this.month = month;
	this.year = year;
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

    public String toString() {
	String output = "" + month + "/" + year + " : $" + budgetBalance;
	return output;
    }
}
