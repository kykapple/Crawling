package restaurant.list;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import restaurant.list.dto.RestaurantDTO;
import restaurant.list.repository.MybatisRestaurantRepository;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class ListApplicationTests {

	@Autowired
	private MybatisRestaurantRepository mybatisRestaurantRepository;

	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;

	// 스프링 부트가 application.properties 설정 파일을 기반으로 DataSource(특정 데이터베이스 드라이버)를 자동으로 생성해준다.
	// 또한 이를 기반으로 SqlSessionFactoryBean과 SqlSession도 자동으로 생성해서 스프링 빈으로 등록해준다.
	// 매우 편리해짐
	// Hikari CP에 대해서 알아보기
	@Test
	public void contextLoads() throws Exception {
		Connection connection = dataSource.getConnection();
		System.out.println("connection.getClass() = " + connection.getClass());
		System.out.println("connection.getMetaData().getURL() = " + connection.getMetaData().getURL());
		System.out.println("connection.getMetaData().getUserName() = " + connection.getMetaData().getUserName());

		System.out.println("sqlSession = " + sqlSession.getClass());
	}

	@Test
	public void insertTest() {
		RestaurantDTO restaurantDTO =
				RestaurantDTO.builder()
						.name("하얀풍차")
						.type("베이커리")
						.img("temp.jpg")
						.link("https://www.mangoplate.com/restaurants/F-koH0__EdyV")
						.build();

		mybatisRestaurantRepository.insertRestaurant(restaurantDTO);
		RestaurantDTO result = mybatisRestaurantRepository.getRestaurant(restaurantDTO);

		assertThat(result).isInstanceOf(RestaurantDTO.class);
		assertThat(result.getName()).isEqualTo(restaurantDTO.getName());
	}

}
