package microservice.store2.servicegateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGateway2Application.class, args);
	}

}
