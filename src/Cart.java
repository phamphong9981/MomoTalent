import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> cart;
    public Cart(){
        cart=new HashMap();
        for(Product p:Product.values()){
            cart.put(p,0);
        }
    }
    public Map getCart(){
        return cart;
    }
    public void addToCart(Product p,int amount){
        cart.put(p,cart.get(p)+amount);
    }
    public void releaseProduct(Product p){
        cart.put(p,0);
    }
    public void releaseAll(){
        for(Product p:Product.values()){
            cart.put(p,0);
        }
    }

    public static void main(String[] args) {
        Cart cart=new Cart();
        cart.addToCart(Product.COKE,1);
        cart.addToCart(Product.COKE,1);
        System.out.println(cart.getCart());

    }
}
