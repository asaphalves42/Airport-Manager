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
	ArrayList<Aeroporto> aeroporto = new ArrayList<>();

	public void Iniciar() {
		LerFicheirosVoos();
		LerFicheirosPassageiros();
		LerFicheirosAeroporto();
		// LerFicheirosAeronave();

		System.out.println("Bem vindo a aplica��o para companhia a�rea");
		LerCompanhiaAerea();
		MenuPrincipal();

	}

	public void LerCompanhiaAerea() {
		System.out.println("Qual a companhia a�rea?");

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
			System.out.println("Selecione uma op��o:");

			System.out.println("1 - Voo");
			System.out.println("2 - Passageiro");
			System.out.println("3 - Tripula��o");
			System.out.println("4 - Aeronaves");
			System.out.println("5 - Aeroportos");
			System.out.println("6 - Fechar");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1:
				ApresentarMenuVoo();
				break;

			case 2:
				ApresentarMenuPassageiro();
				break;

			case 3:
				ApresentarMenuTripula��o();
				break;

			case 4:
				MenuAeronaves();
				break;

			case 5:
				MenuAeroportos();
				break;

			case 6:

				break;

			default:
				System.out.println("Op��o Inv�lida");
				break;

			}
		} while (opcao != 6);
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
				System.out.println("Opc�o inv�lida!");
				break;

			}
		} while (opcao != 5);

	}

	public void MenuVoo2() {

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

	public void MenuListaPassageiros2() {

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

	public void ApresentarMenuTripula��o() {
		int opcao;

		do {
			System.out.println("1 - Listar pessoal cabine");
			System.out.println("2 - Editar pessoal cabine");
			System.out.println("3 - Adicionar pessoal cabine");
			System.out.println("4 - Eliminar pessoal cabine");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1:
				ListarPessoalCabine();
				break;
			case 2:
				EditarCabine();
				break;
			case 3:
				AdicionarPessoalCabine();
				break;
			case 4:
				ElminarCabine();
				break;
			case 5:
				MenuPrincipal();
				break;
			default:
				System.out.println("Opc�o inv�lida");
			}
		} while (opcao != 5);
	}

	public void MenuEditarVoos() {

		int opcao;

		do {
			System.out.println("Selecione uma op��o");
			System.out.println("1 - Editar voo completo:");
			System.out.println("2 - Editar n�mero do voo:");
			System.out.println("3 - Editar nome do avi�o:");
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
			case 10:
				ApresentarMenuVoo();
				break;
			default:
				System.out.println("Op��o Inv�lida");

			}
		} while (opcao != 10);
	}

	public void MenuAeronaves() {

		int opcao;

		System.out.println("## Selecione uma op��o ##");

		do {

			System.out.println("1 - Adicionar aeronave:");
			System.out.println("2 - Listar aeronave:");
			System.out.println("3 - Editar aeronaves");
			System.out.println("4 - Eliminar aeronave:");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1:
				AdicionarAaeronaves();
				break;
			case 2:
				ListarAeronaves();
				break;
			case 3:
				EditarAeronaves();
				break;
			case 4:
				EliminarAeronaves();
				break;
			case 5:
				MenuPrincipal();
				break;
			default:
				System.out.println("Opc�o inv�lida!");
			}
		} while (opcao != 5);
	}

	public void MenuAeroportos() {

		int opcao;

		do {

			System.out.println("## Selecione uma op��o ##");

			System.out.println("1 - Adicionar aeroportos:");
			System.out.println("2 - Listar aeroportos:");
			System.out.println("3 - Editar aeroportos:");
			System.out.println("4 - Eliminar aeroportos:");
			System.out.println("5 - Voltar ao menu anterior:");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				AdicionarAaeroporto();
				break;
			case 2:
				ListarAaeroportos();
				break;
			case 3:
				EditarAeroportos();
				break;
			case 4:
				EliminarAeroportos();
				break;
			case 5:
				MenuPrincipal();
				break;

			default:
				System.out.println("Op��o Inv�lida!");

			}

		} while (opcao != 5);
	}

	/*
	 * 
	 * CONTROLO DE FUN��ES
	 * 
	 */

	public void AdicionarPassageiros() {

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

		System.out.println(" ");

		System.out.println("Passageiro adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosPass();

	}

	public void EliminarPassageiros() {

		Passageiros eliminarPassageiro = null;
		String idPassageiro;

		System.out.println("Insira o n�mero da identidade do passageiro que queres eliminar:");
		idPassageiro = ler.next();

		for (Passageiros passageiros : passageiros) {
			if (idPassageiro.equals(passageiros.getId())) {
				eliminarPassageiro = passageiros;
				break;
			}
		}
		if (eliminarPassageiro != null) {
			passageiros.remove(eliminarPassageiro);

			System.out.println(" ");

			System.out.println("Passageiro eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}
	}

	public void EditarPassageiroCompleto() {

		Passageiros editarPassageiro = new Passageiros();
		String idPass;

		System.out.println("Insira o n�mero de identidade do passageiro:");
		idPass = ler.next();

		for (Passageiros passageiros : passageiros) {
			if (idPass.equals(passageiros.getId())) {
				editarPassageiro = passageiros;

				System.out.println("Insira o novo n�mero de identidade do passageiro:");
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

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

			} else {
				System.out.println("Passageiro n�o encontrado!");

				ApresentarMenuPassageiro();
			}
		}

		ApresentarMenuVoo();

	}

	public void ListarTodosOsPassageiros() {

		if (passageiros.isEmpty()) {
			System.out.println("N�o existem passageiros registrados!");
			System.out.println(" ");
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

		System.out.println("Identidade do funcion�rio:");
		tripulacao.setId(ler.next());

		System.out.println("Nome do funcion�rio:");
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

		System.out.println("Anota��es:");
		tripulacao.setAnotacoes(ler.next());

		System.out.println("Categoria:");
		tripulacao.setCategoria(ler.next());

		this.tripulacao.add(tripulacao);

		System.out.println(" ");

		System.out.println("Tripulante adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosTripulantes();

		ApresentarMenuTripula��o();
	}

	public void ListarPessoalCabine() {

		if (tripulacao.isEmpty()) {
			System.out.println("N�o existem tripulantes registrados!");
			System.out.println(" ");
		} else {
			for (Tripulacao tripulacao : tripulacao) {
				System.out.println(tripulacao);
			}

			ApresentarMenuTripula��o();
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

			System.out.println(" ");

			System.out.println("Tripulante eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}

	}

	public void EditarCabine() {

		Tripulacao editarTripulante = new Tripulacao();
		String idTripulante;

		System.out.println("Insira o n�mero de identidade do tripulante:");
		idTripulante = ler.next();

		for (Tripulacao tripulacao : tripulacao) {
			if (idTripulante.equals(tripulacao.getId())) {
				editarTripulante = tripulacao;

				System.out.println("Insira o novo n�mero de identidade do tripulante:");
				editarTripulante.setId(ler.next());

				System.out.println("Insira o novo nome do tripulante:");
				editarTripulante.setNome(ler.next());

				System.out.println("Insira a nova nacionalidade:");
				editarTripulante.setNacionalidade(ler.next());

				System.out.println("Insira a nova morada:");
				editarTripulante.setMorada(ler.next());

				System.out.println("Insira o novo telefone:");
				editarTripulante.setTelefone(ler.nextInt());

				System.out.println("Insira a nova data de nascimento:");
				editarTripulante.setDataDeNascimento(ler.next());

				System.out.println("Insira a nova licen�a:");
				editarTripulante.setnLincenca(ler.nextInt());

				System.out.println("Insira a nova data de validade:");
				editarTripulante.setDataDeValidade(ler.next());

				System.out.println("Insira as novas anota��es:");
				editarTripulante.setAnotacoes(ler.next());

				System.out.println("Insira a nova categoria:");
				editarTripulante.setCategoria(ler.next());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

			} else {
				System.out.println("Tripulante n�o encontrado!");

				ApresentarMenuPassageiro();
			}
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

		System.out.println("Insira o n�mero do voo que quer eliminar:");
		numVoo = ler.next();

		for (Voo voo : voos) {
			if (numVoo.equals(voo.getnVoo())) {
				eliminarVoo = voo;
				break;
			}
		}
		if (eliminarVoo != null) {
			voos.remove(eliminarVoo);

			System.out.println(" ");

			System.out.println("Voo eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}
	}

	public void AdicionarVoos() {

		Voo voo = new Voo();

		System.out.println("Insira o n�mero do voo: ");
		voo.setnVoo(ler.next());

		System.out.println("Insira o nome do avi�o: ");
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

		System.out.println(" ");

		System.out.println("Voo adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosVoos();

	}

	public void ListarVoos() {

		if (voos.isEmpty()) {
			System.out.println("N�o existem voos registrados!");
			System.out.println(" ");
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

		System.out.println("Insira o n�mero do voo:");
		numeroVoo = ler.next();

		for (Voo voo : voos) {
			if (numeroVoo.equals(voo.getnVoo())) {
				editarVoo = voo;

				System.out.println("Insira o novo n�mero do voo:");
				editarVoo.setnVoo(ler.next());

				System.out.println("Insira o novo n�mero do avi�o:");
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

				System.out.println(" ");

				System.out.println("Voo editado com sucesso!");
				System.out.println("\n-------------------------------------");

				GravarFicheirosVoos();

				ApresentarMenuPassageiro();

			} else {
				System.out.println("Voo n�o encontrado!");

				MenuEditarVoos();
			}
		}

	}

	/*
	 * 
	 * CONTROLO DE AERONAVES
	 * 
	 */

	public void AdicionarAaeronaves() {

		Aeronave aeronaves = new Aeronave();

		System.out.println("Insira o n�mero de registro:");
		aeronaves.setnRegistro(ler.next());

		System.out.println("Insira a marca/modelo:");
		aeronaves.setMarcaEmodelo(ler.next());

		System.out.println("Insira o n�mero de lugares na classe executiva:");
		aeronaves.setNlugaresExecutiva(ler.nextInt());

		System.out.println("Insira o n�mero de lugares na classe tur�stica:");
		aeronaves.setNlugaresTuristica(ler.nextInt());

		this.aeronave.add(aeronaves);

		System.out.println(" ");

		System.out.println("Aeronave adicionada com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosAeronave();

	}

	public void ListarAeronaves() {

		if (aeronave.isEmpty()) {
			System.out.println("N�o existem aeronaves registradas!");
			System.out.println(" ");
		} else {
			for (Aeronave aeronaves : aeronave) {
				System.out.println(aeronaves);
			}

			MenuAeronaves();
		}

	}

	public void EliminarAeronaves() {

		Aeronave eliminarAeronave = null;
		String numAeronave;

		System.out.println("Insira o n�mero de registro da aeronave que quer eliminar:");
		numAeronave = ler.next();

		for (Aeronave aeronaves : aeronave) {
			if (numAeronave.equals(aeronaves.getnRegistro())) {
				eliminarAeronave = aeronaves;
				break;
			}
		}
		if (numAeronave != null) {
			aeronave.remove(eliminarAeronave);

			System.out.println(" ");

			System.out.println("Aeronave eliminada com sucesso!");
			System.out.println("\n-------------------------------------");
		}

		MenuAeronaves();
	}

	public void EditarAeronaves() {

		Aeronave editarAeronave = new Aeronave();
		String numeroAeronave;

		System.out.println("Insira o n�mero de registro da aeronave:");
		numeroAeronave = ler.next();
		for (Aeronave aeronaves : aeronave) {
			if (numeroAeronave.equals(aeronaves.getnRegistro())) {
				editarAeronave = aeronaves;

				System.out.println("Insira o novo n�mero de registro:");
				editarAeronave.setnRegistro(ler.next());

				System.out.println("Insira a nova marca/modelo:");
				editarAeronave.setMarcaEmodelo(ler.next());

				System.out.println("Insira o novo n�mero de lugares da classe executiva:");
				editarAeronave.setNlugaresExecutiva(ler.nextInt());

				System.out.println("Insira o novo n�mero de lugares da classe tur�stica:");
				editarAeronave.setNlugaresTuristica(ler.nextInt());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

				// GravarFicheirosAeronaves();

				MenuAeronaves();

			} else {
				System.out.println("Aeronave n�o encontrada!");

			}
		}

	}

	/*
	 * 
	 * CONTROLO DE AEROPORTOS
	 * 
	 */

	public void AdicionarAaeroporto() {

		Aeroporto aeroportos = new Aeroporto();

		System.out.println("Insira a sigla do aeroporto:");
		aeroportos.setSigla(ler.next());

		System.out.println("Insira o pa�s:");
		aeroportos.setPais(ler.next());

		System.out.println("Insira a cidade mais pr�xima:");
		aeroportos.setCidadeProx(ler.next());

		this.aeroporto.add(aeroportos);

		System.out.println(" ");

		System.out.println("Aeroporto adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosAeroporto();

	}

	public void ListarAaeroportos() {

		if (aeroporto.isEmpty()) {
			System.out.println("N�o existem aeroportos registrados!");
			System.out.println(" ");
		} else {
			for (Aeroporto aeroportos : aeroporto) {
				System.out.println(aeroportos);
			}

			MenuAeroportos();
		}

	}

	public void EliminarAeroportos() {

		Aeroporto eliminarAeroporto = null;
		String sigla;

		System.out.println("Insira a sigla do aeroporto que deseja eliminar:");
		sigla = ler.next();

		for (Aeroporto aeroporto : aeroporto) {
			if (sigla.equals(aeroporto.getSigla())) {
				eliminarAeroporto = aeroporto;
				break;
			}
		}
		if (eliminarAeroporto != null) {
			aeroporto.remove(eliminarAeroporto);

			System.out.println(" ");

			System.out.println("Aeroporto eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}

		MenuAeroportos();

	}

	public void EditarAeroportos() {

		Aeroporto editarAeroporto = new Aeroporto();
		String sigla;

		System.out.println("Insira a sigla do aeroporto:");
		sigla = ler.next();
		for (Aeroporto aeroportos : aeroporto) {
			if (sigla.equals(aeroportos.getSigla())) {

				editarAeroporto = aeroportos;

				System.out.println("Insira a nova sigla:");
				editarAeroporto.setSigla(ler.next());

				System.out.println("Insira o novo pa�s:");
				editarAeroporto.setPais(ler.next());

				System.out.println("Insira a nova cidade mais pr�xima:");
				editarAeroporto.setCidadeProx(ler.next());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

				// GravarFicheirosAeroportos();

				MenuAeroportos();

			} else {
				System.out.println("Aeroporto n�o encontrado!");
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

		System.out.println("Queres salvar as altere��es (S/N)?");
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

		System.out.println("Queres salvar as altere��es (S/N)?");
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
						linha = "";

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

	public void LerFicheirosAeroporto() {

		// Agora vou abrir os Reader
		try {
			FileReader fr = new FileReader("C:\\Users\\asaph\\Desktop\\Aero\\Teste4Aeroporto.txt");
			BufferedReader ler = new BufferedReader(fr);
			// Ler o texto q foi escrito usando o BufferedReader
			String linha;

			while (ler.ready()) {
				linha = ler.readLine();
				String[] partes = linha.split("\\|");

				String sigla = partes[0];
				String pais = partes[1];
				String cidadeProx = partes[2];

				Aeroporto aeroportos = new Aeroporto(sigla, pais, cidadeProx);
				aeroporto.add(aeroportos);

			}

			ler.close();

		} catch (IOException Ex) {
			System.out.println(Ex.getMessage());
		}

	}

	public void GravarFicheirosAeroporto() {

		String resposta;

		System.out.println("Queres salvar as altere��es (S/N)?");
		resposta = ler.next();

		if (resposta.equals("S") || resposta.equals("s")) {

			try {
				// Abrir o FileWriter, Buffered Writer
				FileWriter fw = new FileWriter("C:\\Users\\asaph\\Desktop\\Aero\\Teste4Aeroporto.txt");
				BufferedWriter caneta = new BufferedWriter(fw);
				String linha = "";

				if (aeroporto.isEmpty()) {
					caneta.write("");

				} else {

					for (Aeroporto aeroporto : aeroporto) {
						linha = "";

						linha += aeroporto.getSigla() + "|";
						linha += aeroporto.getPais() + "|";
						linha += aeroporto.getCidadeProx() + "\n|";

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

	public void LerFicheirosAeronave() {
		/*
		 * // Agora vou abrir os Reader try { FileReader fr = new
		 * FileReader("C:\\Users\\asaph\\Desktop\\Aero\\Teste5Aeronave.txt");
		 * BufferedReader ler = new BufferedReader(fr); // Ler o texto q foi escrito
		 * usando o BufferedReader String linha;
		 * 
		 * while (ler.ready()) { linha = ler.readLine(); String[] partes =
		 * linha.split("\\|");
		 * 
		 * String nRegistro = partes[0]; String marcaEmodelo = partes[1]; String
		 * nlugaresTuristica = Integer.parseInt(partes[2]); int nlugaresExecutiva =
		 * Integer.parseInt(partes[3]);
		 * 
		 * Aeronave aeronaves = new Aeronave(nRegistro, marcaEmodelo, nlugaresTuristica,
		 * nlugaresExecutiva); aeronave.add(aeronaves);
		 * 
		 * }
		 * 
		 * ler.close();
		 * 
		 * } catch (IOException Ex) { System.out.println(Ex.getMessage()); }
		 */
	}

	public void GravarFicheirosAeronave() {

		/*
		 * String resposta;
		 * 
		 * System.out.println("Queres salvar as altere��es (S/N)?"); resposta =
		 * ler.next();
		 * 
		 * if (resposta.equals("S") || resposta.equals("s")) {
		 * 
		 * try { // Abrir o FileWriter, Buffered Writer FileWriter fw = new
		 * FileWriter("C:\\Users\\asaph\\Desktop\\Aero\\Teste4Aeroporto.txt");
		 * BufferedWriter caneta = new BufferedWriter(fw); String linha = "";
		 * 
		 * if (aeroporto.isEmpty()) { caneta.write("");
		 * 
		 * } else {
		 * 
		 * for (Aeroporto aeroporto : aeroporto) { linha = "";
		 * 
		 * linha += aeroporto.getSigla() + "|"; linha += aeroporto.getPais() + "|";
		 * linha += aeroporto.getCidadeProx() + "\n|";
		 * 
		 * caneta.write(linha); } } caneta.close();
		 * 
		 * } catch (IOException Ex) { { System.out.println(Ex.getMessage()); }
		 * 
		 * } }
		 * 
		 * 
		 * 
		 */
	}

	public void LerFicheirosTripulantes() {

		/*
		 * // Agora vou abrir os Reader try { FileReader fr = new
		 * FileReader("C:\\Users\\asaph\\Desktop\\Aero\\Teste3.txt"); BufferedReader ler
		 * = new BufferedReader(fr); // Ler o texto q foi escrito usando o
		 * BufferedReader String linha;
		 * 
		 * while (ler.ready()) { linha = ler.readLine(); String[] partes =
		 * linha.split("\\|");
		 * 
		 * String id = partes[0]; String nome = partes[1]; String nacionalidade =
		 * partes[2]; String morada = partes[3]; int telefone =
		 * Integer.parseInt(partes[4]); String dataDeNascimento = partes[5]; int
		 * nLincenca = Integer.parseInt(partes[6]); String dataDeValidade = partes[7];
		 * String anotacoes = partes[8]; String categoria = partes[8];
		 * 
		 * Tripulacao tripulantes = new Tripulacao(id, nome, nacionalidade, morada,
		 * telefone, dataDeNascimento, nLincenca, dataDeValidade, categoria);
		 * 
		 * this.tripulacao.add(tripulantes);
		 * 
		 * }
		 * 
		 * ler.close();
		 * 
		 * } catch (IOException Ex) { System.out.println(Ex.getMessage()); }
		 */
	}

	public void GravarFicheirosTripulantes() {

		String resposta;

		System.out.println("Queres salvar as altere��es (S/N)?");
		resposta = ler.next();

		if (resposta.equals("S") || resposta.equals("s")) {

			try {
				// Abrir o FileWriter, Buffered Writer
				FileWriter fw = new FileWriter("C:\\Users\\asaph\\Desktop\\Aero\\Teste2.txt");
				BufferedWriter caneta = new BufferedWriter(fw);
				String linha = "";

				if (tripulacao.isEmpty()) {
					caneta.write("");

				} else {

					for (Tripulacao tripulantes : tripulacao) {
						linha = "";

						linha += tripulantes.getId() + "|";
						linha += tripulantes.getNome() + "|";
						linha += tripulantes.getNacionalidade() + "|";
						linha += tripulantes.getMorada() + "|";
						linha += tripulantes.getTelefone() + "|";
						linha += tripulantes.getDataDeNascimento() + "|";
						linha += tripulantes.getnLincenca() + "|";
						linha += tripulantes.getDataDeValidade() + "|";
						linha += tripulantes.getAnotacoes() + "|";
						linha += tripulantes.getCategoria() + "|\n";

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
