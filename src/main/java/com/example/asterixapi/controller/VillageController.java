package com.example.asterixapi.controller;

import com.example.asterixapi.dto.Village;
import com.example.asterixapi.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix/villages")
public class VillageController {

    @Autowired
    private VillageService villageService;

    @GetMapping
    public List<Village> getAllVillages() {
        return villageService.getAllVillages();
    }
}