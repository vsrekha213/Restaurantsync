package ProjectRestaurantSync.RestaurantSync.src;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class DeliveryPerson extends Thread {
    private final BlockingQueue<Order> orderQueue;
    private final Map<String, Integer> menu;

    public DeliveryPerson(String name, BlockingQueue<Order> orderQueue, Map<String, Integer> menu) {
        super(name);
        this.orderQueue = orderQueue;
        this.menu = menu;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = orderQueue.take();
                System.out.println(getName() + " received order: " + order);

                int deliveryTime = menu.get(order.getItem()) * order.getQuantity() * 1000;
                Thread.sleep(deliveryTime);

                System.out.println(getName() + " delivered order: " + order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
