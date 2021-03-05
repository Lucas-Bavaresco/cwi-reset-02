package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;

public class AtorResponseMapper {

    public AtoresResponse mapear(final AtorEntity entity){
        return new AtoresResponse(entity.getId(), entity.getNome());
    }
}