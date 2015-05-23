public class Expense {

    private String item;
    private double unitPrice;
    private int quantity;

    private Expense next;
    
    public Expense(String item, double unitPrice, int quantity) {
	this.item = item;
	this.price = price;
	this.quantity = quantity;
	next = null;
    }

    public void setNext(Expense e) {
	next = e;
    }
    public Expense getNext() {
	return next;
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
	return item + ": " + getSum();
    }

}
