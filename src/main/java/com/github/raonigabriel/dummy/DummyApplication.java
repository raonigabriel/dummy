package com.github.raonigabriel.dummy;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.r2dbc.core.DatabaseClient;

import com.github.raonigabriel.dummy.model.CityEntity;
import com.github.raonigabriel.dummy.repository.CityRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class DummyApplication implements CommandLineRunner {

	final DatabaseClient databaseClient;
    final CityRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DummyApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		databaseClient.sql("CREATE TABLE city_entity (id serial primary key, name varchar(50))").fetch().all().blockLast();

		final List<CityEntity> cities = Arrays.asList(new CityEntity(null, "London"), new  CityEntity(null, "Curitiba"));
        repository.deleteAll().block();
        repository.saveAll(cities).then().block();
        log.info("Added: {}", cities);
	}

}
