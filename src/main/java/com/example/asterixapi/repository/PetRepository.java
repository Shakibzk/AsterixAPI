package com.example.asterixapi.repository;

import com.example.asterixapi.dto.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {}