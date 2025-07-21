package com.example.asterixapi.controller;

import com.example.asterixapi.dto.Weapon;
import com.example.asterixapi.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix/weapons")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @GetMapping
    public List<Weapon> getAllWeapons() {
        return weaponService.getAllWeapons();
    }
}