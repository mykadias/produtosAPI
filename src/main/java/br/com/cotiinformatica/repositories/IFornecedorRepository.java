package br.com.cotiinformatica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Fornecedor;

public interface IFornecedorRepository extends CrudRepository<Fornecedor, Integer> {

    @Query("select f from Fornecedor f where lower(f.nome) like lower(concat('%', :param1,'%'))")
	List<Fornecedor> findByNome(@Param("param1") String nome);
}
