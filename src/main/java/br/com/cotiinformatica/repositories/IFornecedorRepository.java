package br.com.cotiinformatica.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cotiinformatica.entities.Fornecedor;

public interface IFornecedorRepository extends CrudRepository<Fornecedor, Integer> {

}
