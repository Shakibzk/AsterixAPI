package com.example.asterixapi.service;

import com.example.asterixapi.dto.Weapon;
import com.example.asterixapi.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private IdService idService;

    @PostConstruct
    public void init() {
        weaponRepository.deleteAll();
        weaponRepository.saveAll(List.of(
                new Weapon(idService.randomId(), "Sword", "Melee", "1") // Asterix's weapon
        ));
    }

    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }
}