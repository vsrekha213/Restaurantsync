package ProjectRestaurantSync.RestaurantSync.src;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<String, Integer> menu = new HashMap<>();
    Menu(){
        this.menu.put("Pizza", 5);
        this.menu.put("Burger", 10);
        this.menu.put("Fries", 15);
    }
    public Map<String, Integer> getMenu(){
        return this.menu;
    }

    public void decrementQuantity(String item){
        this.menu.put(item, this.menu.get(item)-1);
    }


}
