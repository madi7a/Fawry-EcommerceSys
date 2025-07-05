import java.sql.Date;

class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected boolean expirable;
    protected Date expiryDate;
    int date;

    public Product(String name, double price, int quantity, boolean expirable, java.sql.Date expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expirable && expiryDate != null && new Date(date).after(expiryDate);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
