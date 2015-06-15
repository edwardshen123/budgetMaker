public class budgetTree {

    //Instance Variables
    private treeNode expenses;

    private boolean isNew;
    private int size;

    //Constructors
    public budgetTree() {
	this(new config().read());
    }

    public budgetTree(boolean isNew) {
	if (!isNew) {
	    expenses = new treeNode("All Expenses");
	    size = 1;
	    this.isNew = isNew;
	}
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
			size++;
			waitingLine.add(child);
		    }
		}
	    }
	}
	isNew = true;
    }

    //Methods
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
    
    public treeNode getRoot() {
	return expenses;
    }

    public boolean addCategory(treeNode parent, treeNode newChild) {
	boolean retVal = parent.addChild(newChild);
	updateConfig();
	return retVal;
    }

    public void removeCategory(treeNode parent, String child) {
	parent.removeChild(child);
	updateConfig();
    }

    public void updateConfig() {
	if (isNew) {
	    config Config = new config();
	    Config.write(traverse());
	}
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
		data += "/" + nodeExpenses;
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
	//budgetTree test = new budgetTree("All Expenses\nVariable;Fixed;Periodic\nFood;Utilities/Rent;Interest/Insurances;Taxes\nGroceries;Dining Out//Blab;baal");
	budgetTree test = new budgetTree();
	treeNode n = test.findCategory("Food");
	System.out.println(test.traverse());
    }
}
