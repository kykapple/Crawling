package restaurant.list.repository;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MybatisRestaurantRepositoryTest {

    // XML 기반 스프링 컨테이너를 통해 Mybatis와 연동하는 과정
    // 설정해줄 부분이 많다.
    @Test
    public void mybatisConnectionTest() throws Exception {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("AppConfig.xml");
//        SqlSessionFactoryBean sqlSessionFactoryBean = ac.getBean(SqlSessionFactoryBean.class);
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = ac.getBean(SqlSession.class);

        assertThat(sqlSession).isInstanceOf(SqlSession.class);
    }
}
