import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        Restaurant restaurantResult = null;
        boolean searchFlag=false;
        for(Restaurant restaurant: restaurants){
            if(restaurant.getName().equals(restaurantName)) {
                System.out.println("in class loop is "+restaurant);
                restaurantResult = restaurant;
                searchFlag=true;
            }
        }

        if(!searchFlag)
            throw new restaurantNotFoundException(restaurantName);

        return restaurantResult;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        System.out.println("Adding "+newRestaurant);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        return restaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if (restaurantToBeRemoved == null)
            throw new restaurantNotFoundException(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
