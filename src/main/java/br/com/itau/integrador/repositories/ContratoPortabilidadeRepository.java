package br.com.itau.integrador.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.integrador.entity.ContratoPortabilidade;

@Repository
public interface ContratoPortabilidadeRepository extends JpaRepository<ContratoPortabilidade, Long>{

}


