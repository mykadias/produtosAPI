package br.com.cotiinformatica.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoGetResponse {
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;
	private Double total;
	private Integer idFornecedor;
	private String nomeFornecedor;
	private String cnpjFornecedor;
}
