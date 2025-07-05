import java.util.List;

public class Shipping {

    public static void shipItems(List<Shippable> items) {
        System.out.println("Shipping the following items:");
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
        }
    }
}

