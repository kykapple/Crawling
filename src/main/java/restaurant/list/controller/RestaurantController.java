package restaurant.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import restaurant.list.service.RestaurantService;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String showRestaurants(@RequestParam("location") String location, Model model) {
        restaurantService.setRestaurantList("https://www.mangoplate.com/search/" + location);
        model.addAttribute("list", restaurantService.getRestaurantList());

        return "list";
    }

    @GetMapping("/reset")
    public void reset() {
        restaurantService.deleteRestaurantList();
    }
}
