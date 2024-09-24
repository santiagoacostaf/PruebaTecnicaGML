package com.gml.pokemon.serviceImpl;

import com.gml.pokemon.Model.Pokemon;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.gml.pokemon.service.PokemonService;
import com.gml.pokemon.util.PokemonConvertUtil;
import java.util.LinkedHashMap;
import java.util.List;

@Component("PokemonService")
public class PokemonServiceImpl implements PokemonService {

    private final String apiUrl = "https://pokeapi.co/api/v2/pokemon";

    PokemonConvertUtil pokemonConvertUtil = new PokemonConvertUtil();

    @Override
    public List<Pokemon> getAllPokemons() {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl ;
        LinkedHashMap retrivedInformation = restTemplate.getForObject(url, LinkedHashMap.class);
        List<Pokemon> pokemons = pokemonConvertUtil.convertToList(retrivedInformation);
        //Page<Pokemon> pagePokemons = pokemonConvertUtil.getPage(pageable, pokemons);
        return pokemons;

    }
}