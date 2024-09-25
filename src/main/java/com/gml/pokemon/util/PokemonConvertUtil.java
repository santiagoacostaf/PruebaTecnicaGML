package com.gml.pokemon.util;

/*import com.example.demo.Model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;*/
import com.gml.pokemon.Model.Pokemon;

import java.util.*;

public class PokemonConvertUtil {
    
    
    public List<Pokemon> convertToList(LinkedHashMap pokemons) {
        Iterator<HashMap> iterator = ((List<HashMap>) pokemons.get("results")).iterator();
        List<Pokemon> returnList = new ArrayList<>();
        HashMap currentIterator;
        while(iterator.hasNext()) {
            currentIterator = iterator.next();
            Pokemon currentPokemon = PokemonFactory.createPokemon((String)currentIterator.get("name"), 
                (String)currentIterator.get("url"));
            returnList.add(currentPokemon);
        }
        return returnList;
    }

    public List<io.spring.guides.gs_producing_web_service.Pokemon> convertToList(List<io.spring.guides.gs_producing_web_service.Pokemon> pokemonList,
                                                                                 List<Pokemon> pokemons) {
        List<io.spring.guides.gs_producing_web_service.Pokemon> returnList = new ArrayList<>();
        for(int i=0; i<pokemons.size(); i++) {
            io.spring.guides.gs_producing_web_service.Pokemon xmlPokemon = new io.spring.guides.gs_producing_web_service.Pokemon();
            xmlPokemon.setName(pokemons.get(i).getName());
            xmlPokemon.setUrl(pokemons.get(i).getUrl());
            pokemonList.add(xmlPokemon);
        }
        return pokemonList;
    }

    public List<Pokemon> getPage(List<Pokemon> list, int requestPage, int requestPageSize) {
        int start = requestPage * requestPageSize;
        int end = Math.min((start + requestPageSize), list.size());
        List<Pokemon> sublist = list.subList(start, end);
        return sublist;
    }

}
