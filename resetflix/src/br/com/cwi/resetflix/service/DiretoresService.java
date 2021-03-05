package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretoresResponseMapper;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretoresService {

    @Autowired
    private DiretoresRepository diretoresRepository;

    static DiretoresResponseMapper MAPPER_RESPONSE = new DiretoresResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();
    static ConsultarDetalhesDiretorResponseMapper MAPPER_DETAILS_DIRETOR = new ConsultarDetalhesDiretorResponseMapper();


    @Autowired
    private FilmeRepository filmeRepository;

    public List<DiretoresResponse> getDiretores(){
        List<DiretorEntity> diretores =  diretoresRepository.getDiretores();
        return MAPPER_RESPONSE.mapear(diretores);
    }

    public Long create(CriarDiretorRequest request) {
        // ToDO Validar dados de entrada
        Long idCreated = diretoresRepository.addDiretor(MAPPER_ENTITY.mapear(request));
        return  idCreated;
    }

    public ConsultarDetalhesDiretorResponse getDiretorById(final Long id) {
        DiretorEntity diretorEntity = diretoresRepository.findById(id);
        if(diretorEntity == null){
            throw new NotFoundException("Diretor não encontrado para este ID");
        }
        List<FilmeEntity> filmesDiretor = filmeRepository.acharFilmesAtor(id);
        return MAPPER_DETAILS_DIRETOR.mapear(diretorEntity, filmesDiretor);
    }
}