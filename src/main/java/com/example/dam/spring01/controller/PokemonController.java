package com.example.dam.spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.dam.spring01.entity.Pokemon;
import com.example.dam.spring01.service.PokemonService;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon-list-by-id")
    public List<Pokemon> getPokemonListById() {
        return pokemonService.getPokemonListById();
    }
}
