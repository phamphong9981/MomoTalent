import java.util.HashMap;
import java.util.Map;

public class Machine {
    private int initBalance;
    private int balance;
    private Cart cart;
    private PromotionProgram promotionProgram=null;
    public Machine(){
        this.initBalance=0;
        this.balance=0;
        this.cart=new Cart();
    };
    public Machine(int value, PromotionProgram promotionProgram){
        if(isAcceptNote(value)){
            this.initBalance=value;
            this.balance=value;
            this.cart=new Cart();
            if (promotionProgram!=null){
                this.promotionProgram=promotionProgram;
            }
        }else {
            System.out.println("The value is invalid");
        }
    };



    public void selectProduct(Product product){
        if (product.getValue()>balance){
            System.out.println("Product is more value than your balance. You cannot buy "+product+" more");
        } else{
            this.balance-=product.getValue();
            this.cart.addToCart(product,1);
            System.out.println(product+" is added");
        }
    }
    public void releaseProduct(Product product){
        this.balance+=(int)this.cart.getCart().get(product)*product.getValue();
        this.cart.releaseProduct(product);
        System.out.println(product+" is released");
    }
    public void cancle(){
        cart.releaseAll();
        this.balance=this.initBalance;
        refund();
    }
    public Map<Product,Integer> checkOut(){
        Map<Product,Integer> items=new HashMap<>();
        items.putAll(cart.getCart());
        if(this.promotionProgram!=null){
            items=PromotionProgram.getAllItemsAfterPromote(items);
        }
        refund();
        return items;
    }






    private void refund() {
        // refund balances
        System.out.println("The refund is "+this.balance);
        this.balance=0;
        // release cart
        this.cart.releaseAll();
        System.out.println("You are logged out");
    }
    private boolean isAcceptNote(int value){
        for (AcceptNote x:
                AcceptNote.values()) {
            if(x.getValue()==value){
                return true;
            }
        }
        return false;
    };
}
