package otica.utilizador.apoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import avioes.apoo.app.Aeronave;
import avioes.apoo.app.Passageiros;
import avioes.apoo.app.Tripulacao;
import avioes.apoo.app.Voo;

public class Aplicacao {

	public static String companhia;

	Scanner ler = new Scanner(System.in);

	ArrayList<Tripulacao> tripulacao = new ArrayList<>();
	ArrayList<Passageiros> passageiros = new ArrayList<>();
	ArrayList<Voo> voos = new ArrayList<>();
	ArrayList<Aeronave> aeronave = new ArrayList<>();

	public void Iniciar() {
		LerFicheiros();

		System.out.println("Bem vindo a aplicação para companhia aérea");
		LerCompanhiaAerea();
		MenuPrincipal();

	}

	public void LerCompanhiaAerea() {
		System.out.println("Qual a companhia aérea?");

		companhia = ler.next();

	}

	public void MenuPrincipal() {

		int opcao;

		do {

			System.out.println("");
			System.out.println("## Menu principal ##");
			System.out.println("Companhia selecionada: " + companhia);
			System.out.println("Selecione uma opção");

			System.out.println("1 - Voo");
			System.out.println("2 - Passageiro");
			System.out.println("3 - Tripulação");
			System.out.println("4 - Fechar");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1:
				ApresentarMenuVoo();
				break;

			case 2:
				ApresentarMenuPassageiro();
				break;

			case 3:
				ApresentarMenuTripulação();
				break;

			case 4:
				String resposta;
				System.out.println("Tens a certeza que pretende gravar?");
				resposta = ler.next();

				if (resposta == "sim") {
					GravarFicheiros();

				}
				break;

			default:
				System.out.println("Opção Inválida");
				break;

			}
		} while (opcao != 4);
	}

	public void ApresentarMenuVoo() {

		int opcao;

		do {

			System.out.println("1 - Listar voos");
			System.out.println("2 - Editar voos");
			System.out.println("3 - Adicionar voos");
			System.out.println("4 - Eliminar voos");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				MenuVoo2();
				break;
			case 2:
				MenuEditarVoos();
				break;
			case 3:
				AdicionarVoos();
				break;
			case 4:
				EliminarVoos();
				break;

			}
		} while (opcao != 5);

	}

	private void MenuVoo2() {

		int opcao;

		do {
			System.out.println("1 - Listar por datas");
			System.out.println("2 - Listar todos os voos");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1: // funcao para listar por datas
				break;
			case 2:
				ListarVoos();
				break;
			}

		} while (opcao != 2);
	}

	public void ApresentarMenuPassageiro() {
		int opcao;

		do {
			System.out.println("1 - Listar passageiros");
			System.out.println("2 - Editar passageiros");
			System.out.println("3 - Adicionar passageiros");
			System.out.println("4 - Eliminar passageiros");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1:
				MenuListaPassageiros2();
				break;
			case 2: // função para editar passageiros
				break;
			case 3: // função para adicionar passageiros
				break;
			case 4: // função para eliminar passageiros
				break;
			}
		} while (opcao != 4);
	}

	private void MenuListaPassageiros2() {

		int opcao;

		do {
			System.out.println("1 - Listar passageiros por voo");
			System.out.println("2 - Listar todos os passageiros");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1: // funcao para listar por datas
				break;
			case 2: // funcao para listar todos os voos
				break;

			}

		} while (opcao != 2);
	}

	public void ApresentarMenuTripulação() {
		int opcao;

		do {
			System.out.println("1 - Listar pessoal cabine");
			System.out.println("2 - Editar pessoal cabine");
			System.out.println("3 - Adicionar pessoal cabine");
			System.out.println("4 - Eliminar pessoal cabine");

			System.out.println("5 - Listar pilotos");
			System.out.println("6 - Editar pilotos");
			System.out.println("7 - Adicionar pilotos");
			System.out.println("8 - Eliminar pilotos");
			System.out.println("9 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1: // função para listar cabine
				break;
			case 2: // função para editar cabine
				break;
			case 3: // função para adicionar cabine
				break;
			case 4: // função para eliminar cabine
				break;
			case 5: // função para listar pilotos
				break;
			case 6: // função para editar pilotos
				break;
			case 7: // função para adicionar pilotos
				break;
			case 8: // função para eliminar pilotos
				break;
			}
		} while (opcao != 8);
	}

	public void AdicionarVoos() {
		
		Voo voo = new Voo();

		System.out.println("Insira o número do voo: ");
		voo.setnVoo(ler.next());

		System.out.println("Insira o nome do avião: ");
		voo.setAviao(ler.next());

		System.out.println("Insira o aeroporto de origem: ");
		voo.setAeroOrigem(ler.next());

		System.out.println("Insira o aeroporto de destino: ");
		voo.setAeroDestino(ler.next());

		System.out.println("Insira a data de partida: ");
		voo.setDataDePartida(ler.next());

		System.out.println("Insira a data de chegada: ");
		voo.setDataDeChegada(ler.next());

		System.out.println("Insira a hora de partida: ");
		voo.setHoraDePartida(ler.next());

		System.out.println("Insira a hora de chegada: ");
		voo.setHoraDeChegada(ler.next());

		this.voos.add(voo);

		System.out.println("Voo adicionado com sucesso!");
		
		GravarFicheiros();

	}

	public void ListarVoos() {
		
		if (voos.isEmpty()) {
			System.out.println("Não existem voos registrados!");
		} else {
			for (Voo voo : voos) {
				System.out.println(voo);
			}

			ApresentarMenuVoo();
		}

	}

	public void LerFicheiros() {

		// Agora vou abrir os Reader
		try {
			FileReader fr = new FileReader("C:\\Users\\asaph\\Desktop\\Aero\\Teste.txt");
			BufferedReader ler = new BufferedReader(fr);
			// Ler o texto q foi escrito usando o BufferedReader
			String linha;

			while (ler.ready()) {
				linha = ler.readLine();
				String[] partes = linha.split("\\|");

				String nVoo = partes[0];
				String Aviao = partes[1];
				String AeroOrigem = partes[2];
				String AeroDestino = partes[3];
				String DataDePartida = partes[4];
				String DataDeChegada = partes[5];
				String HoraDePartida = partes[6];
				String HoraDeChegada = partes[7];

				Voo voo = new Voo(nVoo, Aviao, AeroOrigem, AeroDestino, DataDePartida, DataDeChegada, HoraDePartida,
						HoraDeChegada);
				voos.add(voo);

			}

			ler.close();

		} catch (IOException Ex) {
			System.out.println(Ex.getMessage());
		}
	}

	public void MenuEditarVoos() {

		System.out.println("Selecione uma opção");
		System.out.println("1 - Editar voo completo:");
		System.out.println("2 - Editar número do voo:");
		System.out.println("3 - Editar nome do avião:");
		System.out.println("4 - Editar aeroporto de origem:");
		System.out.println("5 - Editar aeroporto de destino:");
		System.out.println("6 - Editar data de chegada:");
		System.out.println("7 - Editar data de partida:");
		System.out.println("8 - Editar hora de chegada :");
		System.out.println("9 - Editar hora de partida:");
		System.out.println("10 - Menu anterior:");

		switch (ler.nextInt()) {

		case 1:
			EditarVoosCompleto();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;

		default:
			System.out.println("Opção Inválida");
			MenuEditarVoos();

		}
	}

	public void EditarVoosCompleto() {

		Voo editarVoo = new Voo();
		String numeroVoo;

		System.out.println("Insira o número do voo:");
		numeroVoo = ler.next();

		for (Voo voo : voos) {
			if (numeroVoo.equals(voo.getnVoo())) {
				editarVoo = voo;
			} else {
				System.out.println("Voo não encontrado!");

				MenuEditarVoos();
			}
		}

		System.out.println("Insira o novo número do voo:");
		editarVoo.setnVoo(ler.next());

		System.out.println("Insira o novo número do avião:");
		editarVoo.setAviao(ler.next());

		System.out.println("Insira o novo aeroporto de origem:");
		editarVoo.setAeroOrigem(ler.next());

		System.out.println("Insira o novo aeroporto de destino:");
		editarVoo.setAeroDestino(ler.next());

		System.out.println("Insira a nova data de partida:");
		editarVoo.setDataDePartida(ler.next());

		System.out.println("Insira a nova data de chegada:");
		editarVoo.setDataDeChegada(ler.next());

		System.out.println("Insira a nova hora de partida:");
		editarVoo.setHoraDePartida(ler.next());

		System.out.println("Insira a nova hora de chegada:");
		editarVoo.setHoraDeChegada(ler.next());

		ApresentarMenuVoo();
	}

	public void EliminarVoos() {

		Voo eliminarVoo = null;
		String numVoo;

		System.out.println("Insira o número do voo que quer eliminar:");
		numVoo = ler.next();

		for (Voo voo : voos) {
			if (numVoo.equals(voo.getnVoo())) {
				eliminarVoo = voo;
				break;
			}
		}
		if (eliminarVoo != null) {
			voos.remove(eliminarVoo);

			System.out.println("Voo eliminado com sucesso!");
		}
	}

	public void GravarFicheiros() {
		
		String resposta;

		System.out.println("Queres salvar as altereções (S/N)?");
		resposta = ler.next();

		if (resposta.equals("S") || resposta.equals("s")) {

			try {
				// Abrir o FileWriter, Buffered Writer
				FileWriter fw = new FileWriter("C:\\Users\\asaph\\Desktop\\Aero\\Teste.txt");
				BufferedWriter caneta = new BufferedWriter(fw);
				String linha = "";

				if (voos.isEmpty()) {
					caneta.write("");
					caneta.close();
				} else {
					
					for (Voo voo : voos) {
						linha += voo.getnVoo() + "|";
						linha += voo.getAviao() + "|";
						linha += voo.getAeroOrigem() + "|";
						linha += voo.getAeroDestino() + "|";
						linha += voo.getDataDePartida() + "|";
						linha += voo.getDataDeChegada() + "|";
						linha += voo.getHoraDePartida() + "|";
						linha += voo.getHoraDeChegada() + "|\n";
						caneta.write(linha);
					}
					
					
					
					
					caneta.close();
				}

			} catch (IOException Ex) {
				{
					System.out.println(Ex.getMessage());
				}

			}
		}

	}
}
