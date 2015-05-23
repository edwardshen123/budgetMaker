public class Expense {

    private String item;
    private double unitPrice;
    private int quantity;
    
    public Expense(String item, double unitPrice, int quantity) {
	this.item = item;
	this.price = price;
	this.quantity = quantity;
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
