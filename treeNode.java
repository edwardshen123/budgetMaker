public class treeNode {

    String name;
    treeNode[] child;
    int numCategory;

    Expense expenses;

    public treeNode(String name) {
	this(name, 10);
    }

    public treeNode(String name, int numChildren) {
	this.name = name;
	child = treeNode[numChildren];
	numCategory = 0;
	expenses = null;
    }

    public treeNode(String name, Expense expenses) {
	this.name = name;
	child = treeNode[10];
	numCategory = 0;
	this.expenses = expenses;
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
