package com.example.asterixapi.repository;

import com.example.asterixapi.dto.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeaponRepository extends MongoRepository<Weapon, String> {}