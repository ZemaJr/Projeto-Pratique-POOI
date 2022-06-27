package br.com.concessionaria.estrutura;

public class Peca {

	// Atributos.
	private String nome;
	private float valor;
	private String dataCompra;

	// Método Construtor.
	public Peca(String nome, float valor, String dataCompra) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.dataCompra = dataCompra;
	}

	// Métodos Getters e Setters.
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

}
