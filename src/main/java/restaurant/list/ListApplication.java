package restaurant.list;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class ListApplication {
	public static void main(String[] args) {
		SpringApplication.run(ListApplication.class, args);


	}

}
