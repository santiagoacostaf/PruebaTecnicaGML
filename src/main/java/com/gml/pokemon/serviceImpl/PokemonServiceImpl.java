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
    public List<io.spring.guides.gs_producing_web_service.Pokemon> getAllPokemons(List<io.spring.guides.gs_producing_web_service.Pokemon> pokemons,
                                                                                  int requestPage, int requestPageSize) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl ;
        LinkedHashMap retrivedInformation = restTemplate.getForObject(url, LinkedHashMap.class);
        List<Pokemon> retrivedPokemons = pokemonConvertUtil.convertToList(retrivedInformation);
        retrivedPokemons = pokemonConvertUtil.getPage(retrivedPokemons, requestPage, requestPageSize);
        List<io.spring.guides.gs_producing_web_service.Pokemon> xmlPokemons = pokemonConvertUtil.convertToList(retrivedPokemons);
        for(int i=0; i < xmlPokemons.size(); i++) {
            pokemons.add(xmlPokemons.get(i));
        }
        return xmlPokemons;

    }
}