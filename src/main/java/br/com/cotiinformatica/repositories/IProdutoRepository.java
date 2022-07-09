package br.com.cotiinformatica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Produto;

public interface IProdutoRepository extends CrudRepository<Produto, Integer>{
	
	
    @Query("select p from Produto p where lower(p.nome) like lower(concat('%', :param1,'%'))")
	List<Produto> findByNome(@Param("param1") String nome);
}
