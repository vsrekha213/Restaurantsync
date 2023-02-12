class Customer implements Runnable {
    private String name;
    private String food;
    private int quantity;

    public Customer(String name, String food, int quantity) {
        this.name = name;
        this.food = food;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        System.out.println("Preparing " + quantity + " " + food + "(s) for " + name + ".");
        try {
            Thread.sleep(FoodOrdering.PREPARATION_TIME * quantity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }
}
