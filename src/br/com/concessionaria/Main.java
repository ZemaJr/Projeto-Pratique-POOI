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

		// Declarando 3 objetos da classe Veículo.
		Veiculo veiculo01 = new Veiculo("ABC0101", 1981, 1, "XYZ01QWESS", "BRANCO    ", 251);
		Veiculo veiculo02 = new Veiculo("DEF0202", 1992, 2, "QWE02RTYAA", "AMARELO   ", 302);
		Veiculo veiculo03 = new Veiculo("GHI0303", 2003, 3, "UIO03PASWW", "PRETO     ", 413);

		// Declaração de 10 objetos da classe Peça.
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

		// Declaração de 3 objetos da classe Mecânico.
		Mecanico mecanico01 = new Mecanico("JOÃO          ", 10, 2);
		Mecanico mecanico02 = new Mecanico("JOSÉ          ", 5, 1);
		Mecanico mecanico03 = new Mecanico("MARIA         ", 20, 3);

		// Adicionando os objetos Veículos na Oficina.
		oficina.adicionarVeiculo(veiculo01);
		oficina.adicionarVeiculo(veiculo02);
		oficina.adicionarVeiculo(veiculo03);

		// Adicionando os objetos Peças na Oficina.
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

		// Adicionando os objetos Mecânicos na Oficina.
		oficina.adicionarMecanico(mecanico01);
		oficina.adicionarMecanico(mecanico02);
		oficina.adicionarMecanico(mecanico03);

		// Exibindo Menú de Transações.
		Scanner scan = new Scanner(System.in);
		int opcao = 0;

		do {

			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("           MENÚ DE TRANSAÇÕES DA OFICINA         ");
			System.out.println("-------------------------------------------------");
			System.out.println("Escolha um Código conforme a opção desejada:");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                   VEÍCULOS                      ");
			System.out.println("-------------------------------------------------");
			System.out.println("Código 01 - Cadastrar um novo Veículo.");
			System.out.println("Código 02 - Remover Veículo por Placa.");
			System.out.println("Código 03 - Exibir Veículos cadastrados por Placa.");
			System.out.println("Código 04 - Verificar revisão dos Veículos cadastrados na Oficina.");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                    PEÇAS                        ");
			System.out.println("-------------------------------------------------");
			System.out.println("Código 05 - Cadastrar uma nova Peça.");
			System.out.println("Código 06 - Remover Peça por Nome.");
			System.out.println("Código 07 - Exibir Peças cadastradas por Nome.");
			System.out.println("Código 08 - Exibir Nome, Valor da Peça e o Valor Total das Peças.");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                   MECÊNICOS                     ");
			System.out.println("-------------------------------------------------");
			System.out.println("Código 09 - Cadastrar um novo Mecânico.");
			System.out.println("Código 10 - Remover Mecânico por Nome.");
			System.out.println("Código 11 - Exibir Mecânicos cadastrados por Nome.");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("                    ENCERRAR                     ");
			System.out.println("-------------------------------------------------");
			System.out.println("Código 00 - Encerrar Programa.");
			System.out.println("-------------------------------------------------");
			System.out.println("Entre com o Código: -> ");

			opcao = scan.nextInt();

			switch (opcao) {
			case 1:

				// Cadastrar um novo Veículo.
				oficina.adicionarVeiculo(cadastrarNovoVeiculo());
				break;

			case 2:

				// Remover Veículo por Placa.
				removerVeiculoPorPlaca(oficina);
				break;

			case 3:

				// Exibindo a relação de Veículos cadastrados.
				oficina.exibeListaVeiculos();
				break;

			case 4:

				// Verificar revisão dos Veículos cadastrados na Oficina.
				// Em caso positivo, informar os dados dos Veículos e Mecânicos.
				boolean resposta = oficina.realizarRevisaoVeiculos();
				if (resposta) {
					System.out.println("--> Sim. É possível realizar a revisão dos Veículos cadastrados na Oficina.");
					
					System.out.println("");
					System.out.println("Dados dos Veículos a serem revisados:");
					System.out.println("-------------------------------------------------");
					for (Veiculo veiculo : oficina.getListaVeiculos()) {
						System.out.println("|Placa: " + veiculo.getPlaca() + " |Ano: " + veiculo.getAno() + " |Modelo: " + veiculo.getModelo() + " |Nº Chassi: " + veiculo.getNumeroChassi() + " |Cor: " + veiculo.getCor() + " |Km Rodados: " + veiculo.getKmRodados() + ".");
					}
					
					System.out.println("");
					System.out.println("Dados dos Mecânicos disponíveis:");
					System.out.println("-------------------------------------------------");
					for (Mecanico mecanico : oficina.getListaMecanicos()) {
						System.out.println("|Nome: " + mecanico.getNome() + " |Anos de Experiência: " + mecanico.getAnosExperiencia() + " anos "+ " |Carros Simultâneos: " + mecanico.getCarrosSimultaneos() + "."); 
					}
					System.out.println("-------------------------------------------------");
				} else {
					System.out.println("--> Não! Não é possível realizar a revisão dos Veículos cadastrados na Oficina.");
				}
				break;

			case 5:

				// Cadastrar uma nova Peça.
				oficina.adicionarPeca(cadastrarPeca());
				break;

			case 6:

				// Remover Peça por Nome.
				removerPecaPorNome(oficina);
				break;

			case 7:

				// Exibindo a relação de Peças cadastradas.
				oficina.exibeListaPecas();
				break;

			case 8:

				// Exibindo as Peças, os Valores e o Somatório Total das Peças.
				oficina.valorTotalPecas();
				break;

			case 9:

				// Cadastrar um novo Mecânico.
				oficina.adicionarMecanico(cadastrarNovoMecanico());
				break;

			case 10:

				// Remover Mecânico pelo Nome.
				removerMecanicoPorNome(oficina);
				break;

			case 11:

				// Exibindo a relação de Mecânicos cadastrados por Nome.
				oficina.exibeListaMecanicos();
				break;

			case 0:

				// Encerra o Programa.
				System.out.println("--> Deseja relamente encerrar o Programa? Confirme abaixo.");
				opcao = 99;
				break;

			default:

				// Informar a opção inválida escolhida.
				System.out.println("--> Opção escolhida inválida! Verifique.");

			}
			
			System.out.println("");
			System.out.println("Opção 99 - Para <Voltar> ao Menú de Transações.");
			System.out.println("Opção 00 - Para <Sair> do Programa.");
			System.out.println("-------------------------------------------------");
			System.out.println("Entre com o Código: -> ");
			
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
		System.out.println("Opção 01 - Cadastrar um novo Veículo.");
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

		System.out.println("Informe o Número do Chassi: ");
		String numeroChassi = scan.next().toUpperCase() + espaco;
		numeroChassi = numeroChassi.substring(0, 10);

		System.out.println("Informe a Cor: ");
		String cor = scan.next().toUpperCase() + espaco;
		cor = cor.substring(0, 10);

		System.out.println("Informe o Kilômetro Rodado: ");
		int kmRodado = scan.nextInt();

		Veiculo veiculo = new Veiculo(placa, ano, modelo, numeroChassi, cor, kmRodado);

		return veiculo;

	}

	public static void removerVeiculoPorPlaca(Oficina oficina) {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Opção 02 - Remover Veículo por Placa.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("Informe a Placa para remoção do Veículo: ");
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
					.println("Placa: " + placa + ", informada não consta na lista de Veículos cadastrada! Verifique.");
		}

	}

	public static Peca cadastrarPeca() {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Opção 05 - Cadastrar uma nova Peça.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Informe os dados da Peça.");
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
		System.out.println("Opção 06 - Remover Peça por Nome.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("Informe um Nome para remoção do Peça: ");
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
					"Peça de Nome: " + nome + ", informada não consta na lista de Peças cadastradas! Verifique.");
		}

	}

	public static Mecanico cadastrarNovoMecanico() {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Opção 09 - Cadastrar um novo Mecânico.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Informe os dados do Mecânico.");
		System.out.println("--------------------------------------------");

		System.out.println("Informe o Nome: ");
		String nome = scan.next().toUpperCase() + espaco;
		nome = nome.substring(0, 14);

		System.out.println("Informe quantos Anos de Experiência: ");
		int anoExperiencia = scan.nextInt();

		System.out.println("Informe a quantida de carros que ele pode atender simultaneamente: ");
		int carrosSimultaneos = scan.nextInt();

		Mecanico mecanico = new Mecanico(nome, anoExperiencia, carrosSimultaneos);

		return mecanico;

	}

	public static void removerMecanicoPorNome(Oficina oficina) {

		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Opção 10 - Remover Mecânico por Nome.");
		System.out.println("--------------------------------------------");

		Scanner scan = new Scanner(System.in);
		String espaco = "          ";

		System.out.println("Informe um Nome para remoção do Mecânico: ");
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
			System.out.println("Mecânico de Nome: " + nome
					+ ", informado não consta na lista de Mecânicos cadastrados! Verifique.");
		}

	}

}
