import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PromotionProgram {
    private static int budget=50000;
    private static int rate=10;
    public PromotionProgram(){
        setInterval();
    }
    public static Map<Product,Integer> getAllItemsAfterPromote(Map<Product,Integer> items){
        Random rand = new Random();
        items.forEach((k,v)->{
            if(v/3>0){
                int chance=v/3;
                for (int i = 0; i < chance; i++) {
                    if (budget<k.getValue()){
                        break; //if not enough budget-> end promotion program for this product
                    }
                    if (rand.nextInt(100) < rate){
                        v++;  // add promotion product to items
                        budget-=k.getValue(); // budget-promotionProductValue
                        System.out.println("You are promoted a "+k);
                    }
                }
            }
        });
        return items;
    }

    private void setInterval(){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        Timer timer=new Timer();
        timer.schedule(new MyTask(),today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
    private class MyTask extends TimerTask{

        @Override
        public void run() {
            if(budget>0){
                rate+=rate/2;
            }else {
                rate=10;
            }
            budget+=50000;
        }
    }

    public static void main(String[] args) {
        PromotionProgram promotionProgram=new PromotionProgram();
    }
}
