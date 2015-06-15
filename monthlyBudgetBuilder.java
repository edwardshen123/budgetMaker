import java.util.Iterator;
import java.util.HashMap;

//use tree to store everything

public class monthlyBudgetBuilder {


    //Base Info
    private String month;
    private int year;

    //Sum totals
    private double netIncome;
    private double budgetBalance;

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

    public void setWage(double wage) {
	this.wage = wage;
    }

    public double getWage() {
	return wage;
    }

    public void setGift(double gift) {
	this.gift = gift;
    }

    public double getGift() {
	return gift;
    }

    public void setCapital(double capital) {
	capitalGain = capital;
    }

    public double getCapital() {
	return capitalGain;
    }

    public void setAllowance(double allowance) {
	allowances = allowance;
    }

    public double getAllowance() {
	return allowances;
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
