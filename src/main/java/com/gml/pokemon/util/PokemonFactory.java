package com.gml.pokemon.util;

import com.gml.pokemon.Model.Pokemon;

public class PokemonFactory {
     public static Pokemon createPokemon(String name, String url) {
        Pokemon pokemon = new Pokemon();
        pokemon.setUrl(url);
        pokemon.setName(name);
        return pokemon;
    }
}
