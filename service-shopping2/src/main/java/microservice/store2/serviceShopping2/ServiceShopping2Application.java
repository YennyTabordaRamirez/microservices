package microservice.store2.serviceShopping2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceShopping2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShopping2Application.class, args);
	}

}
