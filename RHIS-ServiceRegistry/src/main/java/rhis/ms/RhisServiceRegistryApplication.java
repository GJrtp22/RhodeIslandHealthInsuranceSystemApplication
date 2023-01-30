package rhis.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RhisServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhisServiceRegistryApplication.class, args);
		//service registry
	}

}
