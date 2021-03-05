package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();
    static Long nextId = 1L;

    public List<FilmeEntity> getFilmes(){
        return filmes;
    }

    public List<FilmeEntity> getFilmesByGenero(Genero genero) {
        return filmes.stream()
                .filter(filmeEntity -> filmeEntity.getGenero().equals(genero))
                .collect(Collectors.toList());
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        //TODO Filtrar na repository por id de ator
        return filmes;
    }

    public Long save(FilmeEntity filme) {
        filme.setId(nextId);
        filmes.add(filme);
        nextId++;
        return filme.getId();
    }
}


//package br.com.cwi.resetflix.repository;
//
//import static java.util.Arrays.asList;
//
//import java.util.Collections;
//import java.util.List;
//
//import br.com.cwi.resetflix.domain.Genero;
//import org.springframework.stereotype.Repository;
//
//import br.com.cwi.resetflix.entity.FilmeEntity;
//
//@Repository
//public class FilmeRepository {
//
//    static List<FilmeEntity> filmes = Collections.singletonList(
//            new FilmeEntity(1l,"Interestelar", Genero.FICCAO_CIENTIFICA,
//                    1l, asList(1l))
//    );
//
//    public List<FilmeEntity> getFilmes(){
//        return filmes;
//    }
//
//    public List<FilmeEntity> acharFilmesAtor(final Long id) {
//        //TODO Filtrar na repository por id de ator
//        return filmes;
//    }
//
//    public List<FilmeEntity> acharFilmesDiretor(Long id) {
//        //TODO Filtrar na repository por id de diretor
//        return filmes;
//    }
//}