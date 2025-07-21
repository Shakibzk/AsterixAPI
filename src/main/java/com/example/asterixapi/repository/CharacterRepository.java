package com.example.asterixapi.repository;

import com.example.asterixapi.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
}