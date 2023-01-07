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
		System.out.println("Bem vindo a aplica��o para companhia a�rea");

		LerCompanhiaAerea();
		MenuPrincipal();
	}

	public void LerCompanhiaAerea() {
		System.out.println("Qual a companhia a�rea?");

		companhia = ler.next();

	}

	public void MenuPrincipal() {
		System.out.println("");
		System.out.println("## Menu principal ##");
		System.out.println("Companhia selecionada: " + companhia);
		System.out.println("Selecione uma op��o");

		System.out.println("1 - Voo");
		System.out.println("2 - Passageiro");
		System.out.println("3 - Tripula��o");

		switch (this.ler.nextInt()) {
		case 1:
			ApresentarMenuVoo();
			break;

		case 2:
			ApresentarMenuPassageiro();
			break;

		case 3:
			ApresentarMenuTripula��o();
			break;

		default:
			System.out.println("Op��o Inv�lida");
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
		case 1: // fun��o para listar voos
			break;
		case 2: // fun��o para editar voos
			break;
		case 3: // fun��o para adicionar voos
			break;
		case 4: // fun��o para eliminar voos
			break;
		case 5:
			MenuPrincipal();
	
			default: System.out.println("Op��o inv�lida");
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

		case 1: // fun��o para listar passageiros
			break;
		case 2: // fun��o para editar passageiros
			break;
		case 3: // fun��o para adicionar passageiros
			break;
		case 4: // fun��o para eliminar passageiros
			break;
		case 5:
			MenuPrincipal();
			
		default: System.out.println("Op��o inv�lida");
		MenuPrincipal();
		}
	}

	public void ApresentarMenuTripula��o() {

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

		case 1: // fun��o para listar cabine
			break;
		case 2: // fun��o para editar cabine
			break;
		case 3: // fun��o para adicionar cabine
			break;
		case 4: // fun��o para eliminar cabine
			break;
		case 5: // fun��o para listar pilotos
			break;
		case 6: // fun��o para editar pilotos
			break;
		case 7: // fun��o para adicionar pilotos
			break;
		case 8: // fun��o para eliminar pilotos
			break;
		case 9:
			
			MenuPrincipal();
		default: System.out.println("Op��o inv�lida");
		MenuPrincipal();

		}
	}

	public void AdicionarVoos() {
		
		
	}
}
