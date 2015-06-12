public class budgetTree {

    private treeNode expenses;

    private int size;

    public budgetTree() {
	this(false);
    }

    public budgetTree(String config) {
	String[] layers = config.split("\n");
	expenses = new treeNode(layers[0]);
	size = 1;
	queue waitingLine = new queue(expenses);
	for (int i = 1; i < layers.length; i++) {
	    String[] subLayers = layers[i].split("/");
	    for (int j = 0; j < subLayers.length; j++) {
		treeNode parent = waitingLine.remove().getData();
		if (!subLayers[j].equals("")) {
		    String[] children = subLayers[j].split(";");
		    for (int k = 0; k < children.length; k++) {
			treeNode child = new treeNode(children[k]);
			parent.addChild(child);
			waitingLine.add(child);
		    }
		}
	    }
	}
    }
    
    public budgetTree(boolean custom) {
	expenses = new treeNode("All Expenses");
	size = 1;
	if (custom == true) {
	    initiate();
	} else {
	    advancedInitiate();
	}
    }

    public void initiate() {
	treeNode fixed = new treeNode("Fixed Expenses");
	treeNode variable = new treeNode("Variable Expenses");
	treeNode periodic = new treeNode("Periodic Expenses");
	expenses.addChild(fixed);
	expenses.addChild(variable);
	expenses.addChild(periodic);
	size += 3;
    }

    public void advancedInitiate() {
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
	size += 13;
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

    public void addCategory(treeNode parent, treeNode newChild) {
	parent.addChild(newChild);
    }

    public void removeCategory(treeNode parent, String child) {
	parent.removeChild(child);
    }

    public String traverse() {
	String s = traverse(expenses);
	return s;
    }

    public String traverse(treeNode node) {
	if (node.isLeaf()) {
	    //Location String
	    String location = "";
	    treeNode tmp = node;
	    while (tmp.getParent() != null) {
		if (tmp == node) {
		    location = tmp.getName() + location;
		} else {
		    location = tmp.getName() + ";" + location;
		}
		tmp = tmp.getParent();
	    }
	    //Data String
	    String data = location;
	    Expense nodeExpenses = node.getData();
	    while (nodeExpenses != null) {
		data += "|" + nodeExpenses;
		nodeExpenses = nodeExpenses.getNext();
	    }
	    data += "\n";
	    return data;
	}
	String output = "";
	for (int i = 0; i < node.getNumChildren(); i++) {
	    output += traverse(node.getChild(i));
	}
	return output;
    }

    public static void main(String[] args) {
	budgetTree test = new budgetTree("All Expenses\nVariable;Fixed;Periodic\nFood;Utilities/Rent;Interest/Insurances;Taxes\nGroceries;Dining Out//Blab;baal");
	treeNode n = test.findCategory("Food");
	System.out.println(test.traverse());
    }
}
