package restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.list.domain.Restaurant_Info;
import restaurant.list.service.RestaurantService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantServiceTest {

    private RestaurantService restaurantService = new RestaurantService();

    @Test
    public void checkRestaurant() {
        // given
        List<Restaurant_Info> list = restaurantService.setRestaurant();

        // when
        Restaurant_Info info = list.get(16);

        // then
        assertThat(info.getName()).isEqualTo("조선평양냉면");
        assertThat(list.size()).isEqualTo(20);
    }
}
