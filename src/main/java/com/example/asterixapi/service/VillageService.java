package com.example.asterixapi.service;

import com.example.asterixapi.dto.Village;
import com.example.asterixapi.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private IdService idService;

    @PostConstruct
    public void init() {
        villageRepository.deleteAll();
        villageRepository.saveAll(List.of(
                new Village(idService.randomId(), "Gallic Village", "Gaul"),
                new Village(idService.randomId(), "Roman Camp", "Gaul")
        ));
    }

    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }
}