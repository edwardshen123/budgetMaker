public class treeNode {

    String name;
    treeNode[] child;
    int numCategory;
    int lastRemoved;

    Expense expenses;

    public treeNode(String name) {
	this(name, 10);
    }

    public treeNode(String name, int numChildren) {
	this.name = name;
	child = treeNode[numChildren];
	numCategory = 0;
	expenses = null;
	lastRemoved = 11;
    }

    public treeNode(String name, Expense expenses) {
	this.name = name;
	child = treeNode[0];
	numCategory = 0;
	lastRemoved = 1;
	this.expenses = expenses;
    }

    public int findCategory(String name) {
	for (int i = 0; i < child.length; i++) {
	    if (child[i].getName().equals(name)) {
		return i;
	    }
	}
	return -1;
    }
    public String getName() {
	return name;
    }
    public Expense getExpenses() {
	return expenses;
    }
    public void addExpenses(Expense e) {
	e.setNext(expenses);
	expenses = e;
    }
    public void addCategory(treeNode t) {
	if (isFull()) {
	    expand();
	}
	child[numCategory] = t;
	numCategory++;
    }
    private void expand() {
	treeNode[] tmp = treeNode[child.length + 10];
	for (int i = 0; i < child.length; i++) {
	    tmp[i] = child[i];
	}
	child = tmp;
    }
    public treeNode removeCategory(String name) {
	numCategory--;
    }
    public boolean isFull() {
	return numCategory >= child.length;
    }
    public int getNumCategory() {
	return numCategory;
    }
}
