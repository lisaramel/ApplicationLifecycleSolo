package com.example.springdocker.controller;

import com.example.springdocker.model.Animal;
import com.example.springdocker.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnimalController {
    private final AnimalService service;

    @GetMapping("/animals")
    public List<Animal> getFoods() {
        return service.getAnimals();
    }

    @PostMapping("/animals")
    public void saveNewFood(@RequestBody Animal animal) {
        service.saveNewAnimal(animal);
    }

    @GetMapping("/animals/owned")
    public List<String> getOwnedAnimals() {
        return service.getOwnedAnimals();
    }
}
