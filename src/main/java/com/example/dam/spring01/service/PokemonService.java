package com.example.dam.spring01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.dam.spring01.entity.Pokemon;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PokemonService {

    @Autowired
    private RestTemplate restTemplate;

    public Pokemon getPokemon(int id) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        return restTemplate.getForObject(url, Pokemon.class);
    }

    public List<Pokemon> getPokemonListById() {
        List<Pokemon> pokemonList = new ArrayList<>();

        for (int id = 1; id <= 10; id++) {
            try {
                Pokemon pokemon = getPokemon(id);

                // Obtener la URL de la imagen desde la respuesta JSON
                String url = "https://pokeapi.co/api/v2/pokemon/" + id;
                Map<String, Object> response = restTemplate.getForObject(url, Map.class);
                Map<String, Object> sprites = (Map<String, Object>) response.get("sprites");
                String imageUrl = sprites.get("front_default").toString();

                pokemon.setImageUrl(imageUrl); // Asigna la URL de la imagen

                // Generar URL de información
                String infoUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
                pokemon.setInfoUrl(infoUrl);

                pokemonList.add(pokemon);
            } catch (HttpClientErrorException e) {
                System.out.println("Error al obtener el Pokémon con ID: " + id);
            }
        }

        return pokemonList;
    }
}
