package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ConsultarDetalhesFilmeResponseMapper {

    public ConsultarDetalhesFilmeResponse mapear(final FilmeEntity filme, final DiretorEntity diretor, final List<AtorEntity> atores) {
        List<AtoresResponse> atoresResponse = atores.stream()
                .map(ator -> new AtorResponseMapper().mapear(ator))
                .collect(Collectors.toList());

        DiretoresResponse diretorResponse = new DiretorResponseMapper().mapear(diretor);

        ConsultarDetalhesFilmeResponse response =
                new ConsultarDetalhesFilmeResponse(filme.getId(), filme.getNome(), filme.getGenero(), diretorResponse, atoresResponse);
        return response;
    }
}