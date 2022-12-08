package hanzanDB.hanzan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Async
public class HanzanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanzanApplication.class, args);
	}

}
