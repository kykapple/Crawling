package restaurant.list.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import restaurant.list.dto.RestaurantDTO;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class MybatisRestaurantRepository implements RestaurantRepository {     // H2 DB 사용

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public MybatisRestaurantRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @PostConstruct
    public void createTable() {
        sqlSessionTemplate.update("RestaurantDTO.createTable");
    }

    public void insertRestaurant(RestaurantDTO restaurantDTO) {
        sqlSessionTemplate.insert("RestaurantDTO.insert", restaurantDTO);
    }

    public void insertRestaurantList(List<RestaurantDTO> list) {
        for (RestaurantDTO restaurantDTO : list) {
            sqlSessionTemplate.insert("RestaurantDTO.insert", restaurantDTO);
        }
    }

    public RestaurantDTO getRestaurant(RestaurantDTO restaurantDTO) {
        return sqlSessionTemplate.selectOne("RestaurantDTO.select", restaurantDTO);
    }

    public List<RestaurantDTO> getRestaurantList() {
        return sqlSessionTemplate.selectList("RestaurantDTO.selectAll");
    }

    public void deleteRestaurantList() {
        sqlSessionTemplate.delete("RestaurantDTO.deleteAll");
    }
}
