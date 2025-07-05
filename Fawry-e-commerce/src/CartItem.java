public class CartItem {

    Product product;
    int quantity;

    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return product.getPrice()*this.quantity;
    }

    public Product getproduct(){
        return this.product;
    }
    public int getquantity(){
        return this.quantity;
    }
}
