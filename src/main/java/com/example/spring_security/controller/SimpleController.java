package com.example.spring_security.controller;

import com.example.spring_security.model.DeveloperModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class SimpleController {
    List<DeveloperModel> developersList = List.of(
            new DeveloperModel(1L, "Bob"),
            new DeveloperModel(2L, "Tom")
    );

    @GetMapping
    List<DeveloperModel> getAll() {
        return developersList;
    }

    @PostMapping
    DeveloperModel createDeveloper(@RequestBody DeveloperModel developer){
        developersList.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        developersList.removeIf(developerModel -> developerModel.getId().equals(id));
    }
}
