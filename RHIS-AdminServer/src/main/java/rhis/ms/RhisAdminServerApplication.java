package rhis.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class RhisAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhisAdminServerApplication.class, args);
		
	}

}
