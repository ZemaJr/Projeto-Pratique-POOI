package br.com.concessionaria;

import java.util.Scanner;

import br.com.concessionaria.oficina.Oficina;
import br.com.concessionaria.veiculos.Veiculo;
import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;

public class Main {

	public static void main(String[] args) {

		// Instanciando a Oficina.
		Oficina oficina = new Oficina("Oficina");

		// Declarando 3 objetos da classe Ve�culo.
		Veiculo veiculo01 = new Veiculo("ABC0101", 1981, 1, "XYZ01QWESS", "BRANCO    ", 251);
		Veiculo veiculo02 = new Veiculo("DEF0202", 1992, 2, "QWE02RTYAA", "AMARELO   ", 302);
		Veiculo veiculo03 = new Veiculo("GHI0303", 2003, 3, "UIO03PASWW", "PRETO     ", 413);

		// Declara��o de 10 objetos da classe Pe�a.
		Peca peca01 = new Peca("PNEU      ", 400, "01/01/1900");
		Peca peca02 = new Peca("ESPELHO   ", 1000, "02/02/1910");
		Peca peca03 = new Peca("FAROL     ", 200, "03/03/1920");
		Peca peca04 = new Peca("PARABRISA ", 2500, "04/04/1930");
		Peca peca05 = new Peca("BANCO     ", 1000, "05/05/1940");
		Peca peca06 = new Peca("PORTA     ", 900, "06/06/1950");
		Peca peca07 = new Peca("MOTOR     ", 12000, "07/07/1960");
		Peca peca08 = new Peca("ARO       ", 500, "08/08/1980");
		Peca peca09 = new Peca("PEDAL     ", 100, "09/09/1990");
		Peca peca10 = new Peca("VOLANTE   ", 300, "10/10/2000");

		// Declara��o de 3 objetos da classe Mec�nico.
		Mecanico mecanico01 = new Mecanico("JO�O          ", 10, 2);
		Mecanico mecanico02 = new Mecanico("JOS�          ", 5, 1);
		Mecanico mecanico03 = new Mecanico("MARIA         ", 20, 3);

		// Adicionando os objetos Ve�culos na Oficina.
		oficina.adicionarVeiculo(veiculo01);
		oficina.adicionarVeiculo(veiculo02);
		oficina.adicionarVeiculo(veiculo03);

		// Adicionando os objetos Pe�as na Oficina.
		oficina.adicionarPeca(peca01);
		oficina.adicionarPeca(peca02);
		oficina.adicionarPeca(peca03);
		oficina.adicionarPeca(peca04);
		oficina.adicionarPeca(peca05);
		oficina.adicionarPeca(peca06);
		oficina.adicionarPeca(peca07);
		oficina.adicionarPeca(peca08);
		oficina.adicionarPeca(peca09);
		oficina.adicionarPeca(peca10);

		// Adicionando os objetos Mec�nicos na Oficina.
		oficina.adicionarMecanico(mecanico01);
		oficina.adicionarMecanico(mecanico02);
		oficina.adicionarMecanico(mecanico03);

		// Exibindo Men� de Transa��es.
		Scanner scan = new Scanner(System.in);
		int opcao = 0;

		do {

			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("           MEN� DE TRANSA��ES DA OFICINA         ");
			System.out.println("-------------------------------------------------");
			System.out.println("Escolha um C�digo conforme a op��o desejada:");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                   VE�CULOS                      ");
			System.out.println("-------------------------------------------------");
			System.out.println("C�digo 01 - Cadastrar um novo Ve�culo.");
			System.out.println("C�digo 02 - Remover Ve�culo por Placa.");
			System.out.println("C�digo 03 - Exibir Ve�culos cadastrados por Placa.");
			System.out.println("C�digo 04 - Verificar revis�o dos Ve�culos cadastrados na Oficina.");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                    PE�AS                        ");
			System.out.println("-------------------------------------------------");
			System.out.println("C�digo 05 - Cadastrar uma nova Pe�a.");
			System.out.println("C�digo 06 - Remover Pe�a por Nome.");
			System.out.println("C�digo 07 - Exibir Pe�as cadastradas por Nome.");
			System.out.println("C�digo 08 - Exibir Nome, Valor da Pe�a e o Valor Total das Pe�as.");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                   MEC�NICOS                     ");
			System.out.println("-------------------------------------------------");
			System.out.println("C�digo 09 - Cadastrar um novo Mec�nico.");
			System.out.println("C�digo 10 - Remover Mec�nico por Nome.");
			System.out.println("C�digo 11 - Exibir Mec�nicos cadastrados por Nome.");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                    ENCERRAR                     ");
			System.out.println("-------------------------------------------------");
			System.out.println("C�digo 00 - Encerrar Programa.");
			System.out.println("-------------------------------------------------");
			System.out.println("Entre com o C�digo: -> ");

			opcao = scan.nextInt();

			switch (opcao) {
			case 1:

				// Cadastrar um novo Ve�culo.
				oficina.adicionarVeiculo(cadastrarNovoVeiculo());
				break;

			case 2:

				// Remover Ve�culo por Placa.
				removerVeiculoPorPlaca(oficina);
				break;

			case 3:

				// Exibindo a rela��o de Ve�culos cadastrados.
				oficina.exibeListaVeiculos();
				break;

			case 4:

				// Verificar revis�o dos Ve�culos cadastrados na Oficina.
				// Em caso positivo, informar os dados dos Ve�culos e Mec�nicos.
				boolean resposta = oficina.realizarRevisaoVeiculos();
				if (resposta) {
					System.out.println("--> Sim. � poss�vel realizar a revis�o dos Ve�culos cadastrados na Oficina.");
					
					System.out.println("");
					System.out.println("Dados dos Ve�culos a serem revisados:");
					System.out.println("-------------------------------------------------");
					for (Veiculo veiculo : oficina.getListaVeiculos()) {
						System.out.println("|Placa: " + veiculo.getPlaca() + " |Ano: " + veiculo.getAno() + " |Modelo: " + veiculo.getModelo() + " |N� Chassi: " + veiculo.getNumeroChassi() + " |Cor: " + veiculo.getCor() + " |Km Rodados: " + veiculo.getKmRodados() + ".");
					}
					
					System.out.println("");
					System.out.println("Dados dos Mec�nicos dispon�veis:");
					System.out.println("-------------------------------------------------");
					for (Mecanico mecanico : oficina.getListaMecanicos()) {
						System.out.println("|Nome: " + mecanico.getNome() + " |Anos de Experi�ncia: " + mecanico.getAnosExperiencia() + " anos "+ " |Carros Simult�neos: " + mecanico.getCarrosSimultaneos() + "."); 
					}
					System.out.println("-------------------------------------------------");
				} else {
					System.out.println("--> N�o! N�o � poss�vel realizar a revis�o dos Ve�culos cadastrados na Oficina.");
				}
				break;

			case 5:

				// Cadastrar uma nova Pe�a.
				oficina.adicionarPeca(cadastrarPeca());
				break;

			case 6:

				// Remover Pe�a por Nome.
				removerPecaPorNome(oficina);
				break;

			case 7:

				// Exibindo a rela��o de Pe�as cadastradas.
				oficina.exibeListaPecas();
				break;

			case 8:

				// Exibindo as Pe�as, os Valores e o Somat�rio Total das Pe�as.
				oficina.valorTotalPecas();
				break;

			case 9:

				// Cadastrar um novo Mec�nico.
				oficina.adicionarMecanico(cadastrarNovoMecanico());
				break;

			case 10:

				// Remover Mec�nico pelo Nome.
				removerMecanicoPorNome(oficina);
				break;

			case 11:

				// Exibindo a rela��o de Mec�nicos cadastrados por Nome.
				oficina.exibeListaMecanicos();
				break;

			case 0:

				// Encerra o Programa.
				System.out.println("--> Deseja relamente encerrar o Programa? Confirme abaixo.");
				opcao = 99;
				break;

			default:

				// Informar a op��o inv�lida escolhida.
				System.out.println("--> Op��o escolhida inv�lida! Verifique.");

			}
			
			System.out.println("");
			System.out.println("Op��o 99 - Para <Voltar> ao Men� de Transa��es.");
			System.out.println("Op��o 00 - Para <Sair> do Programa.");
			System.out.println("-------------------------------------------------");
			System.out.println("Entre com o C�digo: -> ");
			
			int resposta = scan.nextInt();
			if(resposta <= 0) {
				System.out.println("--> Programa encerrado!");
				break;
			}

		} while (opcao != 0);

		scan.close();

	}

	public static Veiculo cadastrarNovoVeiculo() {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Op��o 01 - Cadastrar um novo Ve�culo.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Informe os dados do Veiculo.");
		System.out.println("--------------------------------------------");

		System.out.println("Informe a Placa: ");
		String placa = scan.next().toUpperCase() + espaco;
		placa = placa.substring(0, 7);

		System.out.println("Informe o Ano: ");
		int ano = scan.nextInt();

		System.out.println("Informe o Modelo: ");
		int modelo = scan.nextInt();

		System.out.println("Informe o N�mero do Chassi: ");
		String numeroChassi = scan.next().toUpperCase() + espaco;
		numeroChassi = numeroChassi.substring(0, 10);

		System.out.println("Informe a Cor: ");
		String cor = scan.next().toUpperCase() + espaco;
		cor = cor.substring(0, 10);

		System.out.println("Informe o Kil�metro Rodado: ");
		int kmRodado = scan.nextInt();

		Veiculo veiculo = new Veiculo(placa, ano, modelo, numeroChassi, cor, kmRodado);

		return veiculo;

	}

	public static void removerVeiculoPorPlaca(Oficina oficina) {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Op��o 02 - Remover Ve�culo por Placa.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("Informe a Placa para remo��o do Ve�culo: ");
		String placa = scan.next().toUpperCase() + espaco;
		placa = placa.substring(0, 7);
		
		boolean resposta = false;

		for (Veiculo veiculo : oficina.getListaVeiculos()) {

			if (placa.equals(veiculo.getPlaca())) {
				resposta = oficina.removerVeiculo(veiculo);
				break;
			}

		}

		if (!resposta) {
			System.out
					.println("Placa: " + placa + ", informada n�o consta na lista de Ve�culos cadastrada! Verifique.");
		}

	}

	public static Peca cadastrarPeca() {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Op��o 05 - Cadastrar uma nova Pe�a.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Informe os dados da Pe�a.");
		System.out.println("--------------------------------------------");

		System.out.println("Informe o Nome: ");
		String nome = scan.next().toUpperCase() + espaco;
		nome = nome.substring(0, 10);

		System.out.println("Informe o Valor: ");
		float valor = scan.nextFloat();

		System.out.println("Informe a Data da Compra: ");
		String dataCompra = scan.next().toUpperCase() + espaco;
		dataCompra = dataCompra.substring(0, 10);

		Peca peca = new Peca(nome, valor, dataCompra);

		return peca;

	}

	public static void removerPecaPorNome(Oficina oficina) {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Op��o 06 - Remover Pe�a por Nome.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("Informe um Nome para remo��o do Pe�a: ");
		String nome = scan.next().toUpperCase() + espaco;
		nome = nome.substring(0, 10);
		
		boolean resposta = false;

		for (Peca peca : oficina.getListaPecas()) {

			if (nome.equals(peca.getNome())) {
				resposta = oficina.removerPeca(peca);
				break;
			}

		}

		if (!resposta) {
			System.out.println(
					"Pe�a de Nome: " + nome + ", informada n�o consta na lista de Pe�as cadastradas! Verifique.");
		}

	}

	public static Mecanico cadastrarNovoMecanico() {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Op��o 09 - Cadastrar um novo Mec�nico.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Informe os dados do Mec�nico.");
		System.out.println("--------------------------------------------");

		System.out.println("Informe o Nome: ");
		String nome = scan.next().toUpperCase() + espaco;
		nome = nome.substring(0, 14);

		System.out.println("Informe quantos Anos de Experi�ncia: ");
		int anoExperiencia = scan.nextInt();

		System.out.println("Informe a quantida de carros que ele pode atender simultaneamente: ");
		int carrosSimultaneos = scan.nextInt();

		Mecanico mecanico = new Mecanico(nome, anoExperiencia, carrosSimultaneos);

		return mecanico;

	}

	public static void removerMecanicoPorNome(Oficina oficina) {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Op��o 10 - Remover Mec�nico por Nome.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("Informe um Nome para remo��o do Mec�nico: ");
		String nome = scan.next().toUpperCase() + espaco;
		nome = nome.substring(0, 14);
		
		boolean resposta = false;

		for (Mecanico mecanico : oficina.getListaMecanicos()) {

			if (nome.equals(mecanico.getNome())) {
				resposta = oficina.removerMecanico(mecanico);
				break;
			}

		}

		if (!resposta) {
			System.out.println("Mec�nico de Nome: " + nome
					+ ", informado n�o consta na lista de Mec�nicos cadastrados! Verifique.");
		}

	}

}
