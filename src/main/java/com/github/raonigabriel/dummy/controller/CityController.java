package com.github.raonigabriel.dummy.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.raonigabriel.dummy.model.CityEntity;
import com.github.raonigabriel.dummy.repository.CityRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {
    
    final CityRepository repository;

    @GetMapping
    @Transactional(readOnly = true)
    public Flux<CityEntity> getAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    @Transactional(readOnly = true)
    public Mono<CityEntity> getById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

}
