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
	back = front;
	size = 1;
    }

    public void add(treeNode tN) {
	node n = new node(tN);
	if (size == 0) {
	    front = n;
	    back = front;
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

    public String toString() {
	String s = "";
	node tmp = front;
	while (tmp.getNext() != null) {
	    s += tmp.getData().getName() + ",";
	    tmp = tmp.getNext();
	}
	s += tmp.getData().getName();
	return s;
    }
}
