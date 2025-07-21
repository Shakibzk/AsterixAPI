package com.example.asterixapi.service;

import com.example.asterixapi.model.Character;
import com.example.asterixapi.dto.CharacterCreationDTO;
import com.example.asterixapi.dto.CharacterUpdateDTO;
import com.example.asterixapi.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private IdService idService;

    @PostConstruct
    public void init() {
        characterRepository.deleteAll();
        characterRepository.saveAll(List.of(
                new Character("1", "Asterix", 35, "Warrior"),
                new Character("2", "Obelix", 35, "Supplier"),
                new Character("3", "Miraculix", 60, "Druid"),
                new Character("4", "Majestix", 60, "Chief"),
                new Character("5", "Troubadix", 25, "Bard"),
                new Character("6", "Gutemine", 35, "Chiefs Wife"),
                new Character("7", "Idefix", 5, "Dog"),
                new Character("8", "Geriatrix", 70, "Retiree"),
                new Character("9", "Automatix", 35, "Smith"),
                new Character("10", "Grockelix", 35, "Fisherman")
        ));
    }

    public List<Character> getAllCharacters(Integer maxAge) {
        if (maxAge != null) {
            return characterRepository.findByAgeLessThanEqual(maxAge);
        }
        return characterRepository.findAll();
    }

    public Character createCharacter(CharacterCreationDTO characterDTO) {
        Character character = new Character(
                idService.randomId(),
                characterDTO.name(),
                characterDTO.age(),
                characterDTO.profession()
        );
        return characterRepository.save(character);
    }

    public Optional<Character> getCharacterById(String id) {
        return characterRepository.findById(id);
    }

    public void deleteCharacterById(String id) {
        characterRepository.deleteById(id);
    }

    public Optional<Character> updateCharacter(String id, CharacterUpdateDTO characterDTO) {
        Optional<Character> existingCharacter = characterRepository.findById(id);
        if (existingCharacter.isPresent()) {
            Character updatedCharacter = new Character(
                    id,
                    characterDTO.name(),
                    characterDTO.age(),
                    characterDTO.profession()
            );
            return Optional.of(characterRepository.save(updatedCharacter));
        }
        return Optional.empty();
    }
}