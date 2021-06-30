package restaurant.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import restaurant.list.dto.PageDTO;
import restaurant.list.dto.PageMaker;
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

    @GetMapping("/where")
    public String showRestaurants(@RequestParam("location") String location, PageDTO pageDTO, Model model) {
//        restaurantService.deleteRestaurantList();
        restaurantService.setRestaurantList("https://www.mangoplate.com/search/", location);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setPageDTO(pageDTO);
        pageMaker.setTotalCnt(restaurantService.getRestaurantListCnt());

        model.addAttribute("list", restaurantService.getRestaurantList(pageDTO));
        model.addAttribute("location", location);
        model.addAttribute("pageMaker", pageMaker);

        return "list";
    }

    @GetMapping("/reset")
    public String reset() {
        return "index";
    }
}
