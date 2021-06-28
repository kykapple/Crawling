package restaurant.list;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;


@SpringBootTest
class ListApplicationTests {

	@Autowired
	DataSource dataSource;
	@Autowired
	SqlSession sqlSession;

	// 스프링 부트가 application.properties 설정 파일을 기반으로 DataSource(특정 데이터베이스 드라이버)를 자동으로 생성해준다.
	// 또한 이를 기반으로 SqlSessionFactoryBean과 SqlSession도 자동으로 생성해서 스프링 빈으로 등록해준다.
	// 매우 편리해짐
	// Hikari CP에 대해서 알아보기
	@Test
	void contextLoads() throws Exception {
		Connection connection = dataSource.getConnection();
		System.out.println("connection.getClass() = " + connection.getClass());
		System.out.println("connection.getMetaData().getURL() = " + connection.getMetaData().getURL());
		System.out.println("connection.getMetaData().getUserName() = " + connection.getMetaData().getUserName());

		System.out.println("sqlSession = " + sqlSession.getClass());
	}

}
