package restaurant.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import restaurant.list.domain.Restaurant_Info;
import restaurant.list.service.RestaurantService;

import java.util.List;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final String URL = "https://www.mangoplate.com/search/%EB%8F%99%ED%83%842";

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/")
    public String getRestaurant(Model model) {
        List<Restaurant_Info> list = restaurantService.setRestaurant(URL);
        model.addAttribute("list", list);

        return "index";
    }
}
