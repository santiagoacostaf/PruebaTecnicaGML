package com.gml.pokemon.service;

import io.spring.guides.gs_producing_web_service.GetPokemonRequest;
import io.spring.guides.gs_producing_web_service.GetPokemonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CountryRepository countryRepository;

    @Autowired
    PokemonService pokemonService;

    @Autowired
    public PokemonEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        GetPokemonResponse response = new GetPokemonResponse();
        int requestPage = request.getPage();
        int requestPageSize = request.getPageSize();
        pokemonService.getAllPokemons(response.getPokemons(), requestPage, requestPageSize);
        return response;
    }
}
