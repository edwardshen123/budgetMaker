public class node {

    private String data;
    private node next;

    public node(String data) {
	this.data = data;
	next = null;
    }

    public void setNext(node n) {
	next = n;
    }

    public node getNext() {
	return next;
    }

    public String getData() {
	return data;
    }
}
