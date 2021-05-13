package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnimalService {
    private final AnimalRepository repository;

    public List<Animal> getAnimals() {
        return repository.findAll();
    }

    public void saveNewAnimal(Animal animal) {
        repository.save(animal);
    }

    public List<String> getOwnedAnimals() {
        // hämtar alla Animals som vi ägt
        List<Animal> ownedAnimals = repository.findAnimalsByOwned(true);

        // returnerar endast Food namnen i en lista
        return ownedAnimals.stream()
                .map(animal -> animal.getType())
                .collect(Collectors.toList());
    }
}
