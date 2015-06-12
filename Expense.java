public class Expense {

    private String source;
    private String item;
    private double unitPrice;
    private int quantity;

    private Expense next;
    
    public Expense(String source, String item, double unitPrice, int quantity) {
	this.source = source;
	this.item = item;
	this.unitPrice = unitPrice;
	this.quantity = quantity;
	next = null;
    }

    public boolean hasNext() {
	return next != null;
    }
    public void setNext(Expense e) {
	next = e;
    }
    public Expense getNext() {
	return next;
    }

    public String getSource() {
	return source;
    }
    public String getItem() {
	return item;
    }
    public double getUnitPrice() {
	return unitPrice;
    }
    public int getQuantity() {
	return quantity;
    }
    public double getSum() {
	return unitPrice * quantity;
    }
    public String toString() {
	return source + "," + item + "," + unitPrice + "," + quantity;
    }

}
