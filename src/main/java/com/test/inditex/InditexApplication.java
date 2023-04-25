package com.test.inditex;

import com.test.inditex.entity.PricesEntity;
import com.test.inditex.repository.PricesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class InditexApplication {

	public static void main(String[] args) {
		SpringApplication.run(InditexApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PricesRepository repository) {
		return (args) -> {
			// initialize data
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
			repository.save(new PricesEntity(1,1, LocalDateTime.parse("2020-06-14-00.00.00",formatter)
					,LocalDateTime.parse("2020-12-31-23.59.59",formatter),35455,0,35.50,"EUR"));
			repository.save(new PricesEntity(2,1, LocalDateTime.parse("2020-06-14-15.00.00",formatter)
					,LocalDateTime.parse("2020-06-14-18.30.00",formatter),35455,1,25.45,"EUR"));
			repository.save(new PricesEntity(3,1, LocalDateTime.parse("2020-06-15-00.00.00",formatter)
					,LocalDateTime.parse("2020-06-15-11.00.00",formatter),35455,1,30.50,"EUR"));
			repository.save(new PricesEntity(4,1, LocalDateTime.parse("2020-06-15-16.00.00",formatter)
					,LocalDateTime.parse("2020-12-31-23.59.59",formatter),35455,1,38.95,"EUR"));

		};
	}
}
