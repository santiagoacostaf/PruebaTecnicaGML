package com.gml.pokemon.service;

import io.spring.guides.gs_producing_web_service.Pokemon;

import java.util.List;


public interface PokemonService {
    
    List<io.spring.guides.gs_producing_web_service.Pokemon> getAllPokemons(List<Pokemon> pokemons, int requestPage, int requestPageSize);
}
