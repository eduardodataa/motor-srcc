package br.com.itau.integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.integrador.entity.Endereco;

public interface SalvarEnderecoRepository extends JpaRepository<Endereco, Long>{

}
