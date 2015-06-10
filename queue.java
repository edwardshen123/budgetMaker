public class queue {

    private node front;
    private node back;
    private int size;
    
    public queue() {
	front = null;
	back = front;
	size = 0;
    }

    public void add(node n) {
	if (size == 0) {
	    front = n;
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
