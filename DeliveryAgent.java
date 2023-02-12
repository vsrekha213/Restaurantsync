class DeliveryAgent implements Runnable {
    private Customer customer;
    public DeliveryAgent(Customer customer) {
        this.customer = customer;
    }

    public void run() {
        try {
            FoodOrdering.agentSemaphore.acquire();
            System.out.println("Delivery Agent is delivering " + customer.getFood() + " to " + customer.getName());
            Thread.sleep(3000);
            System.out.println("Delivery Agent has delivered " + customer.getFood() + " to " + customer.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            FoodOrdering.agentSemaphore.release();
        }
    }
}