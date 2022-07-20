import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        Item item1 = new Item("cappucino", 5.5);
        Item item2 = new Item("Mocha", 6.5);
        Item item3 = new Item("Latte", 4.5);
        Item item4 = new Item("Drip Coffee", 5.0);
    
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Anna");
        Order order4 = new Order("Emilie");
        Order order5 = new Order("Coco");
        order1.addItem(item1);
        order1.addItem(item4);
        System.out.println(order1.getStatusMessage());
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order1.getOrderTotal());

        order3.addItem(item1);
        order3.addItem(item4);
        order3.addItem(item2);
        order3.display();
        

    }
}