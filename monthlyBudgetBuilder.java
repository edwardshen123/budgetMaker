//Use HashMaps
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
    private expenseBuilder fixed;
    private expenseBuilder variable;
    private expenseBuilder periodic;

    //Expense Breakdown
    private double food;
    private double grocery;
    private double diningOut;
    private double utilities;
    private double rent;
    private double investments;
    private double savings;
    private double insurance;
    private double loanInterest;
    private double entertainments;

    public budgetBuilder(int month, int year) {
	this.month = month;
	this.year = year;
	initiate();
	reCalculate();
    }

    private void initiate() {
	fixed = new expenseBuilder("fixedExpenses");
	variable = new expenseBuilder("variableExpenses");
	periodic = new expenseBuilder("periodicExpenses");
	createBasicCategories();
	wage = 0.0;
	gift = 0.0;
	capitalGain = 0.0;
	allowance = 0.0;
	grocery = 0.0;
	diningOut = 0.0;
	utilities = 0.0;
	rent = 0.0;
	investments = 0.0;
	savings = 0.0;
	loanInterest = 0.0;
    }

    public void reCalculate() {
	netIncome = wage + gift + capitalGain + allowance;
	food = grocery + diningOut;
	fixedExpenses = rent + savings + loanInterest;
	variableExpenses = food + investment + utilities;
	periodicExpenses = insurance + entertainments;
	netExpenses = fixedExpenses + variableExpenses;
	budgetBalance = netIncome - netExpenses;
    }

    private void createBasicCategories() {
	addEntry(fixed, "rent", 0.0);
	addEntry(fixed, "savings", 0.0);
	addEntry(fixed, "loanInterest", new expenseBuilder("loanInterest"));
	addEntry(variable, "food", new expenseBuilder("food"));
	addEntry(variable, "investment", new expenseBuilder("investment"));
	addEntry(variable, "utilities", new expenseBuilder("utilities"));
	addEntry(periodic, "insurance", new expenseBuilder("insurance"));
	addEntry(periodic, "entertainments", new expenseBuilder("entertainments"));
	expenseBuilder foodExpenses = expenseBuilder.get("food");
	addEntry(foodExpenses, "groceries", new expenseBuilder("groceries"));
	addEntry(foodExpenses, "diningOut", new expenseBuilder("diningOut"));
    }

    public void addEntry(expenseBuilder encomposing, String category, E value) {
	if (!encomposing.containsKey(category)) {
	    encomposing.put(category, value);
	}
    }

    public String toString() {
	String output = "" + month + "/" + year + " : $" + budgetBalance;
	return output;
    }
}
