import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args){
        CafeUtil coffeeApp = new CafeUtil();
        int reward = coffeeApp.getStreakGoal();
        System.out.println(reward);
        double[] prices = {13.5, 9.8, 20.5, 8.1, 9.0};
        double total = coffeeApp.getOrderTotal(prices);
        System.out.println(total);
        ArrayList<String> items = new ArrayList<String>();
        items.add("Latte");
        items.add("Cap");
        items.add("Drip");
        coffeeApp.displayMenu(items);
        ArrayList<String> customers = new ArrayList<String>();
        customers.add("Nathan");
        customers.add("Roaa");
        coffeeApp.addCustomer(customers);
    }
}