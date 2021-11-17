import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        PromotionProgram promotionProgram=new PromotionProgram();
        Machine machine=new Machine(100000,promotionProgram);
        machine.selectProduct(Product.COKE);
        machine.selectProduct(Product.COKE);
        machine.selectProduct(Product.COKE);
        machine.selectProduct(Product.SODA);
        machine.selectProduct(Product.SODA);
        machine.selectProduct(Product.SODA);
        machine.selectProduct(Product.COKE);
        machine.selectProduct(Product.PEPSI);
        machine.checkOut();
    }
}
