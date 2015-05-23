import java.util.HashMap;

public class expenseBuilder {

    private String name;
    private HashMap breakDown;

    public expenseBuilder(String name) {
	this.name = name;
	breakDown = new HashMap();
    }

    public String toString() {
	return name;
    }
}
