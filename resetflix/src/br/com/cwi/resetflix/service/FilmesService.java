package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETAILS = new ConsultarDetalhesFilmeResponseMapper();

    public List<FilmeResponse> getFilmes(Genero genero){
        List<FilmeEntity> filmes;
        if (genero == null) {
            filmes = filmeRepository.getFilmes();
        } else {
            filmes = filmeRepository.getFilmesByGenero(genero);
        }
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public Long createFilme(CriarFilmeRequest request) {
        boolean diretorInvalido = !diretoresRepository.diretorExistsWithId(request.getIdDiretor());
        if(diretorInvalido){
            throw new NotFoundException("Diretor não encontrado para o ID " + request.getIdDiretor());
        }


        for (Long idAtor: request.getIdsAtores()){
            boolean atorInvalido = !atoresRepository.atorExistsWithId(idAtor);
            if(atorInvalido){
                throw new NotFoundException("Ator não encontrado para o ID" + idAtor);
            }
        }

        return filmeRepository.save(MAPPER_ENTITY.mapear(request));
    }


    public ConsultarDetalhesFilmeResponse getFilmeById(Long id) {

        FilmeEntity filme = buscarFilme(id);

        DiretorEntity diretor = diretoresRepository.findById(filme.getIdDiretor());

        List<AtorEntity> atores = filme.getIdsAtores().stream()
                .map(idAtor -> atoresRepository.acharAtorPorId(idAtor))
                .collect(Collectors.toList());

        return MAPPER_DETAILS.mapear(filme, diretor, atores);
    }

    private FilmeEntity buscarFilme(Long id) {
        List<FilmeEntity> filmes = filmeRepository.getFilmes();
        for(FilmeEntity filme : filmes){
            if(filme.getId().equals(id)){
                return filme;
            }
        }
        throw new NotFoundException("Filme não encontrado para o ID " + id);
    }
}