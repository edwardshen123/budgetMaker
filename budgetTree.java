public class budgetTree {

    private treeNode expenses;
    
    public budgetTree() {
	expenses = new treeNode("All Expenses");
	initiate();
    }

    public void initiate() {
	//Expense Initiation
	treeNode fixed = new treeNode("Fixed Expenses");
	treeNode variable = new treeNode("Variable Expenses");
	treeNode periodic = new treeNode("Periodic Expenses");
	treeNode food = new treeNode("Food");
	food.addChild(new treeNode("Groceries"));
	food.addChild(new treeNode("Dining Out"));
	fixed.addChild(new treeNode("Rent"));
	fixed.addChild(new treeNode("Savings"));
	fixed.addChild(new treeNode("Loan Interest Payments"));
	variable.addChild(food);
	variable.addChild(new treeNode("Investments"));
	variable.addChild(new treeNode("Utilities"));
	periodic.addChild(new treeNode("Insurances"));
	periodic.addChild(new treeNode("Entertainments"));
	expenses.addChild(fixed);
	expenses.addChild(variable);
	expenses.addChild(periodic);
    }

    public treeNode findCategory(String name, treeNode node) {
	if (node == null) {
	    return null;
	}
	int index = node.findChild(name);
	if (index != -1) {
	    return node.getChild(index);
	} else {
	    for (int i = 0; i < node.getNumChildren(); i++) {
		if (findCategory(name, node.getChild(i)) != null) {
		    return findCategory(name, node.getChild(i));
		}
	    }
	    return null;
	}
    }

    public treeNode findCategory(String name) {
	return findCategory(name, expenses);
    }

    public static void main(String[] args) {
	budgetTree test = new budgetTree();
	treeNode n = test.findCategory("Food");
	System.out.println(n.getName());
    }
}
