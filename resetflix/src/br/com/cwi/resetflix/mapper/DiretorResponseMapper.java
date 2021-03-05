package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

public class DiretorResponseMapper {
    public DiretoresResponse mapear(DiretorEntity entity){
        return new DiretoresResponse(entity.getId(), entity.getNome());
    }
}