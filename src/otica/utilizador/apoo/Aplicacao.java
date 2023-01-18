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
		LerFicheirosVoos();
		LerFicheirosPassageiros();

		System.out.println("Bem vindo a aplicação para companhia aérea");
		LerCompanhiaAerea();
		MenuPrincipal();

	}

	public void LerCompanhiaAerea() {
		System.out.println("Qual a companhia aérea?");

		companhia = ler.next();

	}

	/*
	 * 
	 * CONTROLO DE MENUS
	 * 
	 */

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
				GravarFicheirosVoos();
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
			case 5:
				MenuPrincipal();

			default:
				System.out.println("Opcão inválida!");
				break;

			}
		} while (opcao != 5);

	}

	private void MenuVoo2() {

		int opcao;

		do {
			System.out.println("1 - Listar por datas");
			System.out.println("2 - Listar todos os voos");
			System.out.println("3 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1: // funcao para listar por datas
				break;
			case 2:
				ListarVoos();
				break;
			case 3:
				ApresentarMenuVoo();
				break;
			}

		} while (opcao != 3);
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
			case 2:
				EditarPassageiroCompleto();
				break;
			case 3:
				AdicionarPassageiros();
				break;
			case 4:
				EliminarPassageiros();
				break;
			case 5:
				MenuPrincipal();
				break;
			}
		} while (opcao != 5);
	}

	private void MenuListaPassageiros2() {

		int opcao;

		do {
			System.out.println("1 - Listar passageiros por voo");
			System.out.println("2 - Listar todos os passageiros");
			System.out.println("3 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1: // funcao para listar por datas
				break;
			case 2:
				ListarTodosOsPassageiros();
				break;
			case 3:
				ApresentarMenuPassageiro();
				break;

			}

		} while (opcao != 3);
	}

	public void ApresentarMenuTripulação() {
		int opcao;

		do {
			System.out.println("1 - Listar pessoal cabine");
			System.out.println("2 - Editar pessoal cabine");
			System.out.println("3 - Adicionar pessoal cabine");
			System.out.println("4 - Eliminar pessoal cabine");

			System.out.println("---------------------------------------");

			System.out.println("5 - Listar pilotos");
			System.out.println("6 - Editar pilotos");
			System.out.println("7 - Adicionar pilotos");
			System.out.println("8 - Eliminar pilotos");
			System.out.println("9 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1:
				ListarPessoalCabine();
				break;
			case 2: // função para editar cabine
				break;
			case 3:
				AdicionarPessoalCabine();
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
			case 9:
				MenuPrincipal();
				break;
			default:
				System.out.println("Opcão inválida");
			}
		} while (opcao != 9);
	}

	public void MenuEditarVoos() {

		int opcao;

		do {
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

			opcao = ler.nextInt();

			switch (opcao) {

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
			case 10:ApresentarMenuVoo();
				break;
			default:
				System.out.println("Opção Inválida");

			}
		} while (opcao != 10);
	}

	/*
	 * 
	 * CONTROLO DE FUNÇÕES
	 * 
	 */

	private void AdicionarPassageiros() {

		Passageiros passageiro = new Passageiros();

		System.out.println("Identidade do passageiro:");
		passageiro.setId(ler.next());

		System.out.println("Nome do passageiro:");
		passageiro.setNome(ler.next());

		System.out.println("Nacionalidade:");
		passageiro.setNacionalidade(ler.next());

		System.out.println("Morada:");
		passageiro.setMorada(ler.next());

		System.out.println("Telefone:");
		passageiro.setTelefone(ler.nextInt());

		System.out.println("Data de nascimento:");
		passageiro.setDataDeNascimento(ler.next());

		System.out.println("E-mail:");
		passageiro.setEmail(ler.next());

		System.out.println("Tipo do bilhete:");
		passageiro.setTipoBilhete(ler.next());

		System.out.println("Lugar reservado");
		passageiro.setLugarReservado(ler.next());

		this.passageiros.add(passageiro);

		System.out.println("Passageiro adicionado com sucesso!");
		System.out.println("");

		GravarFicheirosPass();

	}

	private void EliminarPassageiros() {

		Passageiros eliminarPassageiro = null;
		String idPassageiro;

		System.out.println("Insira o número da identidade do passageiro que queres eliminar:");
		idPassageiro = ler.next();

		for (Passageiros passageiros : passageiros) {
			if (idPassageiro.equals(passageiros.getId())) {
				eliminarPassageiro = passageiros;
				break;
			}
		}
		if (eliminarPassageiro != null) {
			passageiros.remove(eliminarPassageiro);

			System.out.println("Passageiro eliminado com sucesso!");
		}
	}

	public void EditarPassageiroCompleto() {

		Passageiros editarPassageiro = new Passageiros();
		String idPass;

		System.out.println("Insira o número de identidade do passageiro:");
		idPass = ler.next();

		for (Passageiros passageiros : passageiros) {
			if (idPass.equals(passageiros.getId())) {
				editarPassageiro = passageiros;
				
				System.out.println("Insira o novo número de identidade do passageiro:");
				editarPassageiro.setId(ler.next());

				System.out.println("Insira o novo nome do passageiro:");
				editarPassageiro.setNome(ler.next());

				System.out.println("Insira a nova nacionalidade:");
				editarPassageiro.setNacionalidade(ler.next());

				System.out.println("Insira a nova morada:");
				editarPassageiro.setMorada(ler.next());

				System.out.println("Insira o novo telefone:");
				editarPassageiro.setTelefone(ler.nextInt());

				System.out.println("Insira a nova data de nascimento:");
				editarPassageiro.setDataDeNascimento(ler.next());

				System.out.println("Insira o novo e-mail:");
				editarPassageiro.setEmail(ler.next());

				System.out.println("Insira o novo tipo de bilhete:");
				editarPassageiro.setTipoBilhete(ler.next());

				System.out.println("Insira o novo lugar reservado:");
				editarPassageiro.setLugarReservado(ler.next());

			} else {
				System.out.println("Passageiro não encontrado!");

				ApresentarMenuPassageiro();
			}
		}

		ApresentarMenuVoo();

	}

	private void ListarTodosOsPassageiros() {

		if (passageiros.isEmpty()) {
			System.out.println("Não existem passageiros registrados!");
		} else {
			for (Passageiros passageiros : passageiros) {
				System.out.println(passageiros);
			}

			ApresentarMenuPassageiro();
		}

	}

	/*
	 * 
	 * CONTROLO DE PESSOAL CABINE
	 * 
	 */

	public void AdicionarPessoalCabine() {

		Tripulacao tripulacao = new Tripulacao();

		System.out.println("Identidade do funcionário:");
		tripulacao.setId(ler.next());

		System.out.println("Nome do funcionário:");
		tripulacao.setNome(ler.next());

		System.out.println("Nacionalidade:");
		tripulacao.setNacionalidade(ler.next());

		System.out.println("Morada:");
		tripulacao.setMorada(ler.next());

		System.out.println("Telefone:");
		tripulacao.setTelefone(ler.nextInt());

		System.out.println("Data de nascimento:");
		tripulacao.setDataDeNascimento(ler.next());

		System.out.println("Data de validade:");
		tripulacao.setDataDeValidade(ler.next());

		System.out.println("Anotações:");
		tripulacao.setAnotacoes(ler.next());

		System.out.println("Categoria:");
		tripulacao.setCategoria(ler.next());

		this.tripulacao.add(tripulacao);

		System.out.println("Tripulante adicionado com sucesso!");
		System.out.println("");

		// Gravar ficheiros tripulação

		ApresentarMenuTripulação();
	}

	public void ListarPessoalCabine() {

		if (tripulacao.isEmpty()) {
			System.out.println("Não existem tripulantes de cabine registrados!");
		} else {
			for (Tripulacao tripulacao : tripulacao) {
				System.out.println(tripulacao);
			}

			ApresentarMenuTripulação();
		}
	}

	public void ElminarCabine() {

		Tripulacao eliminarCabine = null;
		String nomeCabine;

		System.out.println("Insira o nome do tripulante que deseja eliminar:");
		nomeCabine = ler.next();

		for (Tripulacao tripulacao : tripulacao) {
			if (nomeCabine.equals(tripulacao.getNome())) {
				eliminarCabine = tripulacao;
				break;
			}
		}
		if (eliminarCabine != null) {
			tripulacao.remove(eliminarCabine);

			System.out.println("Tripulante eliminado com sucesso!");
		}

	}
	/*
	 * 
	 * CONTROLO DE VOOS
	 * 
	 */

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

		GravarFicheirosVoos();

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

	public void EditarVoosCompleto() {

		Voo editarVoo = new Voo();
		String numeroVoo;

		System.out.println("Insira o número do voo:");
		numeroVoo = ler.next();

		for (Voo voo : voos) {
			if (numeroVoo.equals(voo.getnVoo())) {
				editarVoo = voo;
				
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
				
				System.out.println("Editado com sucesso!");
				
				GravarFicheirosVoos();

				ApresentarMenuPassageiro();
				
			} else {
				System.out.println("Voo não encontrado!");

				MenuEditarVoos();
			}
		}

		
	}

	/*
	 * 
	 * CONTROLO DE FICHEIROS
	 * 
	 */

	public void LerFicheirosVoos() {

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

	public void LerFicheirosPassageiros() {

		// Agora vou abrir os Reader
		try {
			FileReader fr = new FileReader("C:\\Users\\asaph\\Desktop\\Aero\\Teste2.txt");
			BufferedReader ler = new BufferedReader(fr);
			// Ler o texto q foi escrito usando o BufferedReader
			String linha;

			while (ler.ready()) {
				linha = ler.readLine();
				String[] partes = linha.split("\\|");

				String id = partes[0];
				String nome = partes[1];
				String nacionalidade = partes[2];
				String morada = partes[3];
				int telefone = Integer.parseInt(partes[4]);
				String dataDeNascimento = partes[5];
				String email = partes[6];
				String tipoBilhete = partes[7];
				String lugarReservado = partes[8];

				Passageiros passageiros = new Passageiros(id, nome, nacionalidade, morada, telefone, dataDeNascimento,
						email, tipoBilhete, lugarReservado);

				this.passageiros.add(passageiros);

			}

			ler.close();

		} catch (IOException Ex) {
			System.out.println(Ex.getMessage());
		}
	}

	public void GravarFicheirosVoos() {

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

				} else {

					for (Voo voo : voos) {
						linha = "";

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
				}
				caneta.close();
			} catch (IOException Ex) {
				{
					System.out.println(Ex.getMessage());
				}

			}
		}

	}

	public void GravarFicheirosPass() {
		String resposta;

		System.out.println("Queres salvar as altereções (S/N)?");
		resposta = ler.next();

		if (resposta.equals("S") || resposta.equals("s")) {

			try {
				// Abrir o FileWriter, Buffered Writer
				FileWriter fw = new FileWriter("C:\\Users\\asaph\\Desktop\\Aero\\Teste2.txt");
				BufferedWriter caneta = new BufferedWriter(fw);
				String linha = "";

				if (passageiros.isEmpty()) {
					caneta.write("");

				} else {

					for (Passageiros passageiros : passageiros) {
						linha += passageiros.getId() + "|";
						linha += passageiros.getNome() + "|";
						linha += passageiros.getNacionalidade() + "|";
						linha += passageiros.getMorada() + "|";
						linha += passageiros.getTelefone() + "|";
						linha += passageiros.getDataDeNascimento() + "|";
						linha += passageiros.getEmail() + "|";
						linha += passageiros.getTipoBilhete() + "|";
						linha += passageiros.getLugarReservado() + "|\n";

						caneta.write(linha);
					}
				}
				caneta.close();

			} catch (IOException Ex) {
				{
					System.out.println(Ex.getMessage());
				}

			}
		}

	}

}
