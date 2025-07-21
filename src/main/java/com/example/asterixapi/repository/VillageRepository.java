package com.example.asterixapi.repository;

import com.example.asterixapi.dto.Village;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VillageRepository extends MongoRepository<Village, String> {}