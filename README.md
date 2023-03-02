# Restaurantsync
Problem Objective
The problem is to design an application for a restaurant that manages the entire process from order placement to food delivery.  
The system has four main components: Customer, Menu, Kitchen, and Delivery. 
When a customer places an order, a unique ID is generated, and the order is processed by checking the availability of the menu. 
The kitchen prepares the order, and the delivery component assigns the order to a free delivery agent and delivers the food. 
The system uses semaphores to synchronize access to shared data structures and avoid race conditions.
 The kitchen can start preparing an order while the delivery thread is delivering a different order, and the delivery thread can pick up the order once it is ready. 
The system assumes n customers and 10 delivery agents, and orders can only be placed if the food item is available. 
The orders are processed by 2 chefs, and if all delivery agents are busy, the system waits until a delivery agent is free to assign the order. 
Additionally, the system supports accepting phone orders from customers.

