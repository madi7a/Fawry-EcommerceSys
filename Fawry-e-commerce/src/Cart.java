import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) throws Exception {
        if (quantity > product.getQuantity()) {
            throw new Exception("Not enough quantity for " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getShippingFees() {
        return items.stream()
                .filter(item -> item.getproduct() instanceof Shippable)
                .mapToDouble(item -> ((Shippable) item.getproduct()).getWeight() * 5)
                .sum();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> list = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getproduct() instanceof Shippable) {
                list.add((Shippable) item.getproduct());
            }
        }
        return list;
    }
}
