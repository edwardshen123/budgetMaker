public class queue {

    private node front;
    private node back;
    private int size;
    
    public queue() {
	front = null;
	back = front;
	size = 0;
    }

    public queue(treeNode tN) {
	node n = new node(tN);
	front = n;
	back = n;
	size = 1;
    }

    public void add(treeNode tN) {
	node n = new node(tN);
	if (size == 0) {
	    front = n;
	    back = n;
	} else {
	    back.setNext(n);
	    back = n;
	}
	size++;
    }

    public node remove() {
	node tmp = front;
	front = front.getNext();
	size--;
	return tmp;
    }

    public int size() {
	return size;
    }
}
