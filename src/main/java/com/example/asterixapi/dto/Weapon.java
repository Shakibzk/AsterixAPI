package com.example.asterixapi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weapons")
public record Weapon(@Id String id, String name, String type, String ownerId) {}