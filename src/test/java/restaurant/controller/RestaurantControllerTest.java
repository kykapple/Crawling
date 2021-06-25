package restaurant.controller;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import restaurant.list.domain.Restaurant_Info;
import restaurant.list.service.RestaurantService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.*;
import static org.mockserver.model.HttpResponse.*;

public class RestaurantControllerTest {

    private final int PORT = 9000;
    private ClientAndServer mockServer;

    @BeforeEach
    public void init() {
        mockServer = ClientAndServer.startClientAndServer(PORT);
        System.out.println("mock server start");
    }

    @Test
    public void restaurantMockServerTest() {
        createRankingPageServer("Dongtan_restaurant_ranking.html");
        List<Restaurant_Info> list = new RestaurantService().setRestaurant("http://localhost:9000/search/%EB%8F%99%ED%83%842");
        assertThat(list.size()).isEqualTo(20);
    }

    @AfterEach
    public void close() {
        mockServer.stop();
        System.out.println("mock server stop");
    }

    // respond에서 withBody에 왜 바이트 스트림 받아와야 하는지 공부하기 -> HTTP body에 바이트 코드가 실리는 건가?
    private void createRankingPageServer(String path) {
        byte[] response = readHtmlFile(path);

        new MockServerClient("localhost", PORT)
                .when(
                        request()
                        .withMethod("GET")
                        .withPath("/search/%EB%8F%99%ED%83%842")
                )
                .respond(
                        response()
                        .withStatusCode(200)
                        .withBody(response)
                );
    }

    private byte[] readHtmlFile(String path) {
        InputStream resourceAsStream = getClass().getClassLoader()
                .getResourceAsStream(path);
        try {
            assert resourceAsStream != null;
            return IOUtils.toByteArray(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file IO 실패");
        }
    }
}
