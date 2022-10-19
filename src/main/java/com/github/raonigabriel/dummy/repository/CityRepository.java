package com.github.raonigabriel.dummy.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.github.raonigabriel.dummy.model.CityEntity;

import reactor.core.publisher.Flux;

public interface CityRepository extends ReactiveCrudRepository<CityEntity, Long> {

    Flux<CityEntity> findByName(String name);

}