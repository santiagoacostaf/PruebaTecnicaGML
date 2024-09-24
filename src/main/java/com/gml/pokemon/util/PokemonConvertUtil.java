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

    /*public Page<Pokemon> getPage(Pageable pageable, List<Pokemon> list) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        List<Pokemon> sublist = list.subList(start, end);
        return new PageImpl<>(sublist, pageable, list.size());
    }*/

}
