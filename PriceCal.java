package ProjectRestaurantSync.RestaurantSync.src;

import java.util.HashMap;
import java.util.Map;

public class PriceCal {
    Map<String, Integer> price = new HashMap<>();
    PriceCal(){
        this.price.put("Pizza", 100);
        this.price.put("Burger", 200);
        this.price.put("Fries", 300);
    }

    public Integer getPrice(String item){
        return this.price.get(item);
    }



}
