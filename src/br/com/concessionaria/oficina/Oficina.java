package br.com.concessionaria.oficina;

import java.util.ArrayList;
import java.util.Random;

import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.veiculos.Veiculo;

public class Oficina {

	// Atributos.
	private String nomeOficina;
	private ArrayList<Mecanico> listaMecanicos;
	private ArrayList<Peca> listaPecas;
	private ArrayList<Veiculo> listaVeiculos;
	private int pecasNecessarias;

	// Métodos Construtor.
	public Oficina() {
		super();
		this.listaMecanicos = new ArrayList<Mecanico>();
		this.listaPecas = new ArrayList<Peca>();
		this.listaVeiculos = new ArrayList<Veiculo>();
	}

	public Oficina(String nomeOficina) {
		super();
		this.listaMecanicos = new ArrayList<Mecanico>();
		this.listaPecas = new ArrayList<Peca>();
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.nomeOficina = nomeOficina;
		System.out.println("--> Oficina instância com sucesso.");
	}

	// Métodos Getters e Setters.
	public String getNomeOficina() {
		return this.nomeOficina;
	}

	public void setNomeOficina(String nomeOficina) {
		this.nomeOficina = nomeOficina;
	}

	public ArrayList<Mecanico> getListaMecanicos() {
		return this.listaMecanicos;
	}

	public void setListaMecanicos(ArrayList<Mecanico> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}

	public ArrayList<Peca> getListaPecas() {
		return this.listaPecas;
	}

	public void setListaPecas(ArrayList<Peca> listaPecas) {
		this.listaPecas = listaPecas;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return this.listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public int getPecasNecessarias() {
		return this.pecasNecessarias;
	}

	public void setPecasNecessarias(int pecasNecessarias) {
		this.pecasNecessarias += pecasNecessarias;
	}

	// Outros Médotos.
	public void adicionarMecanico(Mecanico mecanico) {
		this.listaMecanicos.add(mecanico);
		System.out.println("--> Mecânico cadastrado com sucesso.");
	}

	public boolean removerMecanico(Mecanico mecanico) {
		this.listaMecanicos.remove(mecanico);
		System.out.println("--> Mecânico de Nome: " + mecanico.getNome() + ", removido com sucesso.");
		return true;
	}

	public void exibeListaMecanicos() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Opção 11 - Exibir Mecânicos cadastrados por Nome.");
		System.out.println("-------------------------------------------------");

		if (this.getListaMecanicos().size() > 0) {
			for (Mecanico mecanico : this.getListaMecanicos()) {
				System.out.println("|Nome do Mecânico: " + mecanico.getNome() + ".");
			}
		} else {
			System.out.println("--> Não existem Mecânicos cadastrados na Oficina! Verifique.");
		}
	}

	public void adicionarPeca(Peca peca) {
		this.listaPecas.add(peca);
		System.out.println("--> Peça cadastrada com sucesso.");

	}

	public boolean removerPeca(Peca peca) {
		this.listaPecas.remove(peca);
		System.out.println("--> Peça de Nome: " + peca.getNome() + ", removida com sucesso.");
		return true;
	}

	public void exibeListaPecas() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Opção 07 - Exibir Peças cadastradas por Nome.");
		System.out.println("-------------------------------------------------");

		if (this.getListaPecas().size() > 0) {
			for (Peca peca : this.getListaPecas()) {
				System.out.println("|Nome da Peça: " + peca.getNome() + ".");
			}
		} else {
			System.out.println("--> Não existem Peças cadastradas na Oficina! Verifique.");
		}
	}

	public void adicionarVeiculo(Veiculo veiculo) {
		int pecasNecessariasIncluidas = this.verificarPecasRevisao();
		this.listaVeiculos.add(veiculo);
		this.setPecasNecessarias(pecasNecessariasIncluidas);
		System.out.println("--> Veículo cadastrado com sucesso. Quantidade de Peças necessárias: "
				+ pecasNecessariasIncluidas + ".");
	}

	public boolean removerVeiculo(Veiculo veiculo) {
		int pecasNecessariasRemovidas = this.verificarPecasRevisao();
		this.pecasNecessarias -= pecasNecessariasRemovidas;
		this.listaVeiculos.remove(veiculo);
		System.out.println("--> Veículo de Placa: " + veiculo.getPlaca() + ", removido com sucesso.");
		return true;
	}

	public void exibeListaVeiculos() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Opção 03 - Exibir Veículos cadastrados por Placa.");
		System.out.println("-------------------------------------------------");

		if (this.getListaVeiculos().size() > 0) {
			for (Veiculo veiculo : this.getListaVeiculos()) {
				System.out.println("|Placa: " + veiculo.getPlaca() + ".");
			}
		} else {
			System.out.println("--> Não existem Veículos cadastrados na Oficina! Verifique.");
		}
	}

	// Gerando um número aleatório de 1 a 3 de Peças a serem utilizadas.
	public int verificarPecasRevisao() {
		Random numeroRandomico = new Random();
		int numeroDePecasUtilizadas = numeroRandomico.nextInt(3) + 1;
		return numeroDePecasUtilizadas;
	}

	// Informar se é possível realizar as reviões dos veículos.
	public boolean realizarRevisaoVeiculos() {
		boolean podeRevisar = false;
		int quantidadeTotalDeVeiculosNaOficina = this.getListaVeiculos().size();
		int quantidadeTotalDePecasNaOficina = this.getListaPecas().size();
		int quantidadeTotalDePecasNecessarias = this.getPecasNecessarias();
		int quantidadeTotalDeMecanicosNaOficina = this.getListaMecanicos().size();
		int quantidadeTotalDeAtendimentosSimultaneos = 0;
		
		for (Mecanico mecanico : this.getListaMecanicos()) {
			quantidadeTotalDeAtendimentosSimultaneos += mecanico.getCarrosSimultaneos();
		}

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Opção 04 - Verificar revisão dos Veículos cadastrados na Oficina.");
		System.out.println("-------------------------------------------------");

		System.out.println("");
		System.out.println("Quantidade Total de Veiculos na Oficina.....: " + quantidadeTotalDeVeiculosNaOficina + ".");
		System.out.println("Quantidade Total de Peças na Oficina........: " + quantidadeTotalDePecasNaOficina + ".");
		System.out.println("Quantidade Total de Peças necessárias.......: " + quantidadeTotalDePecasNecessarias + ".");
		System.out.println("Quantidade Total de Mecânicos na Oficina....: " + quantidadeTotalDeMecanicosNaOficina + ".");
		System.out.println("Quantidade Total de Atendimentos Simultâneos: " + quantidadeTotalDeAtendimentosSimultaneos + ".");
		System.out.println("");
		
		if (quantidadeTotalDeVeiculosNaOficina > 0) {
			if(quantidadeTotalDeMecanicosNaOficina > 0) {
				if(quantidadeTotalDeAtendimentosSimultaneos >= quantidadeTotalDeVeiculosNaOficina) {
					if (quantidadeTotalDePecasNaOficina >= quantidadeTotalDePecasNecessarias) {
						podeRevisar = true;
					} else {
						System.out.println("--> Não existem Peças suficientes na Oficina.");
						return podeRevisar;
					}
				} else {
					System.out.println("--> Não existem Mecânicos suficientes para o atendimento simultâneo dos Veículos na Oficina.");
					return podeRevisar;
				}
			} else {
				System.out.println("--> Não existem Mecânicos cadastrados na Oficina.");
				return podeRevisar;
			}
		} else {
			System.out.println("--> Não existem Veículos cadastrados na Oficina.");
			return podeRevisar;
		}

		return podeRevisar;
	}

	// Informa os Nomes, Valores e a Soma Total das respectivas Peças da Oficina.
	public float valorTotalPecas() {

		float valorDeCadaPeca = 0;
		float valorDasPecasNaOficina = 0;

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Código 08 - Exibir o Nome, Valor por Peça e Valor Total das Peças.");
		System.out.println("-------------------------------------------------");

		if (this.getListaPecas().size() > 0) {
			int quantidadeTotalDePecasNaOficina = this.getListaPecas().size();
			for (Peca peca : this.getListaPecas()) {
				valorDeCadaPeca = peca.getValor();
				valorDasPecasNaOficina += valorDeCadaPeca;
				System.out.println("");
				System.out.println("Nome da Peça....: " + peca.getNome() + ".");
				System.out.println("Valor da Peça R$: " + peca.getValor() + ".");
			}
			System.out.println("");
			System.out.println("Quantidade Total de Peças é.: " + quantidadeTotalDePecasNaOficina + ".");
			System.out.println("O Valor Total das Peças é...: R$ " + valorDasPecasNaOficina + ".");

		} else {
			System.out.println("--> Não existem Peças cadastradas na Oficina! Verifique.");
		}

		return valorDasPecasNaOficina;

	}

}
