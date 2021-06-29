package restaurant.list.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.list.dto.RestaurantDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @BeforeEach
    public void init() {
        restaurantService = new RestaurantService();
    }
/*
    @Test
    public void checkRestaurant() {
        // given
        List<RestaurantDTO> list = restaurantService.setRestaurant("https://www.mangoplate.com/search/%EB%8F%99%ED%83%842");

        // when
        RestaurantDTO info = list.get(16);

        // then
        assertThat(info.getName()).isEqualTo("조선평양냉면");
        assertThat(list.size()).isEqualTo(20);
        assertThat(info.getLink()).isEqualTo("https://www.mangoplate.com/restaurants/rR2im5Ed9R2M");
    }
 */
}
