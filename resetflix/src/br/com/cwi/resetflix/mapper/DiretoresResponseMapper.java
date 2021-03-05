package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;
import java.util.stream.Collectors;

public class DiretoresResponseMapper {
    public List<DiretoresResponse> mapear(final List<DiretorEntity> diretores){
        List<DiretoresResponse> response = diretores.stream()
                .map(diretorEntity -> new DiretoresResponse(diretorEntity.getId(), diretorEntity.getNome()))
                .collect(Collectors.toList());
        return response;
    }
}