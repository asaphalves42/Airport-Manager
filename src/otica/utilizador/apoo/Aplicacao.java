package otica.utilizador.apoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import avioes.apoo.app.Aeronave;
import avioes.apoo.app.Aeroporto;
import avioes.apoo.app.Passageiros;
import avioes.apoo.app.Tripulacao;
import avioes.apoo.app.Voo;

public class Aplicacao {
	
	public String companhia;
	public String LocalizacaoDados = "C:\\aplicacao";
	
	Scanner ler = new Scanner(System.in);

	ArrayList<Voo> voos = new ArrayList<>();
	ArrayList<Aeronave> aeronaves = new ArrayList<>();
	ArrayList<Aeroporto> aeroportos = new ArrayList<>();
	ArrayList<Tripulacao> tripulantes = new ArrayList<>();
	ArrayList<Passageiros> passageiros = new ArrayList<>();

	public void Iniciar() {
		SelecionarCompanhiaAerea();
		LerFicheirosVoos();
		LerFicheirosPassageiros();
		LerFicheirosAeroportos();
		LerFicheirosAeronaves();
		LerFicheirosTripulantes();
		System.out.println("Bem vindo a aplicação para companhia aérea!");	
		MenuPrincipal();

	}

	public void SelecionarCompanhiaAerea() {
		System.out.println("Qual a companhia aérea?");
		companhia = ler.next();
	}

	/*
	 * 
	 * CONTROLO DE MENUS
	 * 
	 */

	public void MenuPrincipal() {
		// Funcao que mostra ao utilizador o menu principal
		int opcao;
		do {

			System.out.println("");
			System.out.println("## Menu principal ##");
			System.out.println("Companhia selecionada: " + companhia);

			System.out.println("Selecione uma opção:");

			System.out.println("1 - Voos");
			System.out.println("2 - Passageiros");
			System.out.println("3 - Tripulantes");
			System.out.println("4 - Aeronaves");
			System.out.println("5 - Aeroportos");
			System.out.println("6 - Estatisticas");
			System.out.println("7 - Fechar");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
			switch (opcao) {
				case 1:
					ApresentarMenuVoo();
					break;
				case 2:
					ApresentarMenuPassageiro();
					break;
				case 3:
					ApresentarMenuTripulacao();
					break;
				case 4:
					MenuAeronaves();
					break;
				case 5:
					MenuAeroportos();
					break;
				case 6:
					Estatisticas();
					break;
				case 7:
					break;
				default:
					System.out.println("Opção inválida");
				break;
			}
		} while (opcao != 7);
	}

	public void ApresentarMenuVoo() {

		int opcao;
		System.out.println("## MENU VOOS ##");
		
		do {

			System.out.println("1 - Listar voos");
			System.out.println("2 - Editar voos");
			System.out.println("3 - Adicionar voos");
			System.out.println("4 - Eliminar voos");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = (ler.nextInt());
			// chamar a funcao especifica a que o utilizador usar
			switch (opcao) {
				case 1:
					MenuVooListar();
					break;
				case 2:
					EditarVoosCompleto();
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
					System.out.println("Opção inválida!");
	
					break;
			}
		} while (opcao != 5);

	}

	public void MenuVooListar() {

		int opcao;
		System.out.println("## MENU VOOS - LISTAR ##");
		
		do {
			System.out.println("1 - Listar por datas");
			System.out.println("2 - Listar por rotas");
			System.out.println("3 - Listar todos os voos");
			System.out.println("4 - Listar voo por número");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
			switch (opcao) {

			case 1:
				FiltrarVoosPorData();
				break;
			case 2:
				FilrarVoosPorRota();
				break;
			case 3:
				ListarVoos();
				break;
			case 4:
				ListarVoosPorNumero();
				break;
			case 5:
				ApresentarMenuVoo();
				break;
			default:

				System.out.println("Opção inválida");

				break;
			}

		} while (opcao != 5);
	}

	public void ApresentarMenuPassageiro() {

		int opcao;
		System.out.println("## MENU PASSAGEIROS ##");
		
		do {
			System.out.println("1 - Listar passageiros");
			System.out.println("2 - Editar passageiros");
			System.out.println("3 - Adicionar passageiros");
			System.out.println("4 - Eliminar passageiros");
			System.out.println("5 - Média de passageiros");
			System.out.println("6 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
			switch (opcao) {
				case 1:
					MenuListaPassageirosListar();
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
					// Funcao para mostrar a media dos passageiros
					break;
				case 6:
					MenuPrincipal();
					break;
				default:
					System.out.println("Op��o inv�lida");
				}
		} while (opcao != 6);
	}

	public void MenuListaPassageirosListar() {

		int opcao;
		System.out.println("## MENU PASSAGEIROS - LISTAR ##");
		
		do {
			System.out.println("1 - Listar passageiros por voo");
			System.out.println("2 - Listar todos os passageiros");
			System.out.println("3 - Listar passageiros num intervalo de datas");
			System.out.println("4 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
			switch (opcao) {
				case 1: ListarPassageirosPorVoo();
					break;
				case 2:
					ListarTodosOsPassageiros();
					break;
				case 3:
					// Funcao para apresentar voos em um dia
					break;
				case 4:
					ApresentarMenuPassageiro();
					break;			
				default:
					System.out.println("Opção inválida");
					break;
			}

		} while (opcao != 4);
	}

	public void ApresentarMenuTripulacao() {

		int opcao;
		System.out.println("## MENU TRIPULANTES - LISTAR ##");
		
		do {
			System.out.println("1 - Listar pessoal cabine");
			System.out.println("2 - Editar pessoal cabine");
			System.out.println("3 - Adicionar pessoal cabine");
			System.out.println("4 - Eliminar pessoal cabine");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
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
					System.out.println("Opcão inválida");
					break;
			}
		} while (opcao != 5);
	}

	public void MenuAeronaves() {

		int opcao;
		System.out.println("## MENU AERONAVES ##");

		do {

			System.out.println("1 - Adicionar aeronave:");
			System.out.println("2 - Listar aeronave:");
			System.out.println("3 - Editar aeronaves");
			System.out.println("4 - Eliminar aeronave:");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
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
				System.out.println("Op��o inv�lida!");
			}
		} while (opcao != 5);
	}

	public void MenuAeroportos() {

		int opcao;

		// escolher as opcoes do menu consoante ao que o utilizador deseja, e
		// repeticao
		// do menu
		System.out.println("## MENU AEROPORTOS ##");
		do {			
			System.out.println("1 - Adicionar aeroportos:");
			System.out.println("2 - Listar aeroportos:");
			System.out.println("3 - Editar aeroportos:");
			System.out.println("4 - Eliminar aeroportos:");
			System.out.println("5 - Voltar ao menu anterior:");

			opcao = ler.nextInt();

			// chamar a funcao especifica a que o utilizador usar
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
	 * CONTROLO DE FUNCOES
	 * 
	 */

	// Funcao para adicionar passageiros
	public void AdicionarPassageiros() {

		// Crio um objeto do tipo passageiro, e adiciono os dados
		Passageiros passageiro = new Passageiros();

		System.out.print("Indique o n. do Voo:");
		passageiro.setnVoo(ler.next());

		System.out.println("Identidade do passageiro:");
		passageiro.setId(ler.next());

		System.out.println("Nome do passageiro:");
		passageiro.setNome(ler.next());

		System.out.println("Nacionalidade:");
		passageiro.setNacionalidade(ler.next());

		System.out.println("Morada:");
		passageiro.setMorada(ler.next());

		System.out.println("Telefone:");
		passageiro.setTelefone(ler.next());

		System.out.println("Data de nascimento:");
		passageiro.setDataDeNascimento(LerData().toString());

		System.out.println("E-mail:");
		passageiro.setEmail(ler.next());

		System.out.println("Tipo do bilhete:");
		passageiro.setTipoBilhete(ler.next());

		System.out.println("Lugar reservado");
		passageiro.setLugarReservado(ler.next());

		// adiciono ao arrayList
		this.passageiros.add(passageiro);

		System.out.println(" ");

		// mensagem ao utilizador
		System.out.println("Passageiro adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		// gravo os ficheiros
		GravarFicheirosPassageiros();

	}

	// funcao para eliminar passageiros
	public void EliminarPassageiros() {

		Passageiros eliminarPassageiro = null;
		String idPassageiro;

		// pergunto ao utilizador o id do passageiro
		System.out.println("Insira o n�mero da identidade do passageiro que deseja eliminar:");
		idPassageiro = ler.next();

		// Percorro o array e encontro o id que o utilizador inseriu
		for (Passageiros passageiros : passageiros) {
			if (idPassageiro.equals(passageiros.getId())) {
				eliminarPassageiro = passageiros;
				break;
			}
		}
		// removo do array
		if (eliminarPassageiro != null) {
			passageiros.remove(eliminarPassageiro);

			System.out.println(" ");

			// mensagem ao utilizador
			System.out.println("Passageiro eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}
	}

	// Funcao para editar algum passageiro
	public void EditarPassageiroCompleto() {

		String idPass;

		// identifico o passageiro
		System.out.println("Insira o n�mero de identidade do passageiro que deseja editar:");
		idPass = ler.next();

		// percorro o array para ver se existe os dados inseridos
		for (Passageiros passageiros : passageiros) {
			if (idPass.equals(passageiros.getId())) {

				// edito todos os campos
				System.out.println("Indique o n� do Voo:");
				passageiros.setnVoo(ler.next());

				System.out.println("Insira o novo n�mero de identidade do passageiro:");
				passageiros.setId(ler.next());

				System.out.println("Insira o novo nome do passageiro:");
				passageiros.setNome(ler.next());

				System.out.println("Insira a nova nacionalidade:");
				passageiros.setNacionalidade(ler.next());

				System.out.println("Insira a nova morada:");
				passageiros.setMorada(ler.next());

				System.out.println("Insira o novo telefone:");
				passageiros.setTelefone(ler.next());

				System.out.println("Insira a nova data de nascimento:");
				passageiros.setDataDeNascimento(ler.next());

				System.out.println("Insira o novo e-mail:");
				passageiros.setEmail(ler.next());

				System.out.println("Insira o novo tipo de bilhete:");
				passageiros.setTipoBilhete(ler.next());

				System.out.println("Insira o novo lugar reservado:");
				passageiros.setLugarReservado(ler.next());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

			} else {

				// mensagem ao utilizador
				System.out.println("Passageiro não encontrado!");

				ApresentarMenuPassageiro();
			}
		}

		ApresentarMenuVoo();

	}

	// Funcao para listar os passageiros do array
	public void ListarTodosOsPassageiros() {
		// Verifico se o array contem dados
		if (passageiros.isEmpty()) {
			System.out.println("Não existem passageiros registados!");
			System.out.println(" ");
		} else {
			// Se contem, percorro o array e mostro ao utilizador
			for (Passageiros passageiro : passageiros) {
				System.out.println(passageiro);
			}

			ApresentarMenuPassageiro();
		}

	}

	public void ListarPassageirosPorData() {
	/*	LocalDate dataInicioPesquisa;
		LocalDate dataFimPesquisa;

		System.out.println("Insira uma data de in�cio (dd/MM/aaaa):");
		dataInicioPesquisa = LerData();

		System.out.println("Insira uma data fim (dd/MM/aaaa):");
		dataFimPesquisa = LerData();

		for (Passageiros passageiro : passageiros) {
			if(

			}
		}
		
		
		
	
	*/
	}
	
	public void ListarPassageirosPorVoo() {
		String nVoo;
		
		if (passageiros.isEmpty()) {
			System.out.println("N�o existem passageiros registados!");
			System.out.println(" ");
		} else {
			// Se contem, percorro o array e mostro ao utilizador
			
			System.out.println("Insira o n�mero do voo:");
			nVoo = ler.next();
			
			for (Passageiros passageiros : passageiros) {
				if(passageiros.getnVoo().equals(nVoo)) {
					System.out.println(passageiros);
				}
			}

			ApresentarMenuPassageiro();
		}
		
		
		
		
	}
	
	/*
	 * 
	 * CONTROLO DE PESSOAL CABINE
	 * 
	 */

	// Funcao para adicionar tripulantes
	public void AdicionarPessoalCabine() {
		// Preencho os dados

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
		tripulacao.setTelefone(ler.next());

		System.out.println("Data de nascimento:");
		tripulacao.setDataDeNascimento(ler.next());

		System.out.println("Data de validade:");
		tripulacao.setDataDeValidade(ler.next());

		System.out.println("Anota��es:");
		tripulacao.setAnotacoes(ler.next());

		System.out.println("Categoria:");
		tripulacao.setCategoria(ler.next());

		// Adiciono ao array
		this.tripulantes.add(tripulacao);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Tripulante adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		// Gravo para ficheiros
		GravarFicheirosTripulantes();

		// Volto ao menu
		ApresentarMenuTripulacao();
	}

	// Funcao para listar tripulantes
	public void ListarPessoalCabine() {

		// Verifico se contem dados no array
		if (tripulantes.isEmpty()) {
			System.out.println("Não existem tripulantes registrados!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro o conteudo dele
			for (Tripulacao tripulante : tripulantes) {
				System.out.println(tripulante);
			}

			// Volto ao menu anterior
			ApresentarMenuTripulacao();
		}
	}

	// Funcao para eliminar um tripulante
	public void ElminarCabine() {

		Tripulacao eliminarCabine = null;
		String nomeCabine;

		// Peco ao utilizador o nome do tripulante
		System.out.println("Insira o nome do tripulante que deseja eliminar:");
		nomeCabine = ler.next();

		// Percorro o array para ver se encontro o nome
		for (Tripulacao tripulante : tripulantes) {
			if (nomeCabine.equals(tripulante.getNome())) {
				eliminarCabine = tripulante;
				break;
			}
		}

		// Se encontrar, elimino do array
		if (eliminarCabine != null) {
			tripulantes.remove(eliminarCabine);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Tripulante eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}

	}

	// Funcao para editar os dados de um tripulante
	public void EditarCabine() {

		String idTripulante;

		// Pergunto ao utilizador a identidade do tripulante
		System.out.println("Insira o n�mero de identidade do tripulante que deseja editar:");
		idTripulante = ler.next();

		// Percorro o array para encontrar o id
		for (Tripulacao tripulante : tripulantes) {
			if (idTripulante.equals(tripulante.getId())) {

				// Edito os dados
				System.out.println("Indique o n� do Voo:");
				tripulante.setnVoo(ler.next());

				System.out.println("Insira o novo número de identidade do tripulante:");
				tripulante.setId(ler.next());

				System.out.println("Insira o novo nome do tripulante:");
				tripulante.setNome(ler.next());

				System.out.println("Insira a nova nacionalidade:");
				tripulante.setNacionalidade(ler.next());

				System.out.println("Insira a nova morada:");
				tripulante.setMorada(ler.next());

				System.out.println("Insira o novo telefone:");
				tripulante.setTelefone(ler.next());

				System.out.println("Insira a nova data de nascimento:");
				tripulante.setDataDeNascimento(ler.next());

				System.out.println("Insira a nova licença:");
				tripulante.setnLincenca(ler.next());

				System.out.println("Insira a nova data de validade:");
				tripulante.setDataDeValidade(ler.next());

				System.out.println("Insira as novas anotações:");
				tripulante.setAnotacoes(ler.next());

				System.out.println("Insira a nova categoria:");
				tripulante.setCategoria(ler.next());

				System.out.println(" ");

				// Mensagem ao utilizador se conseguir
				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

			} else {
				// Mensagem ao utilizador se nao encontrar o tripulante
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

	// Funcao para eliminar um voo
	public void EliminarVoos() {

		Voo eliminarVoo = null;
		String numVoo;

		// Pergunto ao utilizador o voo que quer eliminar
		System.out.println("Insira o número do voo que deseja eliminar:");
		numVoo = ler.next();

		// Percorro o array encontrar o voo
		for (Voo voo : voos) {
			if (numVoo.equals(voo.getnVoo())) {
				eliminarVoo = voo;
				break;
			}
		}

		// Removo do array
		if (eliminarVoo != null) {
			voos.remove(eliminarVoo);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Voo eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}
	}

	// Funcao para adicionar um voo
	public void AdicionarVoos() {

		Voo voo = new Voo();

		// Adiciono os dados
		System.out.println("Insira o numero do voo: ");
		voo.setnVoo(ler.next());

		System.out.println("Insira o nome do avião: ");
		voo.setAviao(ler.next());

		System.out.println("Insira o aeroporto de origem: ");
		voo.setAeroOrigem(ler.next());

		System.out.println("Insira o aeroporto de destino: ");
		voo.setAeroDestino(ler.next());

		System.out.println("Insira a data de partida: ");
		voo.setDataDePartida(LerData());

		System.out.println("Insira a data de chegada: ");
		voo.setDataDeChegada(LerData());

		System.out.println("Insira a hora de partida: ");
		voo.setHoraDePartida(ler.next());

		System.out.println("Insira a hora de chegada: ");
		voo.setHoraDeChegada(ler.next());

		// adiciono no array
		this.voos.add(voo);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Voo adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		// Gravo nos ficheiros
		GravarFicheirosVoos();

	}

	// Funcao para listar os voos
	public void ListarVoos() {

		// Verifico se existem dados registrados
		if (voos.isEmpty()) {
			System.out.println("N�o existem voos registados!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro os dados
			for (Voo voo : voos) {
				System.out.println(voo);
			}

			ApresentarMenuVoo();
		}

	}

	// Funcao para editar os dados de um voo
	public void EditarVoosCompleto() {

		Voo editarVoo = new Voo();
		String numeroVoo;

		// Pergunto ao utilizador os numero do voo
		System.out.println("Insira o n�mero do voo:");

		// Pergunto ao utilizador os n�mero do voo
		System.out.println("Insira o n�mero do voo que deseja editar:");

		numeroVoo = ler.next();

		// Percorro o array, encontro os dados e altero
		for (Voo voo : voos) {
			if (numeroVoo.equals(voo.getnVoo())) {
				editarVoo = voo;

				System.out.println("Insira o novo n�mero do voo:");
				editarVoo.setnVoo(ler.next());

				System.out.println("Insira o novo n�mero do avião:");
				editarVoo.setAviao(ler.next());

				System.out.println("Insira o novo aeroporto de origem:");
				editarVoo.setAeroOrigem(ler.next());

				System.out.println("Insira o novo aeroporto de destino:");
				editarVoo.setAeroDestino(ler.next());

				System.out.println("Insira a nova data de partida:");
				editarVoo.setDataDePartida(LerData());

				System.out.println("Insira a nova data de chegada:");
				editarVoo.setDataDeChegada(LerData());

				System.out.println("Insira a nova hora de partida:");
				editarVoo.setHoraDePartida(ler.next());

				System.out.println("Insira a nova hora de chegada:");
				editarVoo.setHoraDeChegada(ler.next());

				System.out.println(" ");

				// Mensagem ao utilizador
				System.out.println("Voo editado com sucesso!");
				System.out.println("\n-------------------------------------");

				// Gravo para ficheiros
				GravarFicheirosVoos();

				ApresentarMenuPassageiro();

			} else {

				// Se nao encontrar, mostro a mensagem
				System.out.println("Voo n�o encontrado!");

				// Se n�o encontrar, mostro a mensagem
				System.out.println("Voo n�o encontrado!");

				System.out.println(" ");

				ApresentarMenuVoo();
			}
		}

	}

	// Funcao para listar voo por n�mero
	public void ListarVoosPorNumero() {

		Voo listarVoo = new Voo();

		String opcao;
		// Peco ao utilizador o n�mero do voo
		System.out.println("Insira o n�mero do voo:");
		opcao = ler.next();

		// Percorro o array para ver se encontro
		for (Voo voo : voos) {
			// se sim
			if (opcao.equals(voo.getnVoo())) {
				listarVoo = voo;
			}
		}
		// mostro o voo
		System.out.println(listarVoo);
		MenuVooListar();
	}

	public void FiltrarVoosPorData() {
		LocalDate dataInicioPesquisa;
		LocalDate dataFimPesquisa;

		System.out.println("Insira uma data de in�cio (dd/MM/aaaa):");
		dataInicioPesquisa = LerData();

		System.out.println("Insira uma data fim (dd/MM/aaaa):");
		dataFimPesquisa = LerData();

		for (Voo voo : voos) {
			if (voo.getDataDePartida().isAfter(dataInicioPesquisa)
					&& voo.getDataDeChegada().isBefore(dataFimPesquisa)) {

				System.out.println(voo);

			}
		}
		MenuVooListar();

	}

	public void FilrarVoosPorRota() {
		String aeroportoOrigem;
		String aeroportoDestino;

		System.out.println("Insira o aeroporto de origem:");
		aeroportoOrigem = ler.next();
		System.out.println("Insira o aeroporto de destino:");
		aeroportoDestino = ler.next();

		for (Voo voo : voos) {
			if (voo.getAeroOrigem().equalsIgnoreCase(aeroportoOrigem)
					&& (voo.getAeroDestino().equalsIgnoreCase(aeroportoDestino))) {
				System.out.println(voo);
			
			}
		}
		MenuVooListar();
	}

	/*
	 * 
	 * CONTROLO DE AERONAVES
	 * 
	 */

	// Funcao para adicionar aeronaves
	public void AdicionarAaeronaves() {

		Aeronave aeronave = new Aeronave();

		// Prencho os dados
		System.out.println("Insira o n�mero de registo:");
		aeronave.setnRegistro(ler.next());

		System.out.println("Insira a marca/modelo:");
		aeronave.setMarcaEmodelo(ler.next());

		System.out.println("Insira o n�mero de lugares na classe executiva:");
		aeronave.setNlugaresExecutiva(ler.next());

		System.out.println("Insira o n�mero de lugares na classe tur�stica:");
		aeronave.setNlugaresTuristica(ler.next());

		// adiciono ao array
		this.aeronaves.add(aeronave);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Aeronave adicionada com sucesso!");
		System.out.println("\n-------------------------------------");

		// Gravo para ficheiros
		GravarFicheirosAeronave();

	}

	// Funcao para listar aeronaves
	public void ListarAeronaves() {

		// Verifico se contem dados
		if (aeronaves.isEmpty()) {
			System.out.println("Não existem aeronaves registadas!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro os dados
			for (Aeronave aeronave : aeronaves) {
				System.out.println(aeronave);
			}

			MenuAeronaves();
		}

	}

	// Funcao para Eliminar aeronaves
	public void EliminarAeronaves() {

		Aeronave eliminarAeronave = null;
		String numAeronave;

		// Pergunto ao utilizador os dados
		System.out.println("Insira o n�mero de registo da aeronave que deseja eliminar:");
		numAeronave = ler.next();

		// Percoro o array e comparo para ver se os dados sao iguais
		for (Aeronave aeronave : aeronaves) {
			if (numAeronave.equals(aeronave.getnRegistro())) {
				eliminarAeronave = aeronave;
				break;
			}
		}
		// Se sim, elimino a aeronave
		if (numAeronave != null) {
			aeronaves.remove(eliminarAeronave);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Aeronave eliminada com sucesso!");
			System.out.println("\n-------------------------------------");
		}

		MenuAeronaves();
	}

	// Funcao para editar os dados de uma aeronave
	public void EditarAeronaves() {
		String numeroAeronave;

		// Pergunto ao utilizador a aeronave que ele quer editar
		System.out.println("Insira o n�mero de registo da aeronave que deseja editar:");
		numeroAeronave = ler.next();

		// Percorro o array para ver se encontro, e edito os dados
		for (Aeronave aeronave : aeronaves) {
			if (numeroAeronave.equals(aeronave.getnRegistro())) {
				
				System.out.println("Insira o novo n�mero de registo:");
				aeronave.setnRegistro(ler.next());

				System.out.println("Insira a nova marca/modelo:");
				aeronave.setMarcaEmodelo(ler.next());

				System.out.println("Insira o novo n�mero de lugares da classe executiva:");
				aeronave.setNlugaresExecutiva(ler.next());

				System.out.println("Insira o novo n�mero de lugares da classe tur�stica:");
				aeronave.setNlugaresTuristica(ler.next());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

				GravarFicheirosAeronave();

				MenuAeronaves();

			} else {

				// Menssagem ao utilizador caso nao encontre
				System.out.println("Aeronave n�o encontrada!");

			}
		}

	}

	/*
	 * 
	 * CONTROLO DE ESTATISTICAS
	 * 
	 */

	// Mostrar as estat�sticas
	public void Estatisticas() {

		int opcao;
		do {
			System.out.println("## Selecione uma opcão ##");
			System.out.println("1 - Média de passageiros em um dia");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1:// media
				break;
			}

		} while (opcao != 1);

		MenuPrincipal();
	}

	/*
	 * 
	 * CONTROLO DE AEROPORTOS
	 * 
	 */

	// Funcao para adicionar um aeroporto
	public void AdicionarAaeroporto() {

		Aeroporto aeroportos = new Aeroporto();

		// Adiciono os dados
		System.out.println("Insira a sigla do aeroporto:");
		aeroportos.setSigla(ler.next());

		System.out.println("Insira o pa�s:");
		aeroportos.setPais(ler.next());

		System.out.println("Insira a cidade mais pr�xima:");
		aeroportos.setCidadeProx(ler.next());

		// Adiciono ao array
		this.aeroportos.add(aeroportos);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Aeroporto adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosAeroportos();

	}

	// Funcao para listar os aeroportos
	public void ListarAaeroportos() {

		// Verifico se existem dados registados
		if (aeroportos.isEmpty()) {
			System.out.println("N�o existem aeroportos registrados!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro o conteudo
			for (Aeroporto aeroporto : aeroportos) {
				System.out.println(aeroporto);
			}

			MenuAeroportos();
		}

	}

	// Funcao para eliminar um aeroporto
	public void EliminarAeroportos() {

		Aeroporto eliminarAeroporto = null;
		String sigla;

		// Pergunto ao utilizador a sigla do aeroporto
		System.out.println("Insira a sigla do aeroporto que deseja eliminar:");
		sigla = ler.next();

		// Percorro o array para encontrar os dados inseridos
		for (Aeroporto aeroporto : aeroportos) {
			if (sigla.equals(aeroporto.getSigla())) {
				eliminarAeroporto = aeroporto;
				break;
			}
		}
		// Se encontrar, removo do array
		if (eliminarAeroporto != null) {
			aeroportos.remove(eliminarAeroporto);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Aeroporto eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}

		MenuAeroportos();

	}

	// Funcao para editar aeroporto
	public void EditarAeroportos() {

		String sigla;

		// Pergunto ao utilizador a sigla
		System.out.println("Insira a sigla do aeroporto que deseja editar:");
		sigla = ler.next();

		// Percorro o array para encontrar os dados
		for (Aeroporto aeroporto : aeroportos) {
			if (sigla.equals(aeroporto.getSigla())) {

				// Se encontrado, edito os dados
				System.out.println("Insira a nova sigla:");
				aeroporto.setSigla(ler.next());

				System.out.println("Insira o novo pa�s:");
				aeroporto.setPais(ler.next());

				System.out.println("Insira a nova cidade mais pr�xima:");
				aeroporto.setCidadeProx(ler.next());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

				// GravarFicheirosAeroportos();

				MenuAeroportos();

			} else {

				// Se nao, mensagem ao utilizador
				System.out.println("Aeroporto n�o encontrado!");
			}
		}

	}

	/*
	 * 
	 * CONTROLO DE FICHEIROS
	 * 
	 */
	
	public String ObterPastaFicheirosCompanhia() {
		
		//verificar se a pasta existe, se não existir cria
		String diretorioDados = this.LocalizacaoDados + "\\" + this.companhia;
		File theDir = new File(diretorioDados);
		if (!theDir.exists()){
		    theDir.mkdirs();
		}		
		return diretorioDados;
	}

	public void LerFicheirosVoos() {
		try {					
			String conteudo = this.LerFicheiro("voos");	
			if (conteudo != "") {
				String[] linhas  = conteudo.split("\n");
				for(String linha : linhas) {
					String[] partes = linha.split("\\|");
					
					String nVoo = partes[0];
					String Aviao = partes[1];
					String AeroOrigem = partes[2];
					String AeroDestino = partes[3];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate DataDePartida = LocalDate.parse(partes[4], formatter);
					LocalDate DataDeChegada = LocalDate.parse(partes[5], formatter);
					String HoraDePartida = partes[6];
					String HoraDeChegada = partes[7];
		
					Voo voo = new Voo(nVoo, Aviao, AeroOrigem, AeroDestino, DataDePartida, DataDeChegada, HoraDePartida,
							HoraDeChegada);
					voos.add(voo);
				}	
			}
		} catch (Exception Ex) {
			System.out.println("Ocorreu um erro a ler voos!" + Ex.getMessage());
		}
	}
	
	public void GravarFicheirosVoos() {
			
		System.out.println("Deseja gravar as alterações (S/N)?");
		String resposta = ler.next();
	
		if (resposta.equals("S") || resposta.equals("s")) {	
			try {
				String conteudo = "";	
				if (voos.isEmpty() == false) {	
					conteudo = "";	
					for (Voo voo : voos) {						
						conteudo += voo.getnVoo() + "|";
						conteudo += voo.getAviao() + "|";
						conteudo += voo.getAeroOrigem() + "|";
						conteudo += voo.getAeroDestino() + "|";
						conteudo += voo.getDataDePartida() + "|";
						conteudo += voo.getDataDeChegada() + "|";
						conteudo += voo.getHoraDePartida() + "|";
						conteudo += voo.getHoraDeChegada() + "|\n";						
					}
				}
				this.GravarFicheiro("voos", conteudo);
			} catch (Exception Ex) {				
				System.out.println("Ocorreu um erro a gravar voos!" + Ex.getMessage());					
			}
		}	
	}
		
	public void LerFicheirosPassageiros() {
		try {			
			String conteudo = this.LerFicheiro("passageiros");	
			if (conteudo != "") {
				String[] linhas  = conteudo.split("\n");
				for(String linha : linhas) {
					String[] partes = linha.split("\\|");
					
					String id = partes[0];
					String nVoo = partes[1];
					String nome = partes[2];
					String nacionalidade = partes[3];
					String morada = partes[4];
					String telefone = partes[5];
					String dataDeNascimento = partes[6];
					String email = partes[7];
					String tipoBilhete = partes[8];
					String lugarReservado = partes[9];
		
					Passageiros passageiros = new Passageiros(id, nVoo, nome, nacionalidade, morada, telefone,
							dataDeNascimento, email, tipoBilhete, lugarReservado);
		
					this.passageiros.add(passageiros);
				}			
			}
		} catch (Exception Ex) {
			System.out.println("Ocorreu um erro a ler passageiros!" + Ex.getMessage());
		}				
	}
	
	public void GravarFicheirosPassageiros() {
		System.out.println("Deseja gravar as alterações (S/N)?");
		String resposta = ler.next();
	
		if (resposta.equals("S") || resposta.equals("s")) {	
			try {
				String conteudo = "";	
				if (passageiros.isEmpty() == false) {	
					conteudo = "";	
					for (Passageiros passageiro : passageiros) {							
						conteudo += passageiro.getId() + "|";
						conteudo += passageiro.getnVoo() + "|";
						conteudo += passageiro.getNome() + "|";
						conteudo += passageiro.getNacionalidade() + "|";
						conteudo += passageiro.getMorada() + "|";
						conteudo += passageiro.getTelefone() + "|";
						conteudo += passageiro.getDataDeNascimento() + "|";
						conteudo += passageiro.getEmail() + "|";
						conteudo += passageiro.getTipoBilhete() + "|";
						conteudo += passageiro.getLugarReservado() + "|\n";		
					}						
				}
				this.GravarFicheiro("passageiros", conteudo);
			} catch (Exception Ex) {				
				System.out.println("Ocorreu um erro a gravar passageiros!" + Ex.getMessage());					
			}
		}			
	}
	
	public void LerFicheirosAeroportos() {
		try {					
			String conteudo = this.LerFicheiro("aeroportos");
			if (conteudo != "") {
				String[] linhas  = conteudo.split("\n");
				for(String linha : linhas) {
					String[] partes = linha.split("\\|");
					
					String sigla = partes[0];
					String pais = partes[1];
					String cidadeProx = partes[2];
		
					Aeroporto aeroporto = new Aeroporto(sigla, pais, cidadeProx);
					aeroportos.add(aeroporto);
				}			
			}
		} catch (Exception Ex) {
			System.out.println("Ocorreu um erro a ler aeroportos!" + Ex.getMessage());
		}
	}
	 
	public void GravarFicheirosAeroportos() {
	
		System.out.println("Deseja gravar as alterações (S/N)?");
		String resposta = ler.next();
	
		if (resposta.equals("S") || resposta.equals("s")) {	
			try {
				String conteudo = "";	
				if (aeroportos.isEmpty() == false) {	
					conteudo = "";
					for (Aeroporto aeroporto : aeroportos) {							
						conteudo += aeroporto.getSigla() + "|";
						conteudo += aeroporto.getPais() + "|";
						conteudo += aeroporto.getCidadeProx() + "\n|";						
					}								
				}
				this.GravarFicheiro("aeroportos", conteudo);
			} catch (Exception Ex) {				
				System.out.println("Ocorreu um erro a gravar aeroportos!" + Ex.getMessage());					
			}
		}		
	}
	
	public void LerFicheirosAeronaves() {
		try {			
			String conteudo = this.LerFicheiro("aeronaves");
			if (conteudo != "") {
				String[] linhas  = conteudo.split("\n");
				for(String linha : linhas) {
					String[] partes = linha.split("\\|");
					
					String nRegistro = partes[0];
					String marcaEmodelo = partes[1];
					String nLugaresTuristica = partes[2];
					String nLugaresExecutiva = partes[3];
		
					Aeronave aeronave = new Aeronave(nRegistro, marcaEmodelo, nLugaresTuristica, nLugaresExecutiva);
					aeronaves.add(aeronave);
				}
			}
		} catch (Exception Ex) {
			System.out.println("Ocorreu um erro a ler aeronaves!" + Ex.getMessage());
		}
	}
	
	public void GravarFicheirosAeronave() {	
		System.out.println("Deseja gravar as alterações (S/N)?");
		String resposta = ler.next();
	
		if (resposta.equals("S") || resposta.equals("s")) {	
			try {
				String conteudo = "";	
				if (aeronaves.isEmpty() == false) {	
					conteudo = "";		
					for (Aeronave aeronave : aeronaves) {										
						conteudo += aeronave.getnRegistro() + "|";
						conteudo += aeronave.getMarcaEmodelo() + "|";
						conteudo += aeronave.getNlugaresTuristica() + "|";
						conteudo += aeronave.getNlugaresExecutiva() + "\n|";				
					}								
				}
				this.GravarFicheiro("aeronaves", conteudo);
			} catch (Exception Ex) {				
				System.out.println("Ocorreu um erro a gravar aeronaves!" + Ex.getMessage());					
			}
		}
	}
	
	public void LerFicheirosTripulantes() {
		try {			
			String conteudo = this.LerFicheiro("tripulantes");	
			if (conteudo != "") {
				String[] linhas  = conteudo.split("\n");
				for(String linha : linhas) {
					String[] partes = linha.split("\\|");
					
					String id = partes[0];
					String nVoo = partes[1];
					String nome = partes[2];
					String nacionalidade = partes[3];
					String morada = partes[4];
					String telefone = partes[5];
					String dataDeNascimento = partes[6];
					String nLincenca = partes[7];
					String dataDeValidade = partes[8];
					String anotacoes = partes[9];
					String categoria = partes[10];
		
					Tripulacao tripulante = new Tripulacao(id, nVoo, nome, nacionalidade, morada, telefone,
							dataDeNascimento, nLincenca, dataDeValidade, anotacoes, categoria);
					this.tripulantes.add(tripulante);
				}
			}
		} catch (Exception Ex) {
			System.out.println("Ocorreu um erro a ler tripulantes!" + Ex.getMessage());
		}
	}
	
	public void GravarFicheirosTripulantes() {
	
		System.out.println("Deseja gravar as alterações (S/N)?");
		String resposta = ler.next();
	
		if (resposta.equals("S") || resposta.equals("s")) {	
			try {
				String conteudo = "";	
				if (tripulantes.isEmpty() == false) {
					conteudo = "";
					for (Tripulacao tripulante : tripulantes) {						
						conteudo += tripulante.getId() + "|";
						conteudo += tripulante.getnVoo() + "|";
						conteudo += tripulante.getNome() + "|";
						conteudo += tripulante.getNacionalidade() + "|";
						conteudo += tripulante.getMorada() + "|";
						conteudo += tripulante.getTelefone() + "|";
						conteudo += tripulante.getDataDeNascimento() + "|";
						conteudo += tripulante.getnLincenca() + "|";
						conteudo += tripulante.getDataDeValidade() + "|";
						conteudo += tripulante.getAnotacoes() + "|";
						conteudo += tripulante.getCategoria() + "|\n";						
					}								
				}
				this.GravarFicheiro("tripulantes", conteudo);
			} catch (Exception Ex) {				
				System.out.println("Ocorreu um erro a gravar tripulantes!" + Ex.getMessage());					
			}
		}		
	}
	
	public String LerFicheiro(String nomeFicheiro) {
		String conteudo = "";
		try {
			String enderecoFicheiro = ObterPastaFicheirosCompanhia() + "\\" + nomeFicheiro +".txt";
			File f = new File(enderecoFicheiro);
			if (f.exists()) {
				FileReader fr = new FileReader(enderecoFicheiro);
				BufferedReader ler = new BufferedReader(fr);	
				while (ler.ready()) {
					conteudo += ler.readLine() +"\n";				
				}	
				ler.close();
			}
	
		} catch (IOException Ex) {
			System.out.println("Ocorreu um erro a ler o ficheiro!" + Ex.getMessage());
		}
		return conteudo;
	}
	
	public void GravarFicheiro(String nomeFicheiro, String conteudo) {
		try {
			FileWriter fw = new FileWriter(ObterPastaFicheirosCompanhia() + "\\" + nomeFicheiro + ".txt");
			BufferedWriter caneta = new BufferedWriter(fw);			
			caneta.write(conteudo);			
			caneta.close();
		} catch (IOException Ex) {
			{
				System.out.println("Ocorreu um erro a gravar! " + Ex.getMessage());
			}
		}
	}
	
	// Funcao para ler e converter data
	public LocalDate LerData() {
		try {
			LocalDate data;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			data = LocalDate.parse(ler.next(), formatter);
			return data;
		} catch (Exception ex) {
			System.out.println("Data inválida, insira uma data com o formato (dd/MM/aaaa):");
			return LerData();
		}
	}
	
}
