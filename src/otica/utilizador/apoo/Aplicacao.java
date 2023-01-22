package otica.utilizador.apoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import avioes.apoo.app.Aeronave;
import avioes.apoo.app.Passageiros;
import avioes.apoo.app.Tripulacao;
import avioes.apoo.app.Voo;

public class Aplicacao {
	public static String companhia;

	Scanner ler = new Scanner(System.in);


	ArrayList<Voo> voos = new ArrayList<>();
	ArrayList<Aeronave> aeronave = new ArrayList<>();
	ArrayList<Aeroporto> aeroporto = new ArrayList<>();
	ArrayList<Tripulacao> tripulacao = new ArrayList<>();
	ArrayList<Passageiros> passageiros = new ArrayList<>();


	public void Iniciar() {
		LerFicheirosVoos();
		LerFicheirosPassageiros();
		LerFicheirosAeroporto();
		// LerFicheirosAeronave();

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
		// Fun��o que mostra ao utilizador o menu principal
		int opcao;

		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
		do {

			System.out.println("");
			System.out.println("## Menu principal ##");
			System.out.println("Companhia selecionada: " + companhia);
			System.out.println("Selecione uma opção:");

			System.out.println("1 - Voos");
			System.out.println("2 - Passageiros");
			System.out.println("3 - Tripulação");
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
				ApresentarMenuTripulacao();
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
				System.out.println("Opção Inválida");
				break;

			}
		} while (opcao != 6);
	}

	public void ApresentarMenuVoo() {

		int opcao;

		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
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
				System.out.println("Opcão inválida!");
				break;

			}
		} while (opcao != 5);

	}
	
	public void MenuVoo2() {

		int opcao;
		
		
		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
		do {
			System.out.println("1 - Listar por datas");
			System.out.println("2 - Listar por rotas");
			System.out.println("3 - Listar todos os voos");
			System.out.println("4 - Voltar ao menu anterior");

			opcao = ler.nextInt();
			
			switch (opcao) {

			case 1: // funcao para listar por datas
				FiltrarVoosPorData();
				break;
			case 2:	// Fun��o para listar por 
				FilrarVoosPorRota();
				break;
			case 3:
				ListarVoos();
				break;
			case 4:
				ApresentarMenuVoo();
				break;
			default:
				System.out.println("Opcão inválida");
				break;
			}

		} while (opcao != 3);
	}

	public void ApresentarMenuPassageiro() {

		int opcao;

		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
		do {
			System.out.println("1 - Listar passageiros");
			System.out.println("2 - Editar passageiros");
			System.out.println("3 - Adicionar passageiros");
			System.out.println("4 - Eliminar passageiros");
			System.out.println("5 - M�dia de passageiros");
			System.out.println("6 - Voltar ao menu anterior");

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
				//Funcao para mostrar a media dos passageiros
				break;
			case 6:
				MenuPrincipal();
				break;
				default:System.out.println("Opção inválida");
			}
		} while (opcao != 6);
	}

	public void MenuListaPassageiros2() {

		int opcao;
		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
		do {
			System.out.println("1 - Listar passageiros por voo");
			System.out.println("2 - Listar todos os passageiros");
			System.out.println("3 - Listar passageiros por dia");
			System.out.println("4 - Listar passageiros num intervalo de datas");
			System.out.println("5 - Voltar ao menu anterior");

			opcao = ler.nextInt();

			switch (opcao) {
			case 1: // funcao para listar por datas
				break;
			case 2:
				ListarTodosOsPassageiros();
				break;
			case 3:
				// Fun��o para apresentar voos em um dia
				break;
			case 4:
				//Fun��o para listar passageiros num intervalo de datas
				break;
			case 5:
				ApresentarMenuPassageiro();
				break;
			default:
				System.out.println("Opção inválida");
			}

		} while (opcao != 5);
	}

	public void ApresentarMenuTripulacao() {

		int opcao;

		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
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
				System.out.println("Opcão inválida");
			}
		} while (opcao != 5);
	}

	public void MenuAeronaves() {

		int opcao;

		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu
		System.out.println("## Selecione uma opção ##");

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
				System.out.println("Opção inválida!");
			}
		} while (opcao != 5);
	}

	public void MenuAeroportos() {

		int opcao;

		// escolher as op��es do menu consoante ao que o utilizador deseja, e repeti��o
		// do menu

		do {

			System.out.println("## Selecione uma opção ##");

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
				System.out.println("Opção Inválida!");

			}

		} while (opcao != 5);
	}

	/*
	 * 
	 * CONTROLO DE FUN��ES
	 * 
	 */

	// Fun��o para adicionar passageiros
	public void AdicionarPassageiros() {

		// Crio um objeto do tipo passageiro, e adiciono os dados
		Passageiros passageiro = new Passageiros();
		
		System.out.println("Indique o nº do Voo:");
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
		passageiro.setTelefone(ler.nextInt());

		System.out.println("Data de nascimento:");
		passageiro.setDataDeNascimento(ler.next());

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
		GravarFicheirosPass();

	}

	// fun��o para eliminar passageiros
	public void EliminarPassageiros() {

		Passageiros eliminarPassageiro = null;
		String idPassageiro;

		// pergunto ao utilizador o id do passageiro
		System.out.println("Insira o número da identidade do passageiro que deseja eliminar:");
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

	// Fun��o para editar algum passageiro
	public void EditarPassageiroCompleto() {

		String idPass;

		// identifico o passageiro
		System.out.println("Insira o número de identidade do passageiro que deseja editar:");
		idPass = ler.next();

		// percorro o array para ver se existe os dados inseridos
		for (Passageiros passageiros : passageiros) {
			if (idPass.equals(passageiros.getId())) {
				
				// edito todos os campos
				System.out.println("Indique o nº do Voo:");
				passageiros.setnVoo(ler.next());
				
				System.out.println("Insira o novo número de identidade do passageiro:");
				passageiros.setId(ler.next());

				System.out.println("Insira o novo nome do passageiro:");
				passageiros.setNome(ler.next());

				System.out.println("Insira a nova nacionalidade:");
				passageiros.setNacionalidade(ler.next());

				System.out.println("Insira a nova morada:");
				passageiros.setMorada(ler.next());

				System.out.println("Insira o novo telefone:");
				passageiros.setTelefone(ler.nextInt());

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

	// Fun��o para listar os passageiros do array
	public void ListarTodosOsPassageiros() {
		// Verifico se o array cont�m dados
		if (passageiros.isEmpty()) {
			System.out.println("Não existem passageiros registados!");
			System.out.println(" ");
		} else {
			// Se cont�m, percorro o array e mostro ao utilizador
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

	// Fun��o para adicionar tripulantes
	public void AdicionarPessoalCabine() {
		// Preencho os dados
		Tripulacao tripulacao = new Tripulacao();
		
		System.out.println("Indique o nº do Voo:");
		tripulacao.setnVoo(ler.next());

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

		// Adiciono ao array
		this.tripulacao.add(tripulacao);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Tripulante adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		// Gravo para ficheiros
		GravarFicheirosTripulantes();

		// Volto ao menu
		ApresentarMenuTripulacao();
	}

	// Fun��o para listar tripulantes
	public void ListarPessoalCabine() {

		// Verifico se cont�m dados no array
		if (tripulacao.isEmpty()) {
			System.out.println("Não existem tripulantes registrados!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro o conte�do dele
			for (Tripulacao tripulacao : tripulacao) {
				System.out.println(tripulacao);
			}

			// Volto ao menu anterior
			ApresentarMenuTripulacao();
		}
	}

	// Fun��o para eliminar um tripulante
	public void ElminarCabine() {

		Tripulacao eliminarCabine = null;
		String nomeCabine;

		// Pe�o ao utilizador o nome do tripulante
		System.out.println("Insira o nome do tripulante que deseja eliminar:");
		nomeCabine = ler.next();

		// Percorro o array para ver se encontro o nome
		for (Tripulacao tripulacao : tripulacao) {
			if (nomeCabine.equals(tripulacao.getNome())) {
				eliminarCabine = tripulacao;
				break;
			}
		}

		// Se encontrar, elimino do array
		if (eliminarCabine != null) {
			tripulacao.remove(eliminarCabine);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Tripulante eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}

	}

	// Fun��o para editar os dados de um tripulante
	public void EditarCabine() {

		
		String idTripulante;

		// Pergunto ao utilizador a identidade do tripulante
		System.out.println("Insira o número de identidade do tripulante que deseja editar:");
		idTripulante = ler.next();

		// Percorro o array para encontrar o id
		for (Tripulacao tripulacao : tripulacao) {
			if (idTripulante.equals(tripulacao.getId())) {
				

				// Edito os dados
				System.out.println("Indique o nº do Voo:");
				tripulacao.setnVoo(ler.next());
				
				System.out.println("Insira o novo número de identidade do tripulante:");
				tripulacao.setId(ler.next());

				System.out.println("Insira o novo nome do tripulante:");
				tripulacao.setNome(ler.next());

				System.out.println("Insira a nova nacionalidade:");
				tripulacao.setNacionalidade(ler.next());

				System.out.println("Insira a nova morada:");
				tripulacao.setMorada(ler.next());

				System.out.println("Insira o novo telefone:");
				tripulacao.setTelefone(ler.nextInt());

				System.out.println("Insira a nova data de nascimento:");
				tripulacao.setDataDeNascimento(ler.next());

				System.out.println("Insira a nova licença:");
				tripulacao.setnLincenca(ler.nextInt());

				System.out.println("Insira a nova data de validade:");
				tripulacao.setDataDeValidade(ler.next());

				System.out.println("Insira as novas anotações:");
				tripulacao.setAnotacoes(ler.next());

				System.out.println("Insira a nova categoria:");
				tripulacao.setCategoria(ler.next());

				System.out.println(" ");

				// Mensagem ao utilizador se conseguir
				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

			} else {
				// Mensagem ao utilizador se n�o encontrar o tripulante
				System.out.println("Tripulante não encontrado!");

				ApresentarMenuPassageiro();
			}
		}
	}

	/*
	 * 
	 * CONTROLO DE VOOS
	 * 
	 */

	// Fun��o para eliminar um voo
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

	// Fun��o para adicionar um voo
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

	// Fun��o para listar os voos
	public void ListarVoos() {

		// Verifico se existem dados registrados
		if (voos.isEmpty()) {
			System.out.println("Não existem voos registados!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro os dados
			for (Voo voo : voos) {
				System.out.println(voo);
			}

			ApresentarMenuVoo();
		}

	}

	// Fun��o para editar os dados de um voo
	public void EditarVoosCompleto() {

		Voo editarVoo = new Voo();
		String numeroVoo;

		// Pergunto ao utilizador os n�mero do voo
		System.out.println("Insira o número do voo que deseja editar:");
		numeroVoo = ler.next();

		// Percorro o array, encontro os dados e altero
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
				// Se n�o encontrar, mostro a mensagem
				System.out.println("Voo não encontrado!");
				System.out.println(" ");

				ApresentarMenuVoo();
			}
		}

	}

	public void FiltrarVoosPorData() {
        LocalDate dataInicioPesquisa;
        LocalDate dataFimPesquisa;
		        
        System.out.println("Insira uma data de início (dd/MM/aaaa)");
        dataInicioPesquisa = LerData();
        
        System.out.println("Insira uma data fim (dd/MM/aaaa)");
        dataFimPesquisa = LerData();
        
        for (Voo voo : voos) {
            if (voo.getDataDePartida().isAfter(dataInicioPesquisa) && voo.getDataDeChegada().isBefore(dataFimPesquisa)) {
            	System.out.println(voo);
            }
        }
	}
	
	public void FilrarVoosPorRota() {
		String aeroportoOrigem;
		String aeroportoDestino;
		
		System.out.println("Insira o aeroporto de origem");
		aeroportoOrigem = ler.next();
		System.out.println("Insira o aeroporto de destino");
		aeroportoDestino = ler.next();
		
		for (Voo voo : voos) {
			if (voo.getAeroOrigem().equalsIgnoreCase(aeroportoOrigem) && (voo.getAeroDestino().equalsIgnoreCase(aeroportoDestino))) {
				System.out.println(voo);
			}
		}
	}
	
	/*
	 * 
	 * CONTROLO DE AERONAVES
	 * 
	 */

	// Fun��o para adicionar aeronaves
	public void AdicionarAaeronaves() {

		Aeronave aeronaves = new Aeronave();

		// Prencho os dados
		System.out.println("Insira o número de registo:");
		aeronaves.setnRegistro(ler.next());

		System.out.println("Insira a marca/modelo:");
		aeronaves.setMarcaEmodelo(ler.next());

		System.out.println("Insira o número de lugares na classe executiva:");
		aeronaves.setNlugaresExecutiva(ler.nextInt());

		System.out.println("Insira o número de lugares na classe turística:");
		aeronaves.setNlugaresTuristica(ler.nextInt());

		// adiciono ao array
		this.aeronave.add(aeronaves);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Aeronave adicionada com sucesso!");
		System.out.println("\n-------------------------------------");

		// Gravo para ficheiros
		GravarFicheirosAeronave();

	}

	// Fun��o para listar aeronaves
	public void ListarAeronaves() {

		// Verifico se cont�m dados
		if (aeronave.isEmpty()) {
			System.out.println("Não existem aeronaves registadas!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro os dados
			for (Aeronave aeronaves : aeronave) {
				System.out.println(aeronaves);
			}

			MenuAeronaves();
		}

	}
	

	// Fun��o para Eliminar aeronaves
	public void EliminarAeronaves() {

		Aeronave eliminarAeronave = null;
		String numAeronave;

		// Pergunto ao utilizador os dados
		System.out.println("Insira o número de registo da aeronave que deseja eliminar:");
		numAeronave = ler.next();

		// Percoro o array e comparo para ver se os dados s�o iguais
		for (Aeronave aeronaves : aeronave) {
			if (numAeronave.equals(aeronaves.getnRegistro())) {
				eliminarAeronave = aeronaves;
				break;
			}
		}
		// Se sim, elimino a aeronave
		if (numAeronave != null) {
			aeronave.remove(eliminarAeronave);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Aeronave eliminada com sucesso!");
			System.out.println("\n-------------------------------------");
		}

		MenuAeronaves();
	}

	// Fun��o para editar os dados de uma aeronave
	public void EditarAeronaves() {

		Aeronave editarAeronave = new Aeronave();
		String numeroAeronave;

		// Pergunto ao utilizador a aeronave que ele quer editar
		System.out.println("Insira o número de registo da aeronave que deseja editar:");
		numeroAeronave = ler.next();

		// Percorro o array para ver se encontro, e edito os dados
		for (Aeronave aeronaves : aeronave) {
			if (numeroAeronave.equals(aeronaves.getnRegistro())) {
				editarAeronave = aeronaves;

				System.out.println("Insira o novo número de registo:");
				editarAeronave.setnRegistro(ler.next());

				System.out.println("Insira a nova marca/modelo:");
				editarAeronave.setMarcaEmodelo(ler.next());

				System.out.println("Insira o novo número de lugares da classe executiva:");
				editarAeronave.setNlugaresExecutiva(ler.nextInt());

				System.out.println("Insira o novo número de lugares da classe turística:");
				editarAeronave.setNlugaresTuristica(ler.nextInt());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

				// GravarFicheirosAeronaves();

				MenuAeronaves();

			} else {

				// Menssagem ao utilizador caso n�o encontre
				System.out.println("Aeronave não encontrada!");

			}
		}

	}

	/*
	 * 
	 * CONTROLO DE AEROPORTOS
	 * 
	 */

	// Fun��o para adicionar um aeroporto
	public void AdicionarAaeroporto() {

		Aeroporto aeroportos = new Aeroporto();

		// Adiciono os dados
		System.out.println("Insira a sigla do aeroporto:");
		aeroportos.setSigla(ler.next());

		System.out.println("Insira o país:");
		aeroportos.setPais(ler.next());

		System.out.println("Insira a cidade mais próxima:");
		aeroportos.setCidadeProx(ler.next());

		// Adiciono ao array
		this.aeroporto.add(aeroportos);

		System.out.println(" ");

		// Mensagem ao utilizador
		System.out.println("Aeroporto adicionado com sucesso!");
		System.out.println("\n-------------------------------------");

		GravarFicheirosAeroporto();

	}

	// Fun��o para listar os aeroportos
	public void ListarAaeroportos() {

		// Verifico se existem dados registados
		if (aeroporto.isEmpty()) {
			System.out.println("Não existem aeroportos registrados!");
			System.out.println(" ");
		} else {

			// Percorro o array e mostro o conte�do
			for (Aeroporto aeroportos : aeroporto) {
				System.out.println(aeroportos);
			}

			MenuAeroportos();
		}

	}

	// Fun��o para eliminar um aeroporto
	public void EliminarAeroportos() {

		Aeroporto eliminarAeroporto = null;
		String sigla;

		// Pergunto ao utilizador a sigla do aeroporto
		System.out.println("Insira a sigla do aeroporto que deseja eliminar:");
		sigla = ler.next();

		// Percorro o array para encontrar os dados inseridos
		for (Aeroporto aeroporto : aeroporto) {
			if (sigla.equals(aeroporto.getSigla())) {
				eliminarAeroporto = aeroporto;
				break;
			}
		}
		// Se encontrar, removo do array
		if (eliminarAeroporto != null) {
			aeroporto.remove(eliminarAeroporto);

			System.out.println(" ");

			// Mensagem ao utilizador
			System.out.println("Aeroporto eliminado com sucesso!");
			System.out.println("\n-------------------------------------");
		}

		MenuAeroportos();

	}

	// Fun��o para editar aeroporto
	public void EditarAeroportos() {
		
		String sigla;

		// Pergunto ao utilizador a sigla
		System.out.println("Insira a sigla do aeroporto que deseja editar:");
		sigla = ler.next();

		// Percorro o array para encontrar os dados
		for (Aeroporto aeroportos : aeroporto) {
			if (sigla.equals(aeroportos.getSigla())) {

			
				// Se encontrado, edito os dados
				System.out.println("Insira a nova sigla:");
				aeroportos.setSigla(ler.next());

				System.out.println("Insira o novo país:");
				aeroportos.setPais(ler.next());

				System.out.println("Insira a nova cidade mais próxima:");
				aeroportos.setCidadeProx(ler.next());

				System.out.println(" ");

				System.out.println("Editado com sucesso!");
				System.out.println("\n-------------------------------------");

				// GravarFicheirosAeroportos();

				MenuAeroportos();

			} else {

				// Se n�o, mensagem ao utilizador
				System.out.println("Aeroporto não encontrado!");
			}
		}

	}

	/*
	 * 
	 * CONTROLO DE FICHEIROS
	 * 
	 */

	// Fun��o para ler os dados do ficheiro
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
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
				LocalDate DataDePartida =  LocalDate.parse(partes[4], formatter);       
				LocalDate DataDeChegada = LocalDate.parse(partes[5], formatter);
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

	// Fun��o para ler os dados do ficheiro
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
				String nVoo = partes[1];
				String nome = partes[2];
				String nacionalidade = partes[3];
				String morada = partes[4];
				int telefone = Integer.parseInt(partes[5]);
				String dataDeNascimento = partes[6];
				String email = partes[7];
				String tipoBilhete = partes[8];
				String lugarReservado = partes[9];

				Passageiros passageiros = new Passageiros(id, nVoo, nome, nacionalidade, morada, telefone, dataDeNascimento,
						email, tipoBilhete, lugarReservado);

				this.passageiros.add(passageiros);

			}

			ler.close();

		} catch (IOException Ex) {
			System.out.println(Ex.getMessage());
		}
	}

	// Fun��o para guardar os dados no ficheiro
	public void GravarFicheirosVoos() {

		String resposta;

		System.out.println("Deseja gravar as alterações (S/N)?");
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

	// Fun��o para guardar os dados no ficheiro
	public void GravarFicheirosPass() {
		String resposta;

		System.out.println("Deseja gravar as alterações (S/N)?");
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

	// Fun��o para ler os dados do ficheiro
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

	// Fun��o para guardar os dados no ficheiro
	public void GravarFicheirosAeroporto() {

		String resposta;

		System.out.println("Queres salvar as alterações (S/N)?");
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

	// Fun��o para ler os dados do ficheiro
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

	// Fun��o para guardar os dados no ficheiro
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

	// Fun��o para ler os dados do ficheiro
	public void LerFicheirosTripulantes() {

		// Agora vou abrir os Reader
		try {
			FileReader fr = new FileReader("C:\\Users\\asaph\\Desktop\\Aero\\Teste3.txt");
			BufferedReader ler = new BufferedReader(fr);
			// Ler o texto q foi escrito usando o BufferedReader
			String linha;

			while (ler.ready()) {
				linha = ler.readLine();
				String[] partes = linha.split("\\|");

				String id = partes[0];
				String nVoo = partes [1];
		        String nome = partes[2];
		        String nacionalidade = partes[3];
		        String morada = partes[4];
		        int telefone = Integer.parseInt(partes[5]);
		        String dataDeNascimento = partes[6];
		        int nLincenca = Integer.parseInt(partes[7]);
		        String dataDeValidade = partes[8];
		        String anotacoes = partes[9];
		        String categoria = partes[10];

		        Tripulacao tripulantes = new Tripulacao(id, nVoo, nome, nacionalidade, morada,
		            telefone, dataDeNascimento, nLincenca, dataDeValidade, anotacoes, categoria );

		        this.tripulacao.add(tripulantes);

			}

			ler.close();

		} catch (IOException Ex) {
			System.out.println(Ex.getMessage());
		}			
	}

	// Fun��o para guardar os dados no ficheiro
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
					 	 linha += tripulantes.getnVoo() + "|";
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
				 System.out.println(Ex.getMessage()); 
			 }
		 }
	}

	//Função para ler e converter data
	public LocalDate LerData() {
		try {
			LocalDate data;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        	data = LocalDate.parse(ler.next(), formatter);		
        	return data;
		}catch(Exception ex) {
			System.out.println("Data invalida, insira uma data com o formato (dd/MM/aaaa)");
			return LerData();
		}
	}

}


