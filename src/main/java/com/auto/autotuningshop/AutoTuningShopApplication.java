package com.auto.autotuningshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.auto")
@EntityScan("com.auto.data.models")
@EnableJpaRepositories("com.auto.data.repositories")
public class AutoTuningShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTuningShopApplication.class, args);
	}

}
