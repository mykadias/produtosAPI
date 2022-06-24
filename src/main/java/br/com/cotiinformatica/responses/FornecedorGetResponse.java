package br.com.cotiinformatica.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedorGetResponse {
	
	private Integer idFornecedor;
	private String nome;
	private String cnpj;
}
