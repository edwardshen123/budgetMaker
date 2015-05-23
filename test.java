import java.util.HashMap;
import java.util.Iterator;

public class test {

    private HashMap m = new HashMap();

    public void add(int index, E element) {
	m.put(index, element);
    }

    public static void main(String[] args) {
	/*
	HashMap hm = new HashMap();
	//System.out.println(hm.size());
	hm.put("map", 1);
	//System.out.println(hm.size());
	Iterator i = hm.keySet().iterator();
	while (i.hasNext()) {
	    System.out.println(i.next());
	}
	*/
	test t = new test();
	t.add(1, 10);
	t.add(2, "String");
    }
}
