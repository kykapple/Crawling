package restaurant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestaurantControllerTest {

    private MockMvc mockMvc;

//    @BeforeEach
//    public void init() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(
//                new RestaurantController()
//        ).build();
//    }

    @Test
    public void indexPage() throws Exception {
        ResultActions perform = mockMvc.perform(get("/"));
        perform.andExpect(status().isOk()).andExpect(content().string("index"));
    }
}
