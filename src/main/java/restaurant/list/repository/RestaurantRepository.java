package restaurant.list.repository;

import restaurant.list.dto.PageDTO;
import restaurant.list.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantRepository {

    void insertRestaurant(RestaurantDTO restaurantDTO);
    void insertRestaurantList(List<RestaurantDTO> list);
    RestaurantDTO getRestaurant(RestaurantDTO restaurantDTO);
    List<RestaurantDTO> getRestaurantList(PageDTO pageDTO);
    int getRestaurantListCnt();
    void deleteRestaurantList();
}
