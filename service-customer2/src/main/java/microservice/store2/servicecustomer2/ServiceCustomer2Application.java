package microservice.store2.servicecustomer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceCustomer2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCustomer2Application.class, args);
	}

}
