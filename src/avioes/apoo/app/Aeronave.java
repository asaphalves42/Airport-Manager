package avioes.apoo.app;

public class Aeronave {
	private String nRegistro;
	private String marcaEmodelo;
	private int NlugaresTuristica;
	private int NlugaresExecutiva;
	
	public Aeronave(String nRegistro, String marcaEmodelo, int nlugaresTuristica, int nlugaresExecutiva) {
		super();
		this.nRegistro = nRegistro;
		this.marcaEmodelo = marcaEmodelo;
		this.NlugaresTuristica = nlugaresTuristica;
		this.NlugaresExecutiva = nlugaresExecutiva;
	}

	public Aeronave() {
		
	}

	public String getnRegistro() {
		return nRegistro;
	}

	public void setnRegistro(String nRegistro) {
		this.nRegistro = nRegistro;
	}

	public String getMarcaEmodelo() {
		return marcaEmodelo;
	}

	public void setMarcaEmodelo(String marcaEmodelo) {
		this.marcaEmodelo = marcaEmodelo;
	}

	public int getNlugaresTuristica() {
		return NlugaresTuristica;
	}

	public void setNlugaresTuristica(int nlugaresTuristica) {
		NlugaresTuristica = nlugaresTuristica;
	}

	public int getNlugaresExecutiva() {
		return NlugaresExecutiva;
	}

	public void setNlugaresExecutiva(int nlugaresExecutiva) {
		NlugaresExecutiva = nlugaresExecutiva;
	}

	@Override
	public String toString() {
		return "Aeronaves [\nNúmero de registro: " + nRegistro + "\nMarca/modelo: " + marcaEmodelo + "\nN�mero de lugares tur�stica: "
				+ NlugaresTuristica + "\nN�mero de lugares executiva: " + NlugaresExecutiva + "]" + "\n----------------------------------";
	}
	
	
}
