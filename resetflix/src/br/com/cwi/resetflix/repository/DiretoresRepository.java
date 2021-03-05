package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DiretoresRepository {

    static List<DiretorEntity> diretores = new ArrayList<>();
    static Long nextId = 1L;

    public List<DiretorEntity> getDiretores(){
        return diretores;
    }

    public Long addDiretor(DiretorEntity diretor){
        diretor.setId(nextId);
        diretores.add(diretor);
        nextId++;
        return diretor.getId();
    }

    public DiretorEntity findById(Long id) {
        for (DiretorEntity diretor: this.diretores){
            if(diretor.getId().equals(id)){
                return diretor;
            }
        }
        throw new NotFoundException("Não foi encontrado Diretor com ID " + id);
    }

    public boolean diretorExistsWithId(Long id){
        List<Long> listIds =  diretores.stream().map(entity -> entity.getId()).collect(Collectors.toList());
        return listIds.contains(id);
    }
}