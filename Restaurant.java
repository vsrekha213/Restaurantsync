package ProjectRestaurantSync.RestaurantSync.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Restaurant {
    private static final int MAX_ORDER_QUANTITY = 10;

    public static void main(String[] args) {
//        Map<String, Integer> menu = new HashMap<>();
//        menu.put("Pizza", 5);
//        menu.put("Burger", 10);
//        menu.put("Fries", 15);

        Map<String, Integer> menu = new HashMap<>();
        Menu resMenu = new Menu();
        menu = resMenu.getMenu();

        PriceCal price = new PriceCal();

        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(MAX_ORDER_QUANTITY);

        Chef chef1 = new Chef("Chef1", orderQueue, menu);
        Chef chef2 = new Chef("Chef2", orderQueue, menu);

        DeliveryPerson deliveryPerson1 = new DeliveryPerson("DeliveryPerson1", orderQueue, menu);
        DeliveryPerson deliveryPerson2 = new DeliveryPerson("DeliveryPerson2", orderQueue, menu);

        chef1.start();
        chef2.start();
        deliveryPerson1.start();
        deliveryPerson2.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();

            System.out.println("Please select an item from the menu:");
            for (String item : menu.keySet()) {
                System.out.println(item);
            }
            String item = scanner.nextLine();

            System.out.println("Please enter the quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());
            Order order = null;

            if(menu.containsKey(item) && menu.get(item) >= quantity) {
                order = new Order(name, item, quantity);
                System.out.println("Amount to be paid" + price.getPrice(item) * quantity);
                resMenu.decrementQuantity(item);
            }

            else {
                System.out.println("Item not available");
                continue;
            }

            try {
                orderQueue.put(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
