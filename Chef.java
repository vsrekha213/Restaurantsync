package ProjectRestaurantSync.RestaurantSync.src;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Chef extends Thread {
    private final BlockingQueue<Order> orderQueue;
    private final Map<String, Integer> menu;

    public Chef(String name, BlockingQueue<Order> orderQueue, Map<String, Integer> menu) {
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

                int preparationTime = menu.get(order.getItem()) * order.getQuantity() * 1000;
                Thread.sleep(preparationTime);

                System.out.println(getName() + " prepared order: " + order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
