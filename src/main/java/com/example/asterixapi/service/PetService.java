package com.example.asterixapi.service;

import com.example.asterixapi.dto.Pet;
import com.example.asterixapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private IdService idService;

    @PostConstruct
    public void init() {
        petRepository.deleteAll();
        petRepository.saveAll(List.of(
                new Pet(idService.randomId(), "Idefix", "Dog", "2") // Obelix's pet
        ));
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}