package com.example.asterixapi.controller;

import com.example.asterixapi.model.Character;
import com.example.asterixapi.dto.CharacterCreationDTO;
import com.example.asterixapi.dto.CharacterUpdateDTO;
import com.example.asterixapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asterix/characters")
public class AsterixController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacters(@RequestParam(required = false) Integer maxAge) {
        return characterService.getAllCharacters(maxAge);
    }

    @PostMapping
    public Character createCharacter(@RequestBody CharacterCreationDTO characterDTO) {
        return characterService.createCharacter(characterDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable String id) {
        Optional<Character> character = characterService.getCharacterById(id);
        return character.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable String id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable String id, @RequestBody CharacterUpdateDTO characterDTO) {
        Optional<Character> updatedCharacter = characterService.updateCharacter(id, characterDTO);
        return updatedCharacter.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}