import java.util.HashMap;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
	HashMap hm = new HashMap();
	//System.out.println(hm.size());
	hm.put("map", 1);
	//System.out.println(hm.size());
	Iterator i = hm.keySet().iterator();
	while (i.hasNext()) {
	    System.out.println(i.next());
	}
    }
}
