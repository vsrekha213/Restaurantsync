package ProjectRestaurantSync.RestaurantSync.src;

public class Order {
    private String customerName;
    private String itemName;
    private int quantity;

    public Order(String customerName, String itemName, int quantity) {
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // Getters and setters for customerName, itemName, and quantity

    public String getItem(){
        return itemName;
    }

    public int getQuantity(){
        return quantity;
    }
}
