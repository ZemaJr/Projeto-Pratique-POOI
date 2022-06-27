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

	// M�todos Construtor.
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
		System.out.println("--> Oficina inst�ncia com sucesso.");
	}

	// M�todos Getters e Setters.
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

	// Outros M�dotos.
	public void adicionarMecanico(Mecanico mecanico) {
		this.listaMecanicos.add(mecanico);
		System.out.println("--> Mec�nico cadastrado com sucesso.");
	}

	public boolean removerMecanico(Mecanico mecanico) {
		this.listaMecanicos.remove(mecanico);
		System.out.println("--> Mec�nico de Nome: " + mecanico.getNome() + ", removido com sucesso.");
		return true;
	}

	public void exibeListaMecanicos() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Op��o 11 - Exibir Mec�nicos cadastrados por Nome.");
		System.out.println("-------------------------------------------------");

		if (this.getListaMecanicos().size() > 0) {
			for (Mecanico mecanico : this.getListaMecanicos()) {
				System.out.println("|Nome do Mec�nico: " + mecanico.getNome() + ".");
			}
		} else {
			System.out.println("--> N�o existem Mec�nicos cadastrados na Oficina! Verifique.");
		}
	}

	public void adicionarPeca(Peca peca) {
		this.listaPecas.add(peca);
		System.out.println("--> Pe�a cadastrada com sucesso.");

	}

	public boolean removerPeca(Peca peca) {
		this.listaPecas.remove(peca);
		System.out.println("--> Pe�a de Nome: " + peca.getNome() + ", removida com sucesso.");
		return true;
	}

	public void exibeListaPecas() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Op��o 07 - Exibir Pe�as cadastradas por Nome.");
		System.out.println("-------------------------------------------------");

		if (this.getListaPecas().size() > 0) {
			for (Peca peca : this.getListaPecas()) {
				System.out.println("|Nome da Pe�a: " + peca.getNome() + ".");
			}
		} else {
			System.out.println("--> N�o existem Pe�as cadastradas na Oficina! Verifique.");
		}
	}

	public void adicionarVeiculo(Veiculo veiculo) {
		int pecasNecessariasIncluidas = this.verificarPecasRevisao();
		this.listaVeiculos.add(veiculo);
		this.setPecasNecessarias(pecasNecessariasIncluidas);
		System.out.println("--> Ve�culo cadastrado com sucesso. Quantidade de Pe�as necess�rias: "
				+ pecasNecessariasIncluidas + ".");
	}

	public boolean removerVeiculo(Veiculo veiculo) {
		int pecasNecessariasRemovidas = this.verificarPecasRevisao();
		this.pecasNecessarias -= pecasNecessariasRemovidas;
		this.listaVeiculos.remove(veiculo);
		System.out.println("--> Ve�culo de Placa: " + veiculo.getPlaca() + ", removido com sucesso.");
		return true;
	}

	public void exibeListaVeiculos() {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Op��o 03 - Exibir Ve�culos cadastrados por Placa.");
		System.out.println("-------------------------------------------------");

		if (this.getListaVeiculos().size() > 0) {
			for (Veiculo veiculo : this.getListaVeiculos()) {
				System.out.println("|Placa: " + veiculo.getPlaca() + ".");
			}
		} else {
			System.out.println("--> N�o existem Ve�culos cadastrados na Oficina! Verifique.");
		}
	}

	// Gerando um n�mero aleat�rio de 1 a 3 de Pe�as a serem utilizadas.
	public int verificarPecasRevisao() {
		Random numeroRandomico = new Random();
		int numeroDePecasUtilizadas = numeroRandomico.nextInt(3) + 1;
		return numeroDePecasUtilizadas;
	}

	// Informar se � poss�vel realizar as revi�es dos ve�culos.
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
		System.out.println("Op��o 04 - Verificar revis�o dos Ve�culos cadastrados na Oficina.");
		System.out.println("-------------------------------------------------");

		System.out.println("");
		System.out.println("Quantidade Total de Veiculos na Oficina.....: " + quantidadeTotalDeVeiculosNaOficina + ".");
		System.out.println("Quantidade Total de Pe�as na Oficina........: " + quantidadeTotalDePecasNaOficina + ".");
		System.out.println("Quantidade Total de Pe�as necess�rias.......: " + quantidadeTotalDePecasNecessarias + ".");
		System.out.println("Quantidade Total de Mec�nicos na Oficina....: " + quantidadeTotalDeMecanicosNaOficina + ".");
		System.out.println("Quantidade Total de Atendimentos Simult�neos: " + quantidadeTotalDeAtendimentosSimultaneos + ".");
		System.out.println("");
		
		if (quantidadeTotalDeVeiculosNaOficina > 0) {
			if(quantidadeTotalDeMecanicosNaOficina > 0) {
				if(quantidadeTotalDeAtendimentosSimultaneos >= quantidadeTotalDeVeiculosNaOficina) {
					if (quantidadeTotalDePecasNaOficina >= quantidadeTotalDePecasNecessarias) {
						podeRevisar = true;
					} else {
						System.out.println("--> N�o existem Pe�as suficientes na Oficina.");
						return podeRevisar;
					}
				} else {
					System.out.println("--> N�o existem Mec�nicos suficientes para o atendimento simult�neo dos Ve�culos na Oficina.");
					return podeRevisar;
				}
			} else {
				System.out.println("--> N�o existem Mec�nicos cadastrados na Oficina.");
				return podeRevisar;
			}
		} else {
			System.out.println("--> N�o existem Ve�culos cadastrados na Oficina.");
			return podeRevisar;
		}

		return podeRevisar;
	}

	// Informa os Nomes, Valores e a Soma Total das respectivas Pe�as da Oficina.
	public float valorTotalPecas() {

		float valorDeCadaPeca = 0;
		float valorDasPecasNaOficina = 0;

		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("C�digo 08 - Exibir o Nome, Valor por Pe�a e Valor Total das Pe�as.");
		System.out.println("-------------------------------------------------");

		if (this.getListaPecas().size() > 0) {
			int quantidadeTotalDePecasNaOficina = this.getListaPecas().size();
			for (Peca peca : this.getListaPecas()) {
				valorDeCadaPeca = peca.getValor();
				valorDasPecasNaOficina += valorDeCadaPeca;
				System.out.println("");
				System.out.println("Nome da Pe�a....: " + peca.getNome() + ".");
				System.out.println("Valor da Pe�a R$: " + peca.getValor() + ".");
			}
			System.out.println("");
			System.out.println("Quantidade Total de Pe�as �.: " + quantidadeTotalDePecasNaOficina + ".");
			System.out.println("O Valor Total das Pe�as �...: R$ " + valorDasPecasNaOficina + ".");

		} else {
			System.out.println("--> N�o existem Pe�as cadastradas na Oficina! Verifique.");
		}

		return valorDasPecasNaOficina;

	}

}
