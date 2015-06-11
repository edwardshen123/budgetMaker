public class node {

    private treeNode data;
    private node next;

    public node(treeNode data) {
	this.data = data;
	next = null;
    }

    public void setNext(node n) {
	next = n;
    }

    public node getNext() {
	return next;
    }

    public treeNode getData() {
	return data;
    }
}
