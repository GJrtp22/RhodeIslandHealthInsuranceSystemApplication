package rhis.ms.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RhisCorrespondanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhisCorrespondanceApplication.class, args);
	}

}
