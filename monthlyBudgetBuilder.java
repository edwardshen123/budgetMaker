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
    private double allowance;

    //Expense
    private expenseBuilder fixedBuilder;
    private expenseBuilder variableBuilder;
    private expenseBuilder periodicBuilder;
    private HashMap fixed;
    private HashMap variable;
    private HashMap periodic;

    public monthlyBudgetBuilder(int month, int year) {
	this.month = month;
	this.year = year;
	initiate();
	reCalculate();
    }

    private void initiate() {
	fixedBuilder = new expenseBuilder("fixedExpenses");
	variableBuilder = new expenseBuilder("variableExpenses");
	periodicBuilder = new expenseBuilder("periodicExpenses");
	createBasicCategories();
	fixed = new HashMap();
	variable = new HashMap();
	periodic = new HashMap();
	initiateExpense();
	wage = 0.0;
	gift = 0.0;  
	capitalGain = 0.0;
	allowance = 0.0;
    }

    public void reCalculate() {
	netIncome = wage + gift + capitalGain + allowance;
	double diningOut = variable.get("diningOut");
	double groceries = variable.get("groceries");
	double rent = fixed.get("rent");
	double savings = fixed.get("savings");
	double loanInterests = fixed.get("loanInterests");
	double food = diningOut + groceries;
	double investments = variable.get("investments");
	double utilities = variable.get("utilities");
	double insurances = periodic.get("insurance");
	double entertainments = periodic.get("entertainments");
	fixed = rent + savings + loanInterest;
	variable = food + investment + utilities;
	periodic = insurance + entertainments;
	netExpenses = fixedExpenses + variableExpenses;
	budgetBalance = netIncome - netExpenses;
    }

    private void initiateExpense() {
	fixed.put("rent", 0.0);
	fixed.put("savings", 0.0);
	fixed.put("loanInterests", 0.0);
	variable.put("groceries", 0.0);
	variable.put("diningOut", 0.0);
	variable.put("investments", 0.0);
	variable.put("utilities", 0.0);
	periodic.put("insurances", 0.0);
	periodic.put("entertainments", 0.0);
    }

    private void createBasicCategories() {
	addCategory(fixedBuilder, "rent", new expenseBuilder("rent"));
	addCategory(fixedBuilder, "savings", new expenseBuilder("savings"));
	addCategory(fixedBuilder, "loanInterests", new expenseBuilder("loanInterest"));
	addCategory(variableBuilder, "food", new expenseBuilder("food"));
	addCategory(variableBuilder, "investments", new expenseBuilder("investment"));
	addCategory(variableBuilder, "utilities", new expenseBuilder("utilities"));
	addCategory(periodicBuilder, "insurances", new expenseBuilder("insurance"));
	addCategory(periodicBuilder, "entertainments", new expenseBuilder("entertainments"));
	expenseBuilder foodExpenses = variableBuilder.get("food");
	addCategory(foodExpenses, "groceries", new expenseBuilder("groceries"));
	addCategory(foodExpenses, "diningOut", new expenseBuilder("diningOut"));
    }

    public void addCategory(expenseBuilder encomposing, HashMap general, String category, HashMap value) {
	if (!encomposing.containsKey(category)) {
	    encomposing.add(category, value);
	    if (!general.containsKey(category)) {
		general.add(category, 0.0);
	    }
	}
    }

    public void addEntry(String category, String location, String item, double unitPrice, int quantity) {
	double price = unitPrice * quantity;
	Expense e = new Expense(item, unitPrice, quantity);

	//Add to ExpenseBuilder
	expenseBuilder eB = getBuilder(category);
	if (eB.containsValue(location)) {
	    e.setNext(eB.get(location));
	    eB.put(location, e);
	} else {
	    eB.put(location, e);
	}

	//Add to total expenses
	HashMap map;
	int cateValue = getCategory(category);
	if (cateValue == 1) map = fixed;
	if (cateValue == 2) map = variable;
	if (cateValue == 3) map = periodic;
	map.put(category, map.get(category) + price);
	reCalculate();
    }

    public expenseBuilder getBuilder(String category) {
	expenseBuilder eB;
	int cateValue = getCategory(category);
	if (cateValue == 1) eB = fixedBuilder;
	if (cateValue == 2) eB = variableBuilder;
	if (cateValue == 3) eB = periodicBuilder;
	key = category;
	if (category.equals("diningOut") || category.equals("groceries")) key = "food";
	eB = eB.get(key);
	if (key.equals("food")) eB = eB.get(category);
	return eB;
    }
    
    public int getCategory(String category) {
	if (fixed.containsKey(category)) {
	    return 1;
	} else if (variable.containsKey(category)) {
	    return 2;
	} else if (periodic.containsKey(category)) {
	    return 3;
	} else {
	    return 0;
	}
    }

    public String toString() {
	String output = "" + month + "/" + year + " : $" + budgetBalance;
	return output;
    }
}
