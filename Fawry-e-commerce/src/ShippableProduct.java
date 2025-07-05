import java.util.Date;

class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight, boolean expirable, Date expiryDate) {
        super(name, price, quantity, expirable, (java.sql.Date) expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
