package rhis.ms.ar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RhisApplicationRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhisApplicationRegistrationApplication.class, args);
	}

}
