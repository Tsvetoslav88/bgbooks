package org.vexelon.net.bgbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"org.vexelon.net.bgbooks"})
//@EnableJpaRepositories("org.vexelon.net.bgbooks.repository")
//@EntityScan("org.vexelon.net.bgbooks.model")
public class BgbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgbooksApplication.class, args);
	}

}
