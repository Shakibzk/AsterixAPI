package com.example.asterixapi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "villages")
public record Village(@Id String id, String name, String location) {}