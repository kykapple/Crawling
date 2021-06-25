package restaurant.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.list.domain.Restaurant_Info;
import restaurant.list.service.RestaurantService;

import java.util.List;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Restaurant_Info> list = restaurantService.setRestaurant();
        model.addAttribute("list", list);

        System.out.println(restaurantService.getRestaurant());

        return "index";
    }
}
