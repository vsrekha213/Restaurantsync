import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.*;
public class FoodOrdering {

    private static final int CHEFS = 1;
    private static final int AGENTS = 1;
    private static final int MAX_QUANTITY = 2;
    static final int PREPARATION_TIME = 2000; // 2 seconds

    public static Semaphore agentSemaphore = new Semaphore(AGENTS);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Semaphore chefSemaphore = new Semaphore(CHEFS);
        Semaphore agentSemaphore = new Semaphore(AGENTS);

        HashMap<String, Integer> foodItems = new HashMap<String, Integer>();
        foodItems.put("pizza", 5);
        foodItems.put("burger", 8);
        foodItems.put("sandwich", 5);

        while (true) {
            System.out.println("Enter your name: ");
            String name = sc.next();

            System.out.println("Select your food item: ");
            for (String i : foodItems.keySet()) {
                System.out.println(i + " " + foodItems.get(i));
            }

            String food = sc.next().toLowerCase();
            System.out.println("Enter the quantity (Max " + MAX_QUANTITY + "): ");
            int quantity = sc.nextInt();

            if (!foodItems.containsKey(food) || foodItems.get(food) < quantity){
                System.out.println("Sorry, requested food item or quantity not available");
                continue;
            }

            if (quantity > MAX_QUANTITY) {
                System.out.println("You can only order up to " + MAX_QUANTITY + " dishes.");
                continue;
            }


            try {
                chefSemaphore.acquire();
                Customer customer = new Customer(name, food, quantity);

                Thread chefThread = new Thread(customer);
                chefThread.start();
                chefThread.join();
                chefSemaphore.release();
                agentSemaphore.acquire();

                DeliveryAgent deliveryAgent = new DeliveryAgent(customer);
                Thread agentThread = new Thread(deliveryAgent);
                agentThread.start();
                agentSemaphore.release();

                foodItems.put(food, foodItems.get(food) - quantity);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
