package com.example.asterixapi.repository;

import com.example.asterixapi.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepository extends MongoRepository<Character, String> {
    List<Character> findByAgeLessThanEqual(int maxAge);
}