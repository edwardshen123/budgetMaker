public class treeNode {

    private treeNode parent;
    private String name;
    private treeNode[] children;
    private int numChildren;
    private int lastRemoved;
    private double sum;

    private Expense data;

    public treeNode(String name) {
	this(name, 10);
    }

    public treeNode(String name, int numChildren) {
	this.name = name;
	parent = null;
	children = new treeNode[numChildren];
	numChildren = 0;
	data = null;
	lastRemoved = 11;
	sum = 0.0;
    }

    public treeNode(String name, Expense data) {
	this.name = name;
	parent = null;
	children = new treeNode[0];
	numChildren = 0;
	lastRemoved = 1;
	this.data = data;
	sum = 0.0;
    }

    //Functions for This
    public String getName() {
	return name;
    }
    public Expense getData() {
	return data;
    }
    public void addData(Expense e) {
	e.setNext(data);
	data = e;
	sum += e.getSum();
	additionUpdate(e.getSum());
    }
    public double getSum() {
	return sum;
    }
    public void setSum(double num) {
	sum = num;
    }
    public boolean isLeaf() {
	return numChildren == 0;
    }

    //Functions for Parents
    public void setParent(treeNode t) {
	parent = t;
    }
    public treeNode getParent() {
	return parent;
    }

    //Functions for Children
    public int findChild(String name) {
	for (int i = 0; i < children.length; i++) {
	    if (children[i] != null) {
		if (children[i].getName().equals(name)) {
		    return i;
		}
	    }
	}
	return -1;
    }
    public treeNode getChild(int index) {
	return children[index];
    }
    public void addChild(treeNode t) {
	if (isFull()) {
	    expand();
	}
	int i = 0;
	while (children[i] != null) {
	    i++;
	}
	children[i] = t;
	t.setParent(this);
	sum += t.getSum();
	additionUpdate(t.getSum());
	numChildren++;
    }
    public treeNode removeChild(String name) {
	lastRemoved = findChild(name);
	treeNode removed = children[lastRemoved];
	sum -= removed.getSum();
	subtractionUpdate(removed.getSum());
	children[lastRemoved] = null;
	numChildren--;
	return removed;
    }
    public int getNumChildren() {
	return numChildren;
    }

    //Helper Functions
    //Expands Children array
    private void expand() {
	treeNode[] tmp = new treeNode[children.length + 10];
	for (int i = 0; i < children.length; i++) {
	    tmp[i] = children[i];
	}
	children = tmp;
    }
    //Checks if Children array is full
    public boolean isFull() {
	return numChildren >= children.length;
    }
    //Update Every Parent's Sum Value
    private void additionUpdate(double num) {
	if (parent != null) {
	    parent.setSum(parent.getSum() + num);
	    parent.additionUpdate(num);
	}
    }
    private void subtractionUpdate(double num) {
	if (parent != null) {
	    parent.setSum(parent.getSum() - num);
	    parent.subtractionUpdate(num);
	}
    }
}
