import java.util.HashMap;

public class expenseBuilder {

    private String name;
    private HashMap expenseBreakDown;

    public expenseBuilder(String name) {
	this.name = name;
	breakDown = new HashMap();
    }

    public void add(String key, Expense value) {
	expenseBreakDown.put(key, value);
    }
    
    public void add(String key, HashMap value) {
	expenseBreakDown.put(key, value);
    }

    public HashMap getHashMap() {
	return expenseBreakDown;
    }

    public String toString() {
	return name;
    }
}
