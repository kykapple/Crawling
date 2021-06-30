package restaurant.list.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.list.dto.PageDTO;
import restaurant.list.dto.RestaurantDTO;
import restaurant.list.repository.RestaurantRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private ArrayList<RestaurantDTO> list = new ArrayList<>();

    @Autowired
    public void setRestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Document getCrawlingResult(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch(IOException e) {
            throw new RuntimeException("Crawling failed");
        }
    }

    public void setRestaurantList(String basicURL, String location) {
        for(int page=1; page<=10; page++) {
            Document document = new RestaurantService().getCrawlingResult(basicURL + location + "?keyword=" + location + "&page=" + page);
            Elements contents = document.select("figure.restaurant-item");

            for (Element content : contents) {
                // 이미지 영역
                Elements imgSrc = content.select("a.only-desktop_not > div.thumb > img");
                // 이름 및 음식 종류 영역
                Elements restaurantSrc = content.select("div.info");

                String img = imgSrc.attr("data-original");
                String name = restaurantSrc.select("h2.title").text();
                String type = restaurantSrc.select("p.etc > span").text();
                String link = restaurantSrc.select("a").attr("href");

                list.add(
                    RestaurantDTO.builder()
                            .name(name)
                            .type(type)
                            .img(img)
                            .link(basicURL.substring(0, basicURL.indexOf("search") - 1) + link)
                            .build()
                );
            }
        }

        restaurantRepository.insertRestaurantList(list);
    }

    public List<RestaurantDTO> getRestaurantList(PageDTO pageDTO) {
        return restaurantRepository.getRestaurantList(pageDTO);
    }

    public int getRestaurantListCnt() {
        return restaurantRepository.getRestaurantListCnt();
    }

    public void deleteRestaurantList() {
        list.clear();
        restaurantRepository.deleteRestaurantList();
    }

//    public String getRestaurant() {
//        return list.stream()
//                .map(RestaurantDTO::toString)
//                .collect(Collectors.joining(", \n"));
//    }
}
