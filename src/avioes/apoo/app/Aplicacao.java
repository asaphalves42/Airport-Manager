package avioes.apoo.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
	
	public static String companhia;

	Scanner ler = new Scanner(System.in);
	
	public static ArrayList<Tripulacao> tripulacao = new ArrayList<>();
	public static ArrayList<Passageiros> passageiros = new ArrayList<>();
	public static ArrayList<Voo> voos = new ArrayList<>();
	public static ArrayList<Aeronave> aeronave = new ArrayList<>();

	public void Iniciar() {
		System.out.println("Bem vindo a aplicação para companhia aérea");

		LerCompanhiaAerea();
		MenuPrincipal();
	}

	public void LerCompanhiaAerea() {
		System.out.println("Qual a companhia aérea?");

		companhia = ler.next();

	}

	public void MenuPrincipal() {
		System.out.println("");
		System.out.println("## Menu principal ##");
		System.out.println("Companhia selecionada: " + companhia);
		System.out.println("Selecione uma opção");

		System.out.println("1 - Voo");
		System.out.println("2 - Passageiro");
		System.out.println("3 - Tripulação");

		switch (this.ler.nextInt()) {
		case 1:
			ApresentarMenuVoo();
			break;

		case 2:
			ApresentarMenuPassageiro();
			break;

		case 3:
			ApresentarMenuTripulação();
			break;

		default:
			System.out.println("Opção Inválida");
			MenuPrincipal();
		}
	}

	public void ApresentarMenuVoo() {

		System.out.println("1 - Listar voos");
		System.out.println("2 - Editar voos");
		System.out.println("3 - Adicionar voos");
		System.out.println("4 - Eliminar voos");
		System.out.println("5 - Voltar ao menu anterior");

		switch (ler.nextInt()) {
		case 1: // função para listar voos
			break;
		case 2: // função para editar voos
			break;
		case 3: // função para adicionar voos
			break;
		case 4: // função para eliminar voos
			break;
		case 5:
			MenuPrincipal();
	
			default: System.out.println("Opção inválida");
			MenuPrincipal();

		}

	}

	public void ApresentarMenuPassageiro() {

		System.out.println("1 - Listar passageiros");
		System.out.println("2 - Editar passageiros");
		System.out.println("3 - Adicionar passageiros");
		System.out.println("4 - Eliminar passageiros");
		System.out.println("5 - Voltar ao menu anterior");

		switch (ler.nextInt()) {

		case 1: // função para listar passageiros
			break;
		case 2: // função para editar passageiros
			break;
		case 3: // função para adicionar passageiros
			break;
		case 4: // função para eliminar passageiros
			break;
		case 5:
			MenuPrincipal();
			
		default: System.out.println("Opção inválida");
		MenuPrincipal();
		}
	}

	public void ApresentarMenuTripulação() {

		System.out.println("1 - Listar pessoal cabine");
		System.out.println("2 - Editar pessoal cabine");
		System.out.println("3 - Adicionar pessoal cabine");
		System.out.println("4 - Eliminar pessoal cabine");

		System.out.println("5 - Listar pilotos");
		System.out.println("6 - Editar pilotos");
		System.out.println("7 - Adicionar pilotos");
		System.out.println("8 - Eliminar pilotos");
		System.out.println("9 - Voltar ao menu anterior");

		switch (ler.nextInt()) {

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
		case 9:
			
			MenuPrincipal();
		default: System.out.println("Opção inválida");
		MenuPrincipal();

		}
	}

	public void AdicionarVoos() {
		
		
	}
}
