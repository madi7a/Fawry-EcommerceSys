import java.util.List;

public class EcommerceSys {

    public static void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty.");
        }

        for (CartItem item : cart.getItems()) {
            Product p = item.getproduct();
            if (p.isExpired()) throw new Exception("Product " + p.getName() + " is expired.");
            if (item.getquantity() > p.getQuantity()) throw new Exception("Not enough stock for " + p.getName());
        }

        double subtotal = cart.getSubtotal();
        double shipping = cart.getShippingFees();
        double total = subtotal + shipping;

        if (!customer.balanceiswithin(total)){
            throw new Exception("Insufficient balance.");
        }

        // Deduct stock and balance
        for (CartItem item : cart.getItems()) {
            item.getproduct().reduceQuantity(item.getquantity());
        }

        customer.reduceBalance(total);

        System.out.println("---- Checkout Summary ----");
        System.out.println("Subtotal: " + subtotal + " USD");
        System.out.println("Shipping: " + shipping + " USD");
        System.out.println("Total Paid: " + total + " USD");
        System.out.println("Remaining Balance: " + customer.getBalance() + " USD");

        List<Shippable> toShip = cart.getShippableItems();
        if (!toShip.isEmpty()) {
            Shipping.shipItems(toShip);
        }
    }
}
    

