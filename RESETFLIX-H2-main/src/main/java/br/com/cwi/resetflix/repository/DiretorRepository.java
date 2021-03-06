package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;

import java.util.List;

@Repository
public interface DiretorRepository extends JpaRepository<DiretorEntity, Long> {

    List<DiretorEntity> findAll();



}
