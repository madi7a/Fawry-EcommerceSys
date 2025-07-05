import java.sql.Date;
public class Main {

    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Madiha", 1000);

            Product cheese = new ShippableProduct("Cheese", 50, 5, 2.0, true, new Date(System.currentTimeMillis() + 86400000)); // expires tomorrow
            Product tv = new ShippableProduct("TV", 5000, 2, 10.0, false, null);
            Product scratchCard = new Product("Scratch Card", 30, 10, false, null) {};


            Cart cart = new Cart();
            cart.addItem(cheese, 2);
            cart.addItem(scratchCard, 1);

            EcommerceSys.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


