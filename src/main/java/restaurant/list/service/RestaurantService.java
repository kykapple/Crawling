package restaurant.list.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import restaurant.list.domain.Restaurant_Info;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final List<Restaurant_Info> list = new ArrayList<>();

    public List<Restaurant_Info> setRestaurant(String url) {
        Document document = new RestaurantService().getCrawlingResult(url);
        Elements contents = document.select("figure.restaurant-item");

        for (Element content : contents) {
            // 이미지 영역
            Elements imgSrc = content.select("a.only-desktop_not > div.thumb > img");
            // 이름 및 음식 종류 영역
            Elements restaurantSrc = content.select("div.info");

            String name = restaurantSrc.select("h2.title").text();
            String type = restaurantSrc.select("p.etc > span").text();
            String img = imgSrc.attr("data-original");

            list.add(
                Restaurant_Info.builder()
                        .name(name)
                        .type(type)
                        .img(img)
                        .build()
            );
        }

        return list;
    }

    public String getRestaurant() {
        return list.stream()
                .map(Restaurant_Info::toString)
                .collect(Collectors.joining(", \n"));
    }

    public Document getCrawlingResult(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch(IOException e) {
            throw new RuntimeException("Crawling failed");
        }
    }

}
