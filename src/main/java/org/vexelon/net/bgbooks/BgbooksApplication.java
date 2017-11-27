package org.vexelon.net.bgbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.vexelon.net.bgbooks.repository")
public class BgbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgbooksApplication.class, args);
	}
}
