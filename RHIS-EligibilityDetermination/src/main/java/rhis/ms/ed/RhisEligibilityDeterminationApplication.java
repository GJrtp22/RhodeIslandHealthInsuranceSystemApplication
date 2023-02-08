package rhis.ms.ed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RhisEligibilityDeterminationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhisEligibilityDeterminationApplication.class, args);
	}

}
