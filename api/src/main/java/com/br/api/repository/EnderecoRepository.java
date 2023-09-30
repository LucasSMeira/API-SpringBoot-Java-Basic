package com.br.api.repository;

import com.br.api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
    
}
