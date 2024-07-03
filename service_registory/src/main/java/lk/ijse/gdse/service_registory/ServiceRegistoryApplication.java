package lk.ijse.gdse.service_registory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistoryApplication.class, args);
	}

}
